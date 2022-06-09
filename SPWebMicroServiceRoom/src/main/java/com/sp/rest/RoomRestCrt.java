package com.sp.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.model.CardDto;
import com.model.ListCardDtoWrapper;
import com.sp.model.Room;
import com.sp.service.RoomService;


@RestController
@CrossOrigin
@RequestMapping("/room")
public class RoomRestCrt {
	
	
	@Autowired
	RoomService rService;
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/roomList/{userId}")
	public List<Room> displayRoom( @PathVariable String userId) {
		System.out.println("Menu Room");
		return rService.displayRoom( Integer.valueOf(userId));
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public Room getRoomById(@PathVariable String id) {
		return rService.getRoomById(Integer.valueOf(id));
	}
	
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/newRoom/{player1Id}")
	public Room newRoom(@RequestBody Room room, @PathVariable String player1Id)
	{
		return rService.newRoom(room, Integer.valueOf(player1Id));
	
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/join/{idRoom}")
	public Room joinRoom(@PathVariable String idRoom, @RequestParam String idPlayer)
	{
		if (idRoom != null && idPlayer != null)
		{
			return rService.joinRoom(Integer.valueOf(idRoom), Integer.valueOf(idPlayer));
		}
		return null;
	}
	
	
	@RequestMapping(method = RequestMethod.PUT, value = "/start/{idRoom}")
	public Room startRoom(@PathVariable String idRoom, @RequestParam String idPlayer, @RequestParam String cardId)
	{
		return rService.startGame(Integer.valueOf(idRoom), Integer.valueOf(cardId), Integer.valueOf(idPlayer));
	}
	
	
	@RequestMapping(method = RequestMethod.PUT, value = "/endOfGame/{idRoom}")
	public boolean endOfGame(@PathVariable String idRoom, @RequestParam String winner)
	{
		if (idRoom != null && winner != null)
		{
			return rService.endOfGame(Integer.valueOf(idRoom), Integer.valueOf(winner));
		}
		
		return false;
	}


}
