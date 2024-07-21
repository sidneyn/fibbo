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
import com.fibbo.selecaofibbo.services.exceptions.ObjectnotFoundException;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository repository;
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Produto findById(Integer id) {
		Optional<Produto> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto nao encontrado! Id: " + id));
	}
	
	public List<Produto> findAll() {
		return repository.findAll();
	}
	
	public Produto create(ProdutoDTO objDTO) {
		objDTO.setId(null);
		
		
		Produto newObj = new Produto (objDTO);
		return repository.save(newObj);
	}
	
	public Produto update (Integer id, @Valid ProdutoDTO objDTO) {
		objDTO.setId(id);
		Produto oldObj = findById(id);
		//validaPorCpfEmail(objDTO);
		oldObj = new Produto(objDTO);
		return repository.save(oldObj);				
	}
	
	public void delete(Integer id) {
		Produto obj = findById(id);
		repository.deleteById(id);
	}
}
