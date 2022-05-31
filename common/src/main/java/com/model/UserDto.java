package com.model;

import java.util.List;

public class UserDto {
	
	private int id;
	private String name;
	private String surname;
	private String passwd;
	
	private int bank;
	
	private List<Integer> cardListId;

	
	public UserDto(int id, String name, String surname, String passwd,  int bank, List<Integer> cardList) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.passwd = passwd;
		this.bank = bank;
		this.cardListId = cardList;
	}
	public UserDto(String name, String surname, String passwd)
	{
		this(-1, name, surname, passwd, 0, null);
	}

	public UserDto() {
		// TODO Auto-generated constructor stub
	}

	public Integer deleteCard(int id)
	{
	
	for (Integer mycard : this.cardListId)
	{
		if (mycard == id)
		{
			if (this.cardListId.remove(mycard))
			{
				return mycard;
			}
		}
	}
		return null;
	}
public int getBank() {
		return bank;
	}


	public void setBank(int bank) {
		this.bank = bank;
	}


	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSurname() {
		return surname;
	}


	public void setSurname(String surname) {
		this.surname = surname;
	}


	public String getPasswd() {
		return passwd;
	}


	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public List<Integer> getCardListId() {
		return cardListId;
	}

	public void setCardListId(List<Integer> cardList) {
		this.cardListId = cardList;
	}

	public void addCard(Integer c) {
		this.cardListId.add(c);
	}

	
	@Override
	public String toString() {
		return "UserDto [id=" + id + ", name=" + name + ", surname=" + surname + ", passwd=" + passwd + ", bank=" + bank
				+ ", cardList=" + cardListId + "]";
	}

	

}
