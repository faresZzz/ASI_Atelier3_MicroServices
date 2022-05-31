package com.sp.tools;


import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.model.UserDto;

public class Comm {
	
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
	
	
	public static UserDto createUser(UserDto user)
	{
		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", MediaType.APPLICATION_XML_VALUE);
		headers.setContentType(MediaType.APPLICATION_XML);

		RestTemplate restTemplate = new RestTemplate();

		// Data attached to the request.
		HttpEntity<UserDto> requestBody = new HttpEntity<>(user, headers);

		// Send request with POST method.
		UserDto newUser = restTemplate.postForObject(URLUSER_SERVICE + "createUser", requestBody, UserDto.class);
		
		return newUser;
	}
}
