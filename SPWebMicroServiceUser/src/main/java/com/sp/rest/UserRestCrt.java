package com.sp.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.model.ListUserDtoWrapper;
import com.model.UserDto;
import com.sp.service.UserService;


@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserRestCrt {
	@Autowired
	UserService uService;

	@RequestMapping(method = RequestMethod.POST, value = "/createUser")
	public UserDto addUser(@RequestBody UserDto user) {
		UserDto createdUser = uService.addUser(user);
		System.out.println(createdUser);
		return createdUser;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/users")
	public ListUserDtoWrapper getAllUser() {
		ListUserDtoWrapper userWrapper = new ListUserDtoWrapper();
		List<UserDto> users = uService.getAllUsers();
		userWrapper.setUserList(users);
		return userWrapper;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/getUserById/{id}")
	public UserDto getUser(@PathVariable String id) {
		UserDto user = uService.getUserById(Integer.valueOf(id));
		return user;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/getUserBySurname/{surname}")
	public UserDto getUserBySurname(@PathVariable String surname) {
		UserDto user = uService.getUserBySurname(surname);
		return user;
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/update/{id}")
	public boolean update(@PathVariable String id, @RequestBody UserDto user)
	{
		if (uService.update(Integer.valueOf(id), user) != null)
		{
			return true;
		}
		return false;
	}
	
	
}