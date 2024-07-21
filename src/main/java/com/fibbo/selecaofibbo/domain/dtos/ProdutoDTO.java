package com.fibbo.selecaofibbo.domain.dtos;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fibbo.selecaofibbo.domain.Produto;
import com.fibbo.selecaofibbo.domain.Usuario;

public class ProdutoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
    @NotNull(message = "Campo NOME não pode ser nulo")
	private String nome;
    @NotNull(message = "Campo PREÇO DE CUSTO não pode ser nulo")
	private String preco_custo;
    @NotNull(message = "Campo PREÇO DE VENDA não pode ser nulo")
	private String preco_venda;
	private String qtd_estoque;
	@JsonFormat(pattern = "dd/MM/yyyy")	
	private LocalDate dataAtualizacao;
	@JsonFormat(pattern = "dd/MM/yyyy")
	protected LocalDate dataCadastro;
	private Usuario usuario;
	private String nomeUsuario;

	
	public ProdutoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProdutoDTO(Produto obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.preco_custo = obj.getPreco_custo();
		this.preco_venda = obj.getPreco_venda();
		this.qtd_estoque = obj.getQtd_estoque();
		this.dataAtualizacao = obj.getDataAtualizacao();
		this.dataCadastro = obj.getDataCadastro();
		this.usuario = obj.getUsuario();
		this.nomeUsuario = obj.getUsuario().getNome();
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

	public String getPreco_custo() {
		return preco_custo;
	}

	public void setPreco_custo(String preco_custo) {
		this.preco_custo = preco_custo;
	}

	public String getPreco_venda() {
		return preco_venda;
	}

	public void setPreco_venda(String preco_venda) {
		this.preco_venda = preco_venda;
	}

	public String getQtd_estoque() {
		return qtd_estoque;
	}

	public void setQtd_estoque(String qtd_estoque) {
		this.qtd_estoque = qtd_estoque;
	}

	public LocalDate getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(LocalDate dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
		
}
