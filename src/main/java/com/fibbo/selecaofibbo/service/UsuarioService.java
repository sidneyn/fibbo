package com.fibbo.selecaofibbo.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.fibbo.selecaofibbo.domain.dtos.UsuarioDTO;
import com.fibbo.selecaofibbo.domain.Usuario;
import com.fibbo.selecaofibbo.repository.ProdutoRepository;
import com.fibbo.selecaofibbo.repository.UsuarioRepository;
import com.fibbo.selecaofibbo.services.exceptions.ObjectnotFoundException;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public Usuario findById(Integer id) {
		Optional<Usuario> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto nao encontrado! Id: " + id));
	}
	
	public List<Usuario> findAll() {
		return repository.findAll();
	}
	
	public Usuario create(UsuarioDTO objDTO) {		 
		objDTO.setId(null);
		objDTO.setSenha(objDTO.getSenha());
		//validaPorCpfEmail(objDTO);
		Usuario newObj = new Usuario (objDTO);
		return repository.save(newObj);
	}
	
	public Usuario update (Integer id, @Valid UsuarioDTO objDTO) {
		objDTO.setId(id);
		Usuario oldObj = findById(id);
		//validaPorCpfEmail(objDTO);
		oldObj = new Usuario(objDTO);
		return repository.save(oldObj);				
	}
	
	public void delete(Integer id) {
		Usuario obj = findById(id);
		
		if (obj.getProdutos().size() > 0) {
			throw new DataIntegrityViolationException("Cliente possui ordens de serviços e não pode ser deletado!");
		}
		repository.deleteById(id);
	}
}
