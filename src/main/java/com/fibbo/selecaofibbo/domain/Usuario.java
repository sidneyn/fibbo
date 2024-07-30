package com.fibbo.selecaofibbo.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fibbo.selecaofibbo.domain.dtos.UsuarioDTO;   

@Entity
@Table (name = "usuario")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonIgnore	 // protege a requisicao feita pelo get da serialização que faz um loop dos dados quando requisitado na Api-Rest Postman	
	@OneToMany(mappedBy = "usuario")  // @OneToMany um usuario para muitos produtos 
	private List<Produto> produtos = new ArrayList<>(); // arralist para nao ter o ponteiro nulo.

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String email;
	private String cpf;
	private String senha;
		
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCadastro;

	public Usuario() {
			super();
	}

	
	public Usuario(Integer id, String nome, String email, String cpf, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.senha = senha;
	}


	public Usuario(UsuarioDTO obj) { 
		super();
		 this.id = obj.getId();
		 this.nome = obj.getNome();
		 this.email = obj.getEmail();		 
		 this.cpf = obj.getCpf();
		 this.senha = obj.getSenha();
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

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
}
