package com.sp.service;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.model.UserDto;
import com.sp.exception.FunctionnnalException;
import com.sp.tools.Comm;

@Service
public class AuthService {
	
	
	/**
	 * 
	 * @param UserDto 
	 * @return User id
	 * @throws FunctionnnalException
	 */
	public Integer login(UserDto u) throws FunctionnnalException {
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
		
		
	/**
	 * 
	 * @param UserDto
	 * @return bool True si l'utilistaeur n'existe pas deja dans la base
	 */
	private boolean checkUser(UserDto u) {
		return Comm.getUserBySurname(u.getSurname()) == null;
	}
	
	/**
	 * 
	 * @param UserDto
	 * @return User id
	 * @throws FunctionnnalException
	 */
	public Integer addUser(UserDto u) throws FunctionnnalException {
		if (!checkUser(u)) {
			throw new FunctionnnalException(" Surnom deja utilisé ");
		}
		UserDto createdUser=Comm.createUser(u);
		return createdUser.getId();
	}
	
//	public void logout(int id) 
//	{
//		Comm.getUserById(id);
//	}
	

}
