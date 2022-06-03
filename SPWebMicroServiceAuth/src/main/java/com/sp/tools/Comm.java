package com.sp.tools;


import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.model.UserDto;

public class Comm {
	
	// addresse du service user
	private static final String URLUSER_SERVICE = "http://localhost:3081/user/";
	
	
	/**
	 * 
	 * @param surname 
	 * @return UserDto 
	 * {@summary} appelle du service user 
	 */
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

		RestTemplate restTemplate = new RestTemplate();


		// Send request with POST method.
		UserDto newUser = restTemplate.postForObject(URLUSER_SERVICE + "createUser", user, UserDto.class);
		
		return newUser;
	}
}
