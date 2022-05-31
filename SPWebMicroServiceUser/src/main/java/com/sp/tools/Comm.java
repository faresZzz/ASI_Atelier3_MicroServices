package com.sp.tools;



import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.model.CardDto;
import com.model.ListCardDtoWrapper;

public class Comm {
	private static final String URLCARD_SERVICE = "http://localhost:3080/card";
	
	
	public static List<CardDto> getRandomCard(int numberOfCard)
	{
		
		//get Rand Cards

		RestTemplate restTemplate = new RestTemplate();

		// Send request with GET method and default Headers.
		ListCardDtoWrapper wrapper = restTemplate.getForObject(URLCARD_SERVICE+"/randcard/"+ numberOfCard, ListCardDtoWrapper.class);
//		ResponseEntity<List<CardDto>> responseEntity =
//		        restTemplate.exchange(URLCARD_SERVICE+"/randcard/"+ numberOfCard,
//		            HttpMethod.GET, null, new ParameterizedTypeReference<List<CardDto>>() {
//		            });
//		List<CardDto> listCard = responseEntity.getBody();

		return wrapper.getListCard();
			
	}
	
	public static void updateCard(CardDto card)
	{
		RestTemplate restTemplate = new RestTemplate();	

		// Send request with PUT method.
		restTemplate.put(URLCARD_SERVICE + "/update/"+card.getId(), card);
	}
}
