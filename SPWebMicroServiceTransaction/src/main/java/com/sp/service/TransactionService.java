package com.sp.service;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.CardDto;
import com.model.UserDto;
import com.sp.model.Transaction;
import com.sp.repository.TransactionRepository;
import com.sp.tools.Comm;



@Service
public class TransactionService {
	
	@Autowired
	TransactionRepository tRepository;
	
	public boolean sellCard(int cardId, int priceOnMarket, int userConnectId)
	{
		// mise en vente de la carte sur le market
		CardDto c = Comm.getCardById(cardId);
		
		if (c.getOwnerId() == userConnectId) // si la carte appartient bien a la personne conneté
		{
			// ajout la carte sur le marcher au prix de vente souhaité
			c.setPrice(priceOnMarket);
			c.setOnMarket(true);
			
			// update de la carte dans la DB
			Comm.updateCard(c);
			return true;
		}
		
		return false;
	}
	
	

	public boolean buyCard(int buyerId, int cardId)
	{
		// recuperation de la carte
		
		CardDto buyCard = Comm.getCardById(cardId);
		
		if (buyCard.isOnMarket())// si la carte est bien en vente
		{
			// recuperation de l'acheteur
			UserDto buyer = Comm.getUserById(buyerId);
			
			if (buyer.getBank() >= buyCard.getPrice())
			{
				// recuperation du vendeur
				UserDto seller = Comm.getUserById(buyCard.getOwnerId());
				
				// creation de la transation avant tout pour garder une trace si le systeme bug avant la fin 
				Transaction transaction = new Transaction(buyer.getId(), seller.getId(), buyCard.getId(), buyCard.getPrice());	
				tRepository.save(transaction); // on save la transaction avant de faire tout les updates pour pouvoir garder une trace s'il crache avant la fin des updates
				
				// realisation de la transaction
				buyCard.setOwnerId(buyer.getId()); // changement de proprio pour la carte 
				buyer.setBank(buyer.getBank() - buyCard.getPrice()); // retire l'argent du compte
				seller.deleteCard(buyCard.getId()); // retire la carte de la collection 
				
				buyCard.setOnMarket(false);
				buyer.addCard(buyCard.getId());// ajout de la carte a sa collection
				seller.setBank(seller.getBank() + buyCard.getPrice()); // recredite l'autre compte
				
				
				// mise a jour de tous les parties
				Comm.updateCard(buyCard);
				Comm.updateUser(buyer);
				Comm.updateUser(seller);
				
				System.out.println(transaction);
				
				return true; 
			
			}
		}
		return false;
		
	}


	
	
	public List<CardDto> displaySellMarket(Integer userId) {
		
		UserDto user = Comm.getUserById(userId);
		// recupere toutes les carte de l'utilisateurs, on s'occupe de trier coté client
		List<CardDto> listUserCard = Comm.getCardsToSell(userId);
		
		return listUserCard;
	}



	public List<CardDto> displayBuyMarket(int userId) {

		return Comm.getCardOnMarket(userId);
		
		
	}
		
}
