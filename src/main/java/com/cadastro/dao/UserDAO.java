package com.cadastro.dao;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.cadastro.domain.User;
import com.cadastro.domain.UserRowMapper;  


public class UserDAO {
	@Autowired
	DataSource dataSource;  
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {  
		this.jdbcTemplate = jdbcTemplate;  
	}  
	
	public List<User> getUserList() {  
		List userList = new ArrayList(); 
		String sql = "select * from user";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);  
		userList = jdbcTemplate.query(sql, new UserRowMapper());  
		return userList;
	}  

	public int saveUser(User e){  
		String query="insert into user values('"+e.getUserId()+"','"+e.getNome()+"','"+e.getCidade()+"',"
				+ e.getEndereco() + ',' + e.getCep() +',' + e.getProfissao() + ")";  
		return jdbcTemplate.update(query);  
	}  
	public int updateUser(User e){  
		String query="update user set nome=' "+e.getNome() +" "
				+ "',cidade='"+e.getCidade()+"' where id='"+e.getUserId()+"' ";  
		return jdbcTemplate.update(query);  
	}  
	public int deleteUser(int id){  
		String query="delete from user where id='"+ id +"' ";  
		return jdbcTemplate.update(query);  
	}
	
	public User findUserById(int id){
		String sql = "select * from user where id=" + id;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);  

		return jdbcTemplate.queryForObject(sql, new UserRowMapper());
	}
}
