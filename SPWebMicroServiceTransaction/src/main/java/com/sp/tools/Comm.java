package com.sp.tools;


import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.model.CardDto;
import com.model.ListCardDtoWrapper;
import com.model.UserDto;

public class Comm {
	
	private static final String URLCARD_SERVICE = "http://localhost:3080/card/";
	private static final String URLUSER_SERVICE = "http://localhost:3081/user/";
	
	
	public static UserDto getUserBySurname(String surname)
	{
		RestTemplate restTemplate = new RestTemplate();
	
		UserDto userDto = restTemplate.getForObject(URLUSER_SERVICE + "getUserBySurname/" + surname, UserDto.class);
		
		return userDto;
	}
	
	public static UserDto getUserById(int id)
	{
		RestTemplate restTemplate = new RestTemplate();
	
		UserDto userDto = restTemplate.getForObject(URLUSER_SERVICE + "getUserById/" + id, UserDto.class);
		
		return userDto;
	}
	
	


	public static CardDto getCardById(int cardId) {
		RestTemplate restTemplate = new RestTemplate();
		
		CardDto cardDto = restTemplate.getForObject(URLCARD_SERVICE + "getCard/" + cardId, CardDto.class);
		
		return cardDto;
		
	}
	
	public static void updateCard(CardDto card)
	{
		RestTemplate restTemplate = new RestTemplate();	

		// Send request with PUT method.
		restTemplate.put(URLCARD_SERVICE + "update/"+card.getId(), card);
	}
	
	public static void updateUser(UserDto user)
	{
		
		RestTemplate restTemplate = new RestTemplate();

		// Data attached to the request.
		
		// Send request with PUT method.
		restTemplate.put(URLUSER_SERVICE + "update/" + user.getId(), UserDto.class);
		
	}

	
	public static List<CardDto> getCardsByUser(Integer userId) {
		RestTemplate restTemplate = new RestTemplate();
		
		ListCardDtoWrapper wrapper = restTemplate.getForObject(URLCARD_SERVICE + "/getCardByOwner/" + userId, ListCardDtoWrapper.class);
		
		return wrapper.getListCard();
	}

	public static List<CardDto> getCardOnMarket() {
		RestTemplate restTemplate = new RestTemplate();
		
		ListCardDtoWrapper wrapper =  restTemplate.getForObject(URLCARD_SERVICE + "/onMarket" , ListCardDtoWrapper.class);
		
		return wrapper.getListCard();
	}
}
