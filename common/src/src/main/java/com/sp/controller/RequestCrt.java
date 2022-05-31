package com.sp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.sp.exception.FunctionnnalException;
import com.sp.model.UserDto;
import com.sp.service.UserService;

@RestController 
public class RequestCrt {

	@Autowired
	UserService uService;
	
//	@RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
//	public String index(Model model) {
//		model.addAttribute("messageLocal", messageLocal);
//		return "index";
//	}
//	@RequestMapping(value = { "/sign_in" }, method = RequestMethod.GET)
//	public String display_sign_in(Model model) {
//		return "display_sign_in";
//	}
//	
//	@RequestMapping(value = { "/log_in" }, method = RequestMethod.GET)
//	public String display_log_in(Model model) {
//		return "display_log_in";
//	}
	
	@GetMapping("/")	
	public String cards(HttpServletRequest request, Model model) {
		String  name = request.getParameter("name") != null
				? request.getParameter("name")
				: "World";
		model.put("name",name);
		return "/cards";
	}
	
	@RequestMapping(value = { "/addUser" }, method = RequestMethod.POST)
	public Integer addUser(@RequestBody UserDto userDto) {
		System.out.println("\n\n\n\n" + userDto.getName() + "\n\n\n\n");
		try {
			return uService.addUser(userDto);
		} catch (FunctionnnalException e) {
			// TODO Auto-generated catch block
			throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED, e.getMessage());
		}
	}
	
	@RequestMapping(value = { "/logIn" }, method = RequestMethod.POST)
	public Integer logIn(@RequestBody UserDto userDto) {
		System.out.println("\n\n\n\n" + "Connexion" + "\n\n\n\n");
		try {
			return uService.logIn(userDto);
		} catch (FunctionnnalException e) {
			// TODO Auto-generated catch block
			throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED, e.getMessage());
		}
	}

} 
