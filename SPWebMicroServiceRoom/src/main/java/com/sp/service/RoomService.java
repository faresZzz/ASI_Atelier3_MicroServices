package com.sp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.model.CardDto;
import com.model.ListCardDtoWrapper;
import com.model.UserDto;
import com.sp.model.Room;
import com.sp.tools.Comm;



@Service
public class RoomService {
	
	private List<Room> availableRoom = new ArrayList<Room>();
	private List<Room> fullRoom = new ArrayList<Room>();
	
	public List<Room> displayRoom()
	{
		return this.availableRoom;
	}
	
	public Room newRoom(Room room, int player1Id)
	{
		room.setPlayer1Id(player1Id);
		room.setFull(false);
		this.availableRoom.add(room);
		
		return room;
	}

	public Room joinRoom(Integer idRoom, Integer idPlayer2) 
	{
		int indexRoom = -1;
		for (int i = 0; i < this.availableRoom.size(); i++)
		{
			Room room = this.availableRoom.get(i);
			if (room.getId() == idRoom )
			{
				room.setPlayer2Id(idPlayer2);
				room.setFull(true);
				indexRoom = i;
				break;
			}			
		}
		Room returnRoom = null;
		if (indexRoom >= 0)
		{
			returnRoom = this.availableRoom.remove(indexRoom);
			
			returnRoom = this.anteRoom(returnRoom);
			
			this.fullRoom.add(returnRoom);
		}
		
		return returnRoom;
		
	}
	
	private Room anteRoom(Room room)
	{
		UserDto player1 = Comm.getPlayer(room.getPlayer1Id());
		UserDto player2 = Comm.getPlayer(room.getPlayer2Id());
		
		room.setPlayer1(player1);
		room.setPlayer2(player2);
		
		
		return room;
		
				
	}
	
	public Room startGame(int idRoom, ListCardDtoWrapper listCard)
	{
		Room roomStart = null;
		for (Room room  : this.fullRoom)
		{
			if (room.getId() == idRoom)
			{
				roomStart = room;
				break;
			}
		}
		
		CardDto cardPlayer1 = listCard.getListCard().get(0);
		CardDto cardPlayer2 = listCard.getListCard().get(0);
		
		if (cardPlayer1.getEnergy() >= 20)
		{
			roomStart.setCardPlayer1(cardPlayer1);
		}
		
		if (cardPlayer2.getEnergy() >= 20)
		{
			roomStart.setCardPlayer2(cardPlayer2);
		}
		
		return roomStart;
	}

	
	public int endOfGame(Integer idRoom, Integer winnerPlace) 
	{
		Room roomPlayed = null;
		for (Room room  : this.fullRoom)
		{
			if (room.getId() == idRoom)
			{
				roomPlayed = room;
				break;
			}
		}
		if (roomPlayed != null)
		{	
			UserDto winner = null;
			UserDto loser = null;
			if (winnerPlace == 1)
			{
				
				winner = roomPlayed.getPlayer1();
				loser = roomPlayed.getPlayer2();
			}
			else if (winnerPlace == 2)
			{
				winner = roomPlayed.getPlayer2();
				loser = roomPlayed.getPlayer1();
			}
			
			winner.setBank( winner.getBank() + roomPlayed.getBet());
			loser.setBank(loser.getBank() - roomPlayed.getBet());
			
			
			CardDto card1 = roomPlayed.getCardPlayer1();
			CardDto card2 = roomPlayed.getCardPlayer2();
			
			card1.setEnergy(card1.getEnergy() - 5);
			card2.setEnergy(card2.getEnergy() - 5);
			
			Comm.updatePlayer(winner);
			Comm.updatePlayer(loser);
			Comm.updateCard(card1);
			Comm.updateCard(card2);
		}
		
		return 0;
	}

	public Room getRoomById(Integer idRoom) {
		
		for (Room room : this.availableRoom)
		{
			if (room.getId() == idRoom)
			{
				return room;
			}
		}

		for (Room room : this.fullRoom)
		{
			if(room.getId() == idRoom)
			{
				return room;
			}
		}
		return null;
	}

}
