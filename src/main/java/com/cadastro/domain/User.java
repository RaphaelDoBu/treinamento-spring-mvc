package com.cadastro.domain;

public class User {

	private int userId;
	private String nome;
	private String cidade;
	private String endereco;
	private int cep;
	private String profissao;


	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
	  this.userId = userId;
	}

	public String getNome() {
	  return nome;
	}

	public void setNome(String nome) {
	  this.nome = nome;
	}

	public String getEndereco() {
	  return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getCep() {
		return cep;
	}

	public void setCep(int cep) {
		 this.cep = cep;
	
	}

	public String getProfissao() {
	  return profissao;
	}

	public void setProfissao(String profissao) {
	  this.profissao = profissao;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String city) {
		this.cidade = city;
	}
	
}
