package com.cadastro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cadastro.domain.User;
import com.cadastro.service.UserService;

@Controller
@RequestMapping(value="/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/list", method= RequestMethod.GET )
	public ModelAndView list(){
		ModelAndView model = new ModelAndView("user_page");
		
		List<User> list = userService.getUserList();
		model.addObject("listUser", list);
		
		return model;
	}
	
	@RequestMapping(value="/add-user", method= RequestMethod.GET )
	public ModelAndView addUser(){
		System.out.println("Aq");
		ModelAndView model = new ModelAndView("user_form");
				
		User user = new User();
		model.addObject("userform", user);
		
		return model;
	}
	
	@RequestMapping(value="/update/{id}", method= RequestMethod.PUT )
	public ModelAndView updateUser(@PathVariable("id") int id){
		ModelAndView model = new ModelAndView("user/user_form");
		
		User user = userService.findUserById(id);
		model.addObject("userform", user);
		
		return model;
	}

	@RequestMapping(value="/save", method= RequestMethod.POST )
	public ModelAndView saveUser(@PathVariable("userform") User user){
	
		if(user!= null){
			userService.updateUser(user);
		}
		else{
			userService.saveUser(user);
		}
		
		return new ModelAndView("redirect:/list");
	}
	
	@RequestMapping(value="/delete/{id}", method= RequestMethod.DELETE)
	public ModelAndView deleteUser(@PathVariable("id") int id){
		
		userService.deleteUser(id);
		
		return new ModelAndView("redirect:/list");
	}
}
