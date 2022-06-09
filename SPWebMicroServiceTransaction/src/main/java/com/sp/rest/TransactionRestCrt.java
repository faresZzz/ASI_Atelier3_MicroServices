package com.sp.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.model.ListCardDtoWrapper;
import com.sp.service.TransactionService;


@RestController
@CrossOrigin
@RequestMapping("/market")
public class TransactionRestCrt {
	
	@Autowired
	TransactionService tService;
	
	
	@RequestMapping(method = RequestMethod.PUT, value = "/sellCard/{cardId}/{userId}")
	public boolean sellCard(@PathVariable String cardId , @PathVariable String userId, @RequestParam String price) {
		
		return tService.sellCard(Integer.valueOf(cardId) , Integer.valueOf(price), Integer.valueOf(userId));
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/buyCard/{buyerId}/{cardId}")
	public boolean buyCard(@PathVariable String buyerId, @PathVariable String cardId) {
		return tService.buyCard(Integer.valueOf(buyerId), Integer.valueOf(cardId));
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/sell/{userId}")
	public ListCardDtoWrapper displaySellMarket(@PathVariable String userId) {
		ListCardDtoWrapper listSellCard = new ListCardDtoWrapper();
		listSellCard.setListCard( tService.displaySellMarket(Integer.valueOf(userId)));
		
		return listSellCard;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/buy/{userId}")
	public ListCardDtoWrapper displayBuyMarket(@PathVariable String userId) {
		ListCardDtoWrapper listBuyCard = new ListCardDtoWrapper();
		listBuyCard.setListCard( tService.displayBuyMarket(Integer.valueOf(userId)));
		
		return listBuyCard;
	}

}
