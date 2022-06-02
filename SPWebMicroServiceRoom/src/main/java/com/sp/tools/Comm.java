package com.sp.tools;



import java.util.List;


import org.springframework.web.client.RestTemplate;

import com.model.CardDto;
import com.model.ListCardDtoWrapper;
import com.model.UserDto;

public class Comm {
	
	private static final String URLCARD_SERVICE = "http://localhost:3080/card/";
	private static final String URLUSER_SERVICE = "http://localhost:3081/user/";
	
	
	public static UserDto getPlayer(int playerId)
	{
		RestTemplate restTemplate = new RestTemplate();
	
		UserDto userDto = restTemplate.getForObject(URLUSER_SERVICE + "getUserById/" + playerId, UserDto.class);
		
		return userDto;
	}


	public static CardDto getCard(int id) {
		
		RestTemplate restTemplate = new RestTemplate();
		
		CardDto card = restTemplate.getForObject(URLCARD_SERVICE + "getCard/" + id, CardDto.class);
		
		return card;
	}


	public static void updatePlayer(UserDto winner) 
	{

		RestTemplate restTemplate = new RestTemplate();

		// Data attached to the request.
		
		// Send request with PUT method.
		restTemplate.put(URLUSER_SERVICE + "update/" + winner.getId(), winner,  UserDto.class);
	}


	public static void updateCard(CardDto card) 
	{
		RestTemplate restTemplate = new RestTemplate();	

		// Send request with PUT method.
		restTemplate.put(URLCARD_SERVICE + "update/" + card.getId(), card, CardDto.class);
	}
	
}
