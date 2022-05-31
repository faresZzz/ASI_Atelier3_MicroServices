package com.sp.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sp.model.Card;
import com.sp.service.CardService;


@RestController
public class CardRestCrt {


	@Autowired
	CardService cService;

	@RequestMapping(method = RequestMethod.POST, value = "/createCard")
	public Card addCard(@RequestBody Card card) {
		Card newCard = cService.addCard(card);
		return newCard;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/cards")
	public Iterable<Card> getAllCards() {
		Iterable<Card> cards = cService.getAllCards();
		return cards;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/card/{id}")
	public Card getCard(@PathVariable String id) {
		Card card = cService.getCard(Integer.valueOf(id));
		return card;
	}
}
