package com.sp.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.model.UserDto;
import com.sp.exception.FunctionnnalException;

import com.sp.service.AuthService;


@RestController
@CrossOrigin
public class AuthRestCrt {
	
	
	@Autowired
	AuthService aService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/")
	public String indexDisplay() {
		return " <h1> Bonjour vous etes bien sur la page d'accueil </h1>";
	}
	/**
	 * 
	 * @param userDto
	 * @return User id
	 * @throws FunctionnnalException
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/login")
	public int login(@RequestBody UserDto userDto) throws FunctionnnalException {
		try {
			return aService.login(userDto);
		} catch (FunctionnnalException e) {
			// TODO Auto-generated catch block
			throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED, e.getMessage());
		}
	}
	
	/**
	 * 
	 * @param userDto
	 * @return User id
	 * @throws FunctionnnalException
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/signin")
	public int signIn(@RequestBody UserDto userDto) throws FunctionnnalException
	{
		try {
			return aService.addUser(userDto);
		} catch (FunctionnnalException e) {
			// TODO Auto-generated catch block
			throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED, e.getMessage());
		}
	}
	
//	@RequestMapping(method = RequestMethod.GET, value= "/logout/{id}")
//	public void logout(@PathVariable String id)
//	{
//		aService.logout(Integer.valueOf(id));
//	}
//	

}
