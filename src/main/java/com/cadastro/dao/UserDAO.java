package com.cadastro.dao;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.cadastro.domain.User;  


public class UserDAO {
	private JdbcTemplate jdbcTemplate; 
	@Autowired
	DataSource dataSource;  

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {  
		this.jdbcTemplate = jdbcTemplate;  
	}  
	
	public List<User> getUserList() {  
		List userList = new ArrayList(); 
		String sql = "select * from user";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);  
		userList = jdbcTemplate.query(sql);  
		return userList;
	}  

	public int saveEmployee(User e){  
		String query="insert into user values('"+e.getUserId()+"','"+e.getNome()+"','"+e.getCidade()+"',"
				+ e.getEndereco() + ',' + e.getCep() +',' + e.getProfissao() + ")";  
		    return jdbcTemplate.update(query);  
	}  
	public int updateEmployee(User e){  
		String query="update user set nome=' "+e.getNome() +" "
				+ "',cidade='"+e.getCidade()+"' where id='"+e.getUserId()+"' ";  
    return jdbcTemplate.update(query);  
	}  
	public int deleteEmployee(User e){  
		String query="delete from user where id='"+e.getUserId()+"' ";  
		return jdbcTemplate.update(query);  
	}  

}
