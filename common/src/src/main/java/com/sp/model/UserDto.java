package com.sp.model;

public class UserDto {

	private String name="jd";
	private String password;
	private String surname;
	private String c_password;
	
	
	public UserDto(String name, String password, String surname, String c_password) {
		this.name = name;
		this.password = password;
		this.c_password= c_password;
		this.surname = surname;
	}

	public String getC_password() {
		return c_password;
	}

	public void setC_password(String c_password) {
		this.c_password = c_password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	
	
}
