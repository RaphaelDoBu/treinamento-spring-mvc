package com.cadastro.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cadastro.dao.UserDAO;
import com.cadastro.domain.User;

public class UserService {
	@Autowired
	UserDAO userDAO;
	
	public void setUserDAO(UserDAO userDAO){
		this.userDAO = userDAO;
	}
	
	public List<User> getUserList() {
		return userDAO.getUserList();
	}  

	public int saveUser(User e){
		return userDAO.saveUser(e);
	}  
	public int updateUser(User e){
		return userDAO.updateUser(e);
 
	}
	public int deleteUser(int e){
		return userDAO.deleteUser(e);
	}
	public User findUserById(int id){
		return userDAO.findUserById(id);
	}
}
