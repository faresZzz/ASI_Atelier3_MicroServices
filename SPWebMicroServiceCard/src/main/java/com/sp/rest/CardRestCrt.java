package com.sp.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.model.CardDto;
import com.model.ListCardDtoWrapper;
import com.sp.service.CardService;


@RestController
public class CardRestCrt {


	@Autowired
	CardService cService;

	@RequestMapping(method = RequestMethod.POST, value = "/card/createCard")
	public CardDto addCard(@RequestBody CardDto card) {
		CardDto newCard = cService.addCard(card);

		return newCard;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/card/cards")
	public ListCardDtoWrapper getAllCards() {
		List<CardDto> cards = cService.getAllCards();
		ListCardDtoWrapper listCard = new ListCardDtoWrapper();
		listCard.setListCard(cards);
		return listCard;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/card/getCard/{id}")
	public CardDto getCard(@PathVariable String id) {
		CardDto card = cService.getCard(Integer.valueOf(id));
		return card;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/card/getCardByOwner/{ownerId}")
	public ListCardDtoWrapper getCardByOwner(@PathVariable Integer ownerId)
	{
		ListCardDtoWrapper listCard = new ListCardDtoWrapper();
		listCard.setListCard(cService.getCardByOwner(ownerId));
		return listCard;
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/card/update/{id}")
	public void update(@PathVariable String id, @RequestBody CardDto card)
	{
		cService.update(Integer.valueOf(id), card);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/card/randcard/{n}")
	public ListCardDtoWrapper getRandCard(@PathVariable String n)
	{
		ListCardDtoWrapper listCard = new ListCardDtoWrapper();
		
		listCard.setListCard( cService.getRandomCard(Integer.valueOf(n)));
		
		return listCard;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/card/onMarket")
	public ListCardDtoWrapper getCardsOnMarket()
	{
		ListCardDtoWrapper listCard = new ListCardDtoWrapper();
		listCard.setListCard(cService.getCardOnMarket());
		return listCard;
	}
	
}
