package com.sp.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.beans.factory.annotation.Autowired;

import com.sp.service.CardService;

@Entity
public class User {
	
	@Autowired
	CardService cService;
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String name = "jdoe";
	private String surname = "jdo";
	private String passwd = "0000";
	private int bank = 0;
	
	@OneToMany
	private List<Card> cardList;

	public User( String name, String surname, String passwd) {
		this.name = name;
		this.surname = surname;
		this.passwd = passwd;
		this.getCards();
		
	}
	
	private void getCards()
	{
		for (int i = 0; i < 5; i++ )
		{
			this.cardList.add(cService.getRandomCard());
		}
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

	public List<Card> getListCards() {
		return cardList;
	}

	public void setListCards(List<Card> listCards) {
		this.cardList = listCards;
	}
	
	public void addCard(Card card)
	{
		if (card != null)
		{
			this.cardList.add(card);
		}
	}
	
	public Card deleteCard(int id)
	{
		Card card = null;
		for (Card mycard : this.cardList)
		{
			if (mycard.getId() == id)
			{
				if (this.cardList.remove(mycard))
				{
					return mycard;
				}
			}
		}
		return card;
		
	}

	public int getBank() {
		return bank;
	}

	public void setBank(int bank) {
		this.bank = bank;
	}
	
	
	

	
}