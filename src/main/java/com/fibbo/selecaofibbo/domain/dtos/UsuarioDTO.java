package com.fibbo.selecaofibbo.domain.dtos;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fibbo.selecaofibbo.domain.Produto;
import com.fibbo.selecaofibbo.domain.Usuario;


public class UsuarioDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore	 // protege a requisicao feita pelo get da serialização que faz um loop dos dados quando requisitado na Api-Rest Postman	
	@OneToMany(mappedBy = "cliente") 
	private List<Produto> chamados = new ArrayList<>(); // arralist para nao ter o ponteiro nulo.

	 protected Integer id;
	 
	 @NotNull(message = "O campo NOME é requerido")
	 protected String nome;
	 
	 @NotNull(message = "O campo EMAIL é requerido")
	 protected String email;
	 
	 @NotNull(message = "O campo CPF é requerido")
	 protected String cpf;
	 
	 @NotNull(message = "O campo SENHA é requerido")
	 protected String senha;	
	 
	 @JsonFormat(pattern = "dd/MM/yyyy")
	 protected LocalDate dataCriacao = LocalDate.now();
	 		 
	public UsuarioDTO(Usuario obj) {
		 super();
		 this.id = obj.getId();
		 this.nome = obj.getNome();
		 this.email = obj.getEmail();		 
		 this.cpf = obj.getCpf();
		 this.senha = obj.getSenha();
	 }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	
}
