package com.sp.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.model.CardDto;
import com.sp.service.TransactionService;


@RestController
public class TransactionRestCrt {
	
	@Autowired
	TransactionService tService;
	
	
	@RequestMapping(method = RequestMethod.PUT, value = "/sellCard/{cardId}/{price}")
	public List<CardDto> sellCard(@PathVariable String cardId , @PathVariable String price,  @RequestBody String param) {
		
		return tService.sellCard(Integer.valueOf(cardId) , Integer.valueOf(price), 1);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/buyCard/{buyerId}/{cardId}")
	public void buyCard(@PathVariable String buyerId, @PathVariable String cardId) {
		tService.buyCard(Integer.valueOf(buyerId), Integer.valueOf(cardId));
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/sell/{userId}")
	public List<CardDto> displaySellMarket(@PathVariable String userId) {
		return tService.displaySellMarket(Integer.valueOf(userId));
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/buy/{userId}")
	public List<CardDto> displayBuyMarket(@PathVariable String userId) {
		return tService.displayBuyMarket(Integer.valueOf(userId));
	}

}
