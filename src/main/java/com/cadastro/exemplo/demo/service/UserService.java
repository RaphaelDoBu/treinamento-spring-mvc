package com.cadastro.exemplo.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cadastro.exemplo.demo.dao.UserDAO;
import com.cadastro.exemplo.demo.domain.User;

@Service
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
