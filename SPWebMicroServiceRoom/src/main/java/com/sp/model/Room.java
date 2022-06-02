package com.sp.model;

import java.util.List;

import com.model.CardDto;
import com.model.UserDto;

public class Room {
	
	private static int idRoom;
	
	private int bet;
	private String name;
	private int id;
	
	private int player1Id;
	private int player2Id;
	
	private boolean full;
	
	private UserDto player1;
	private UserDto player2;
	
	private CardDto cardPlayer1;
	private CardDto cardPlayer2;
	
	public Room(int bet, String name)
	{
		this.bet = bet;
		this.name = name;
		this.id = idRoom;
		idRoom ++;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBet() {
		return bet;
	}
	public void setBet(int bet) {
		this.bet = bet;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPlayer1Id() {
		return player1Id;
	}
	public void setPlayer1Id(int player1Id) {
		this.player1Id = player1Id;
	}
	public int getPlayer2Id() {
		return player2Id;
	}
	public void setPlayer2Id(int player2Id) {
		this.player2Id = player2Id;
	}
	public boolean isFull() {
		return full;
	}
	public void setFull(boolean full) {
		this.full = full;
	}
	public UserDto getPlayer1() {
		return player1;
	}
	public void setPlayer1(UserDto player1) {
		this.player1 = player1;
	}
	public UserDto getPlayer2() {
		return player2;
	}
	public void setPlayer2(UserDto player2) {
		this.player2 = player2;
	}
	public CardDto getCardPlayer1() {
		return cardPlayer1;
	}
	public void setCardPlayer1(CardDto cardPlayer1) {
		this.cardPlayer1 = cardPlayer1;
	}
	public CardDto getCardPlayer2() {
		return cardPlayer2;
	}
	public void setCardPlayer2(CardDto cardPlayer2) {
		this.cardPlayer2 = cardPlayer2;
	}
	

}
