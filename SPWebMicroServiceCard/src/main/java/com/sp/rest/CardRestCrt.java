package com.sp.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.model.CardDto;
import com.model.ListCardDtoWrapper;
import com.sp.service.CardService;


@RestController
@CrossOrigin
@RequestMapping("/card")
public class CardRestCrt {


	@Autowired
	CardService cService;

	@RequestMapping(method = RequestMethod.POST, value = "/createCard")
	public CardDto addCard(@RequestBody CardDto card) {
		CardDto newCard = cService.addCard(card);

		return newCard;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/cards")
	public ListCardDtoWrapper getAllCards() {
		List<CardDto> cards = cService.getAllCards();
		ListCardDtoWrapper listCard = new ListCardDtoWrapper();
		listCard.setListCard(cards);
		return listCard;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/getCard/{id}")
	public CardDto getCard(@PathVariable String id) {
		CardDto card = cService.getCard(Integer.valueOf(id));
		return card;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/getCardByOwner/{ownerId}")
	public ListCardDtoWrapper getCardByOwner(@PathVariable Integer ownerId)
	{
		ListCardDtoWrapper listCard = new ListCardDtoWrapper();
		listCard.setListCard(cService.getCardByOwner(ownerId));
		return listCard;
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/update/{id}")
	public boolean update(@PathVariable String id, @RequestBody CardDto card)
	{
		if (cService.update(Integer.valueOf(id), card) != null)
		{
			return true;
		}
		return false;
		
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/randcard/{n}")
	public ListCardDtoWrapper getRandCard(@PathVariable String n)
	{
		ListCardDtoWrapper listCard = new ListCardDtoWrapper();
		
		listCard.setListCard( cService.getRandomCard(Integer.valueOf(n)));
		
		return listCard;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/onMarket/{userId}")
	public ListCardDtoWrapper getCardsOnMarket(@PathVariable String userId)
	{
		ListCardDtoWrapper listCard = new ListCardDtoWrapper();
		listCard.setListCard(cService.getCardOnMarket(Integer.valueOf(userId)));
		return listCard;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/cardToSell/{userId}")
	public ListCardDtoWrapper getCardsToSell(@PathVariable String userId)
	{
		ListCardDtoWrapper listCard = new ListCardDtoWrapper();
		listCard.setListCard(cService.getCardToSell(Integer.valueOf(userId)));
		return listCard;
	}
}
