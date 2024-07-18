package com.fibbo.selecaofibbo.domain.models;

import com.fibbo.selecaofibbo.application.dto.UsuarioRequestDto;

import java.util.Date;
import java.util.Objects;

import javax.persistence.*;   

@Entity
@Table (name = "usuarios")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;

	private String email;

	private String cpf;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCadastro;

	public Usuario(UsuarioRequestDto data){
		this.nome = data.getNome();
		this.email = data.getEmail();
		this.cpf = data.getCpf();
		this.dataCadastro = new Date();
	}

	public Usuario() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}


}
