package com.sp.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.model.ListCardDtoWrapper;
import com.sp.model.Room;
import com.sp.service.RoomService;


@RestController
public class RoomRestCrt {
	
	
	@Autowired
	RoomService rService;
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/room")
	public List<Room> displayRoom() {
		System.out.println("Menu Room");
		return rService.displayRoom();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/room/{id}")
	public Room getRoomById(@PathVariable String id) {
		return rService.getRoomById(Integer.valueOf(id));
	}
	
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/room/newRoom/{player1Id}")
	public Room newRoom(@RequestBody Room room, @PathVariable String player1Id)
	{
		return rService.newRoom(room, Integer.valueOf(player1Id));
	
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/room/join")
	public Room joinRoom(@RequestParam String idRoom, @RequestParam String idPlayer)
	{
		if (idRoom != null && idPlayer != null)
		{
			return rService.joinRoom(Integer.valueOf(idRoom), Integer.valueOf(idPlayer));
		}
		return null;
	}
	
	
	@RequestMapping(method = RequestMethod.PUT, value = "/room/start/{idRoom}")
	public Room joinRoom(@PathVariable String idRoom, @RequestBody ListCardDtoWrapper listCard)
	{
		return rService.startGame(idRoom, listCard);
	}
	
	
	@RequestMapping(method = RequestMethod.PUT, value = "/room/endOfGame")
	public int endOfGame(@RequestParam String idRoom, @RequestParam String Winner)
	{
		if (idRoom != null && Winner != null)
		{
			return rService.endOfGame(Integer.valueOf(idRoom), Integer.valueOf(Winner));
		}
		
		return (Integer) null;
	}


}
