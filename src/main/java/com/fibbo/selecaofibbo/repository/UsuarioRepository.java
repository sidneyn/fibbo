 package com.fibbo.selecaofibbo.repository;
 

import com.fibbo.selecaofibbo.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
