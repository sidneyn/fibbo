package com.fibbo.selecaofibbo.application.controller;

import com.fibbo.selecaofibbo.application.dto.UsuarioRequestDto;
import com.fibbo.selecaofibbo.application.dto.UsuarioResponseDto;
import com.fibbo.selecaofibbo.domain.models.Usuario;
import com.fibbo.selecaofibbo.domain.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @PostMapping
    public ResponseEntity<UsuarioResponseDto> cadastrarUsuario(@RequestBody UsuarioRequestDto data) {

        Usuario usuarioData = new Usuario(data);
        usuarioData.setDataCadastro(new Date());

        return ResponseEntity.status(HttpStatus.CREATED).body( UsuarioResponseDto.converter(repository.save(usuarioData)));
    }


}
