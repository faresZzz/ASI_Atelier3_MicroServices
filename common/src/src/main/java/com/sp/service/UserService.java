package com.sp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.exception.FunctionnnalException;
import com.sp.model.User;
import com.sp.model.UserDto;
import com.sp.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository uRepository;
	
	private List getUser(UserDto u) {
		List<User> userList = uRepository.findBySurname(u.getSurname());
		return userList;
	}
	
	public Integer logIn(UserDto u) throws FunctionnnalException {
		if (checkUser(u)) {
			throw new FunctionnnalException(" Nom introuvable ");
		}
		User user = (User) getUser(u).get(0);
		if (!user.getPasswd().equals(u.getPassword())){
			throw new FunctionnnalException(" Mauvais mdp ");
		}
		return user.getId();
		}
		
	
	private boolean checkUser(UserDto u) {
		return getUser(u).isEmpty();
	}
	
	public Integer addUser(UserDto u) throws FunctionnnalException {
		if (!checkUser(u)) {
			throw new FunctionnnalException(" Nom deja utilisé ");
		}
		
		User user = new User(u.getName(), u.getSurname(), u.getPassword());
		User createdUser=uRepository.save(user);
		return createdUser.getId();
	}
	
//	public User getUser(int id) {
//		Optional<User> uOpt =uRepository.findById(id);
//		if (uOpt.isPresent()) {
//			return uOpt.get();
//		}else {
//			return null;
//		}
//	}

}
