package com.sp.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.model.UserDto;
import com.sp.model.User;
import com.sp.service.UserService;


@RestController
public class UserRestCrt {
	@Autowired
	UserService uService;

	@RequestMapping(method = RequestMethod.POST, value = "/user/createUser")
	public UserDto addUser(@RequestBody UserDto user) {
		UserDto createdUser = uService.addUser(user);
		System.out.println(createdUser);
		return createdUser;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/user/getAll")
	public Iterable<UserDto> getAllUser() {
		Iterable<UserDto> users = uService.getAllUsers();
		return users;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/user/getUserById/{id}")
	public UserDto getUser(@PathVariable String id) {
		UserDto user = uService.getUserById(Integer.valueOf(id));
		return user;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/user/getUserBySurname/{surname}")
	public UserDto getUserBySurname(@PathVariable String surname) {
		UserDto user = uService.getUserBySurname(surname);
		return user;
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/user/update/{id}")
	public UserDto update(@PathVariable String id, @RequestBody UserDto user)
	{
		return uService.update(Integer.valueOf(id), user);
	}
	
	
}