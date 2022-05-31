package com.sp.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sp.model.User;
import com.sp.service.TransactionService;

public class TransactionRestCrt {
	
	@Autowired
	TransactionService tService;
	
	
	@RequestMapping(method = RequestMethod.PUT, value = "/sellCard/{userId}/{cardId}")
	public void sellCard(@PathVariable String userId, String cardId) {
		tService.sellCard(Integer.valueOf(userId), Integer.valueOf(cardId));
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/buyCard/{userId}/{cardId}")
	public void buyCard(@PathVariable String userId, String cardId) {
		tService.buyCard(Integer.valueOf(userId), Integer.valueOf(cardId));
	}

}
