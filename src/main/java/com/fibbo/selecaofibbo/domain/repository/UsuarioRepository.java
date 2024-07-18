package com.fibbo.selecaofibbo.domain.repository;

import com.fibbo.selecaofibbo.domain.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
