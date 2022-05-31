package com.model;

import java.util.List;

public class ListUserDtoWrapper {

	private List<UserDto> userList;
	
	public ListUserDtoWrapper(List<UserDto> list)
	{
		this.setUserList(list);
	}
	
	public ListUserDtoWrapper()
	{
		
	}

	public List<UserDto> getUserList() {
		return userList;
	}

	public void setUserList(List<UserDto> userList) {
		this.userList = userList;
	}
}
