package com.sp.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


import org.springframework.beans.factory.annotation.Autowired;


@Entity
public class User {
	

	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String name = "jdoe";
	private String surname = "jdo";
	private String passwd = "0000";
	private int bank = 0;
	
	@ElementCollection
	private List<Integer> cardListId;

	public User( int id, String name, String surname, String passwd, int bank, List<Integer> listId) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.passwd = passwd;	
		this.bank = bank;
		this.cardListId = listId;
	}
	
	public User( String name, String surname, String passwd) {
		this.name = name;
		this.surname = surname;
		this.passwd = passwd;	
	}
	
	
	
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
	
	public void setCardListId(List<Integer> cardListId) {
		this.cardListId = cardListId;
	}

	public void addCard(Integer cardId)
	{
		if (cardId != null)
		{
			this.cardListId.add(cardId);
		}
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

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", surname=" + surname + ", passwd=" + passwd + ", bank=" + bank
				+ ", cardList=" + cardListId + "]";
	}
	
	
	

	
}