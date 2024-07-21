package com.fibbo.selecaofibbo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fibbo.selecaofibbo.domain.Produto;
import com.fibbo.selecaofibbo.domain.Usuario;
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
		Usuario usu1 = new Usuario (null, "Sidney Nogueira", "sidney@email.com", "63653230268", "123");
				
		usuarioRepository.saveAll(Arrays.asList(usu1));
		
	}

}
