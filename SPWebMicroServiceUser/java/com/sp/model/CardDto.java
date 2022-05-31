package com.sp.model;

import javax.persistence.Entity;

@Entity
public class CardDto {
	
	private String name;
	private String description;
	private String imgurl;
	private String family;
	private String affinity;
	
	private int hp;
	private int energy;
	private int attack;
	private int defence;

	
	public CardDto(String name, String description, String imgurl, String family, String affinity, int hp, int energy,
			int attack, int defence) {
		super();
		this.name = name;
		this.description = description;
		this.imgurl = imgurl;
		this.family = family;
		this.affinity = affinity;
		this.hp = hp;
		this.energy = energy;
		this.attack = attack;
		this.defence = defence;
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


	public String getImgurl() {
		return imgurl;
	}


	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
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
	
	

}
