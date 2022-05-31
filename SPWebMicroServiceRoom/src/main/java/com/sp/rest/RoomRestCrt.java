package com.sp.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.model.UserDto;
import com.sp.exception.FunctionnnalException;
import com.sp.model.Room;
import com.sp.service.RoomService;


@RestController
public class RoomRestCrt {
	
	
	@Autowired
	RoomService rService;
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/room")
	public int displayRoom() {
		System.out.println("Menu Room");
		return -1;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/room/newRoom")
	public Room newRoom(@RequestBody Room room)
	{
		
		return Room;
	}


}
