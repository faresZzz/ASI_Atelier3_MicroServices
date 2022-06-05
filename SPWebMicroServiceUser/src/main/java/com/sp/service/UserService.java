package com.sp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.CardDto;
import com.model.UserDto;
import com.sp.model.User;
import com.sp.repository.UserRepository;
import com.sp.tools.Comm;



@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	private UserDto userToUserDto(User user)
	{
//		UserDto userDto = new UserDto();
//		BeanUtils.copyProperties(user, userDto);
		UserDto userDto = new UserDto(user.getId(), user.getName(), user.getSurname(), user.getPasswd(), user.getBank(), user.getCardListId());

		return userDto;
	}
	
	private User userDtoToUser(UserDto userDto)
	{
//		User user = new User();
//		BeanUtils.copyProperties(userDto, user);
		User user = new User(userDto.getId(), userDto.getName(), userDto.getSurname(), userDto.getPasswd(), userDto.getBank(),  userDto.getCardListId());

		return user;
	}
	
	public UserDto addUser(UserDto userDto) {
		
		int numberOfCard = 5;
		// enregistrement de l'utilisateur dans la base de donnée
		User createdUser = userRepository.save(this.userDtoToUser(userDto));
		// recuperation de son id puis de ces cartes
		List<CardDto> cardList = Comm.getRandomCard(numberOfCard);
		// ajout de l'id des cartes a l'utilisateur et de l'id de l'utilisateur a chaque carte
		List<Integer> listCardId = new ArrayList();
		for (CardDto card : cardList)// Unresolved compilation problem: \n\tType mismatch: cannot convert from element type Object to CardDto 
		{
			listCardId.add(card.getId());
			card.setOwnerId(createdUser.getId());
			
			// update de chaque carte dans la base avec l'id de son Owner
			Comm.updateCard(card);
		}
//		System.out.println(listCardId);
		createdUser.setCardListId(listCardId);
		createdUser.setBank(1000);
		System.out.println(createdUser);
		// update de l'utilisateur dans la base avec ca liste de cartes
		return this.userToUserDto(userRepository.save(createdUser));
		
		
	}

	public UserDto getUserById(int id) {
		Optional<User> userOpt = userRepository.findById(id);
		if (userOpt.isPresent()) {
			return this.userToUserDto(userOpt.get());
		} else {
			return null;
		}
	}
	
	public List<User> getUserByName(String name) {
		List<User> userList = userRepository.findByName(name);
		List<UserDto> usersDto = new ArrayList<UserDto>();
		for(User user : userList)
		{
			usersDto.add(this.userToUserDto(user));
		}
		return userList;
	}
	
	public UserDto getUserBySurname(String surname) // return unique user, force unique surname
	{
		Optional<User> userOpt = userRepository.findBySurname(surname);
		if (userOpt.isPresent()) {
			return this.userToUserDto(userOpt.get());
		} else {
			return null;
		}
	}
	
	public List<UserDto> getAllUsers() {
		List<User> users = (List<User>) userRepository.findAll();
		List<UserDto> usersDto = new ArrayList<UserDto>();
		for(User user : users)
		{
			usersDto.add(this.userToUserDto(user));
		}
		return usersDto;
	}
	
	public UserDto update(int id, UserDto userDto)
	{
		User user = this.userDtoToUser(userDto);
		User userUpdated = userRepository.save(user);
		
		return this.userToUserDto(userUpdated);
					
	}

}