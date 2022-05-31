package com.sp.service;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.model.UserDto;
import com.sp.exception.FunctionnnalException;
import com.sp.tools.Comm;

@Service
public class RoomService {
	
	
	
	public int login(UserDto u) throws FunctionnnalException {
		System.out.println("J entre");
		if (checkUser(u)) {
			throw new FunctionnnalException(" Nom introuvable ");
		}
		UserDto user = Comm.getUserBySurname(u.getSurname());
		if (user != null)
		{
			if (!user.getPasswd().equals(u.getPasswd()))
			{
				throw new FunctionnnalException(" Mauvais mdp ");
			}
			return user.getId();
			
		}
		return (Integer) null;
	}
		
		
	
	private boolean checkUser(UserDto u) {
		return Comm.getUserBySurname(u.getSurname()) == null;
	}
	
	public Integer addUser(UserDto u) throws FunctionnnalException {
		if (!checkUser(u)) {
			throw new FunctionnnalException(" Surnom deja utilisé ");
		}
		
		UserDto user = new UserDto();
		BeanUtils.copyProperties(user, u);
		UserDto createdUser=Comm.createUser(user);
		return createdUser.getId();
	}
	
//	public void logout(int id) 
//	{
//		Comm.getUserById(id);
//	}
	

}
