package com.fibbo.selecaofibbo.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fibbo.selecaofibbo.domain.dtos.UsuarioDTO;   

@Entity

public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonIgnore	 // protege a requisicao feita pelo get da serialização que faz um loop dos dados quando requisitado na Api-Rest Postman	
	@OneToMany(mappedBy = "usuario")  // @OneToMany um usuario para muitos produtos 
	private List<Produto> produtos = new ArrayList<>(); // arralist para nao ter o ponteiro nulo.

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
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
	
	public Usuario() {
			super();
	}
	
	public Usuario(Integer id, String nome, String email, String cpf, String senha, LocalDate dataCriacao) {		
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.senha = senha;
		this.dataCriacao = dataCriacao;
	}


	public Usuario(UsuarioDTO obj) { 		
		super();
		 this.id = obj.getId();
		 this.nome = obj.getNome();
		 this.email = obj.getEmail();
		 this.cpf = obj.getCpf();
		 this.senha = obj.getSenha();
		 this.dataCriacao = obj.getDataCriacao();
	}
	
	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setChamados(List<Produto> produtos) {
		this.produtos = produtos;
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

	public void setDataCriacao(LocalDate dataCadastro) {
		this.dataCriacao = dataCriacao;
	}


	@Override
	public int hashCode() {
		return Objects.hash(cpf, id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(id, other.id);
	}

}
