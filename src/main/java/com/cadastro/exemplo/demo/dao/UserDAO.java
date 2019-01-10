package com.cadastro.exemplo.demo.dao;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cadastro.exemplo.demo.domain.User;
import com.cadastro.exemplo.demo.domain.UserRowMapper;  

@Repository
public class UserDAO {
	@Autowired
	DataSource dataSource;  
	
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {  
		this.jdbcTemplate = jdbcTemplate;  
	}  
	
	public List<User> getUserList() {  
		List userList = new ArrayList(); 
		String sql = "SELECT * FROM users";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);  
		userList = jdbcTemplate.query(sql, new UserRowMapper());  
		return userList;
	}  

	public int saveUser(User e){
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		String query="INSERT INTO users(userId,nome,cidade,endereco) values(null,'"+e.getNome()+"','"+e.getCidade()+
				"', '"+ e.getEndereco() + "')";  
		return jdbcTemplate.update(query);  
	}  
	public int updateUser(User e){
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		String query="UPDATE users SET nome=' "+e.getNome() +" "
				+ "',cidade='"+e.getCidade()+"' where userId='"+e.getUserId()+"' ";  
		return jdbcTemplate.update(query);  
	}  
	public int deleteUser(int id){
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		String query="DELETE FROM users WHERE userId='"+ id +"' ";  
		return jdbcTemplate.update(query);  
	}
	
	public User findUserById(int id){
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		String sql = "SELECT * FROM users WHERE userId=" + id;

		return jdbcTemplate.queryForObject(sql, new UserRowMapper());
	}
}
