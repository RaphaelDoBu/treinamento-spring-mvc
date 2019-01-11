package com.cadastro.exemplo.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cadastro.exemplo.demo.domain.User;
import com.cadastro.exemplo.demo.service.UserService;

@Controller
@RequestMapping(value="/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/list", method= RequestMethod.GET )
	public ModelAndView list(){
		ModelAndView model = new ModelAndView("user_form_bst");
		
		List<User> list = userService.getUserList();
		model.addObject("users", list);
		
		return model;
	}

	@RequestMapping(value="/update/{id}", method= RequestMethod.GET )
	public ModelAndView updateUser(@PathVariable("id") int id){
		ModelAndView model = new ModelAndView("user_edit_bst");
		
		User user = userService.findUserById(id);
		if(user != null) {
			model.addObject("user", user);
		}
		return model;
	}
	
	@RequestMapping(value="/editUser", method= RequestMethod.POST )
	public ModelAndView editUser(@ModelAttribute("user") User user){
		
		if( user.getNome() != null ) {
			userService.updateUser(user);

		}
		return new ModelAndView("redirect:/user/list");
	}


	@RequestMapping(value="/save", method= RequestMethod.POST )
	public ModelAndView saveUser(@ModelAttribute("user") User user){
		
		if(user != null) {
			userService.saveUser(user);
		}
	
		return new ModelAndView("redirect:/user/list");
	}
	
	@RequestMapping(value="/delete/{id}", method= RequestMethod.GET)
	public ModelAndView deleteUser(@PathVariable("id") int id){
		
		userService.deleteUser(id);
		
		return new ModelAndView("redirect:/user/list");
	}
}
