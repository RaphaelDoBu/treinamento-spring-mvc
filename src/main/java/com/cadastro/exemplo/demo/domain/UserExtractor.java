package com.cadastro.exemplo.demo.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

public class UserExtractor  implements ResultSetExtractor<User>{
	  
	public User extractData(ResultSet resultSet) throws SQLException,
	   DataAccessException {
	  
	  User user = new User();
	  
	  user.setUserId(resultSet.getInt("userId"));
	  user.setNome(resultSet.getString("nome"));
	  user.setEndereco(resultSet.getString("endereco"));
	  user.setCidade(resultSet.getString("cidade"));
//	  user.setProfissao(resultSet.getString("profissao"));
//	  user.setCep(resultSet.getInt("cep"));

	  return user;
	 }
}
