package com.sp.model;

import javax.persistence.Entity;

@Entity
public class UserDto {
	
	private String name;
	private String surname;
	private String passwd;
	
	
	public UserDto(String name, String surname, String passwd) {
		this.name = name;
		this.surname = surname;
		this.passwd = passwd;
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

	
	

	

}
