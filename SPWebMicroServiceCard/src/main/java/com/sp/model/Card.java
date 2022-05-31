package com.sp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Card {
	
	@Id
	@GeneratedValue
	private int id;
	
	private int price = 0;
	private String name;
	private String description;
	private String imgUrl;
	private String family;
	private String affinity;
	
	private int hp;
	private int energy;
	private int attack;
	private int defence;
	
	private boolean onMarket = false ;
	private int ownerId = 0;
	


	

	public Card(int id,  int value, String name, String description, String imgUrl, String family, String affinity, int hp,
			int energy, int attack, int defence, boolean onMarket) {

		this.id = id;
		this.name = name;
		this.description = description;
		this.imgUrl = imgUrl;
		this.family = family;
		this.affinity = affinity;
		this.hp = hp;
		this.energy = energy;
		this.attack = attack;
		this.defence = defence;
		this.onMarket = onMarket;
		this.price = value;
		this.ownerId = 0;
	}
	
	public Card() {
		// TODO Auto-generated constructor stub
	}

	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}


	
	public boolean isOnMarket() {
		return onMarket;
	}

	public void setOnMarket(boolean onMarket) {
		this.onMarket = onMarket;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	@Override
	public String toString() {
		return "Card [id=" + id + ", price=" + price + ", name=" + name + ", description=" + description + ", imgUrl="
				+ imgUrl + ", family=" + family + ", affinity=" + affinity + ", hp=" + hp + ", energy=" + energy
				+ ", attack=" + attack + ", defence=" + defence + ", onMarket=" + onMarket + ", ownerId=" + ownerId
				+ "]";
	}

	public String getFamily() {
		return family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	public String getAffinity() {
		return affinity;
	}

	public void setAffinity(String affinity) {
		this.affinity = affinity;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int energy) {
		this.energy = energy;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getDefence() {
		return defence;
	}

	public void setDefence(int defence) {
		this.defence = defence;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
	

}
