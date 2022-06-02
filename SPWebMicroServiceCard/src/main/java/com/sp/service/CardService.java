package com.sp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.CardDto;
import com.sp.model.Card;
import com.sp.repository.CardRepository;


@Service
public class CardService {
	
	@Autowired
	CardRepository cardRepository;
	
	private CardDto cardToCardDto(Card card)
	{
		CardDto cardDto = new CardDto(card.getId(), card.getPrice(), card.getName(), card.getDescription(), card.getImgUrl(), card.getFamily(), card.getAffinity(), card.getHp(), card.getEnergy(), card.getAttack()
				, card.getDefence(), card.getOwnerId(), card.isOnMarket());
//		BeanUtils.copyProperties(card, cardDto);
		
		
		return cardDto;

	}
	
	private Card cardDtoToCard(CardDto cardDto)
	{
		Card card = new Card(cardDto.getId(), cardDto.getPrice(), cardDto.getName(),  cardDto.getDescription(), cardDto.getImgUrl(), cardDto.getFamily(), cardDto.getAffinity(), cardDto.getHp(), cardDto.getEnergy(), cardDto.getAttack(), 
				cardDto.getDefence(), cardDto.isOnMarket());
//		BeanUtils.copyProperties(cardDto, card);
		return card;

	}
	
	public CardDto addCard(CardDto card) {
		Card createdCard = cardRepository.save(this.cardDtoToCard(card));
		System.out.println(createdCard);
		return this.cardToCardDto(createdCard);
	}

	public CardDto getCard(int id) {
		Optional<Card> cardOpt = cardRepository.findById(id);
		if (cardOpt.isPresent()) {
			return this.cardToCardDto(cardOpt.get());
		} else {
			return null;
		}
	}
	
	public List<CardDto> getAllCards() {
		List<Card> cards = cardRepository.findAll();
		List<CardDto> cardsDto = new ArrayList<CardDto>();
		
		for (Card card : cards)
		{
			cardsDto.add(this.cardToCardDto(card));
		}
		return cardsDto;
	}
	
	public List<CardDto> getRandomCard(int n)
	{
		List<Card> cardsList = cardRepository.findByOwnerId(0);  // get all card with ownerId = 0 so all free cards
		
		if (cardsList.size() >= n)
		{
			List<CardDto> listRandomCard = new ArrayList<>();
			
			for (int i = 0; i < n; i++)
			{
				Random randomGenerator = new Random();
				int index=randomGenerator.nextInt(cardsList.size());
				listRandomCard.add( this.cardToCardDto(cardsList.get(index)) );  // return the converted version of the random card choosed 
				
			}
			
			return listRandomCard;
		}
		else
		{
			this.addCard(new CardDto());
			return this.getRandomCard(n);
		}
		
	}
	
	public List<CardDto> getCardByOwner(int ownerId)
	{
		List<Card> cards = cardRepository.findByOwnerId(ownerId);
		List<CardDto> cardsDto = new ArrayList<CardDto>();
		
		for (Card card : cards)
		{
			cardsDto.add(this.cardToCardDto(card));
		}
		return cardsDto;
	}
	
	public CardDto update(int id, CardDto cardDto)
	{
		Card card = this.cardDtoToCard(cardDto);
		Card cardUpdated = cardRepository.save(card);
			
		return this.cardToCardDto(cardUpdated);
		
	}

	public List<CardDto> getCardOnMarket() {
		
		List<Card> cardsOnMarket = cardRepository.findByOnMarketTrue();
		List<CardDto> cardsDto = new ArrayList<CardDto>();
		
		for (Card card : cardsOnMarket)
		{
			cardsDto.add(this.cardToCardDto(card));
		}
		return cardsDto;
	}
}
