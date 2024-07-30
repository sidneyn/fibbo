package com.fibbo.selecaofibbo.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.fibbo.selecaofibbo.domain.dtos.ProdutoDTO;
import com.fibbo.selecaofibbo.domain.dtos.UsuarioDTO;
import com.fibbo.selecaofibbo.domain.Produto;
import com.fibbo.selecaofibbo.domain.Usuario;
import com.fibbo.selecaofibbo.repository.ProdutoRepository;
import com.fibbo.selecaofibbo.repository.UsuarioRepository;
import com.fibbo.selecaofibbo.service.exceptions.ObjectnotFoundException;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository repository;
	@Autowired
	private UsuarioService usuarioService;
	
	public Produto findById(Integer id) {
		Optional<Produto> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto nao encontrado! Id: " + id));
	}
	
	public List<Produto> findAll() {
		return repository.findAll();
	}
	
	public Produto create(ProdutoDTO objDTO) {
		objDTO.setId(null);
		Produto newObj = newProduto(objDTO);
		return repository.save(newObj);
	}
	
	public Produto update (Integer id, @Valid ProdutoDTO objDTO) {
		objDTO.setId(id);
		Produto oldObj = findById(id);		
		oldObj = newProduto(objDTO);
		return repository.save(oldObj);				
	}
	
	public void delete(Integer id) {
		Produto obj = findById(id);
		repository.deleteById(id);
	}
	
	private Produto newProduto(ProdutoDTO obj) {
		Usuario usuario = usuarioService.findById(obj.getUsuario());
		
		
		Produto produto = new Produto();
		if(obj.getId() != null) {
			produto.setId(obj.getId());
		}
				
		
		produto.setUsuario(usuario);		
		produto.setDataAtualizacao(obj.getDataAtualizacao());		
		produto.setDataCadastro(obj.getDataCadastro());		
		produto.setNome(obj.getNome());
		produto.setPreco_custo(obj.getPreco_custo());
		produto.setPreco_venda(obj.getPreco_venda());
		produto.setQtd_estoque(obj.getQtd_estoque());
		produto.setQtd_estoque(obj.getQtd_estoque());
		
		return produto;
	}
}
