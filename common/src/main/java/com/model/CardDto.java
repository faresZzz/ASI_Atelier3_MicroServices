package com.model;



public class CardDto {
	
	private int id;
	
	private String name;
	private String description;
	private String imgUrl;
	private String family;
	private String affinity;
	
	private int hp;
	private int energy;
	private int attack;
	private int defence;
	private int ownerId;
	private  int price;
	
	private boolean onMarket;


	
	public CardDto(int id, int price, String name, String description, String imgUrl, String family, String affinity, int hp, int energy,
			int attack, int defence, int ownerId, boolean onMarket) {
		this.id = id;
		this.price = price;
		this.name = name;
		this.description = description;
		this.imgUrl = imgUrl;
		this.family = family;
		this.affinity = affinity;
		this.hp = hp;
		this.energy = energy;
		this.attack = attack;
		this.defence = defence;
		this.ownerId = ownerId;
		this.onMarket = onMarket;
	}
	
	public CardDto(String name, String description, String imgUrl, String family, String affinity, int hp, int energy,
			int attack, int defence)
	{
		this(-1, 100, name, description, imgUrl, family, affinity , hp, energy, attack, defence, 0, false);
	}
	
	public CardDto()
	{
	}

	public int getOwnerId() {
		return ownerId;
	}


	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}


	public void setId(int id) {
		this.id = id;
	}



	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
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


	public boolean isOnMarket() {
		return onMarket;
	}


	public void setOnMarket(boolean onMarket) {
		this.onMarket = onMarket;
	}

	@Override
	public String toString() {
		return "CardDto [id=" + id + ", name=" + name + ", description=" + description + ", imgUrl=" + imgUrl
				+ ", family=" + family + ", affinity=" + affinity + ", hp=" + hp + ", energy=" + energy + ", attack="
				+ attack + ", defence=" + defence + ", ownerId=" + ownerId + ", price=" + price + ", onMarket="
				+ onMarket + "]";
	}
	
	

}
