package com.sp.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sp.model.User;
import com.sp.model.UserDto;
import com.sp.service.UserService;


@RestController
public class UserRestCrt {
	@Autowired
	UserService uService;

	@RequestMapping(method = RequestMethod.POST, value = "/createUser")
	public void addUser(@RequestBody User user) {
		uService.addUser(user);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/users")
	public Iterable<User> getAllUser() {
		Iterable<User> users = uService.getAllUsers();
		return users;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/user/{id}")
	public User getUser(@PathVariable String id) {
		User user = uService.getUserById(Integer.valueOf(id));
		return user;
	}
}