package com.sp.service;




import org.springframework.beans.factory.annotation.Autowired;

import com.sp.model.Card;
import com.sp.model.User;

import antlr.collections.List;

public class TransactionService {
	
	@Autowired
	UserService uService;
	@Autowired
	CardService cService;
	
	private User getUser(int userId)
	{
		return  uService.getUserById(userId);
	}
	
	private Card getCard(int cardId)
	{
		return  cService.getCard(cardId);
	}
	
	public void sellCard(int userId, int cardId)
	{
		User u = getUser(userId);
		Card c = getCard(cardId);
		
		java.util.List<Card> userCardList = u.getListCards();
		
		boolean userOwnCard = false;
		for (Card card : userCardList)
		{
			if (card.getId() == cardId)
			{
				userOwnCard = true;
				break;
			}
		}
		
		if (userOwnCard)
		{
			Card card = u.deleteCard(cardId);
			card.setSell(true);
			u.setBank(u.getBank() + card.getValue());
		}
		/// verifier si l'utilisateur possede bien la carte
		// mettre la carte en vente
		// retirer la carte de la liste de l'utilisteur
		// ajouter l'argent a l'utilisateur
	}
	
	
	public void buyCard(int userId, int cardId)
	{
		User u = getUser(userId);
		Card c = getCard(cardId);
		if (c.isSell())
		{
			if (u.getBank() >= c.getValue())
			{
				c.setSell(false);
				u.setBank(u.getBank() - c.getValue());
				u.addCard(c);
			}
			
		}
		
		// verifier que la carte est bien en vente
		// verifier que l'utilisateur a assez d'argent
		// retirer la carte de la vente
		// debiter l'utilisteur de la valeur de la carte
		// ajouter la carte a la liste carte de l'utilisateur
	}
		
}
