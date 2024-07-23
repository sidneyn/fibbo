package com.fibbo.selecaofibbo;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fibbo.selecaofibbo.domain.Produto;
import com.fibbo.selecaofibbo.domain.Usuario;
import com.fibbo.selecaofibbo.domain.dtos.UsuarioDTO;
import com.fibbo.selecaofibbo.repository.ProdutoRepository;
import com.fibbo.selecaofibbo.repository.UsuarioRepository;

@SpringBootApplication
public class SelecaofibboApplication implements CommandLineRunner {

	@Autowired
	private UsuarioRepository usuarioRepository;
	private ProdutoRepository produtoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SelecaofibboApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Usuario usu1 = new Usuario(null,"Sid", "@email", "02135144436","123456", LocalDate.now());
		
		Produto prod1 = new Produto(null,"Notebook", "1200", "1600","5", LocalDate.now(), LocalDate.now(), usu1,usu1.getNome());
				
		usuarioRepository.saveAll(Arrays.asList(usu1));
	//	produtoRepository.saveAll(Arrays.asList(prod1));
		
	}

}
