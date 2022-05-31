package com.sp.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.model.Card;
import com.sp.repository.CardRepository;


@Service
public class CardService {
	
	@Autowired
	CardRepository cardRepository;

	public Card addCard(Card card) {
		Card createdCard = cardRepository.save(card);
		System.out.println(createdCard);
		return createdCard;
	}

	public Card getCard(int id) {
		Optional<Card> cardOpt = cardRepository.findById(id);
		if (cardOpt.isPresent()) {
			return cardOpt.get();
		} else {
			return null;
		}
	}
	
	public List<Card> getAllCards() {
		List<Card> cards = cardRepository.findAll();
		return cards;
	}
	
	public Card getRandomCard()
	{
		List<Card> cardsList = getAllCards();
		
		Random randomGenerator = new Random();
		int index=randomGenerator.nextInt(cardsList.size());
		return cardsList.get(index);
	}

}
