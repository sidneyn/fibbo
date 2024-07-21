package com.fibbo.selecaofibbo.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fibbo.selecaofibbo.domain.dtos.ProdutoDTO;
import com.fibbo.selecaofibbo.domain.dtos.UsuarioDTO;

@Entity
@Table (name = "produto")
public class Produto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
    @NotNull(message = "Campo NOME não pode ser nulo")
	private String nome;
    @NotNull(message = "Campo PREÇO DE CUSTO não pode ser nulo")
	private String preco_custo;
    @NotNull(message = "Campo PREÇO DE VENDA não pode ser nulo")
	private String preco_venda;
	private String qtd_estoque;
	@JsonFormat(pattern = "dd/MM/yyyy")	
	private LocalDate dataAtualizacao = LocalDate.now();
	@JsonFormat(pattern = "dd/MM/yyyy")
	protected LocalDate dataCadastro = LocalDate.now();

	@ManyToOne  // @ManyToOne Muitos Produtos para um usuario 
	@JoinColumn(name = "usuario_id")
	@NotNull(message = "Campo Usuario não pode ser nulo")
	private Usuario usuario;
	private String nomeUsuario;

	public Produto() {
		super();
		this.dataAtualizacao = dataAtualizacao;
		// TODO Auto-generated constructor stub
	}

	public Produto(Integer id, String nome, String preco_custo, String preco_venda, String qtd_estoque,
			Usuario usuario) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco_custo = preco_custo;
		this.preco_venda = preco_venda;
		this.qtd_estoque = qtd_estoque;		
		this.usuario = usuario;
	}

	public Produto(ProdutoDTO obj) { 
		super();
		 this.id = obj.getId();
		 this.nome = obj.getNome();
		 this.preco_custo = obj.getPreco_custo();		 
		 this.preco_venda = obj.getPreco_venda();
		 this.qtd_estoque = obj.getQtd_estoque();
		 this.dataAtualizacao = obj.getDataAtualizacao();
		 this.usuario = obj.getUsuario();
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

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(id, other.id);
	}	
	
}