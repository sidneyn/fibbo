package com.fibbo.selecaofibbo.application.dto;

import com.fibbo.selecaofibbo.domain.models.Usuario;

import java.util.Date;

public class UsuarioResponseDto {

    Long id;
    String nome;
    String email;
    String cpf;
    Date dataCadastro;



    public static UsuarioResponseDto converter(Usuario usuario) {
        UsuarioResponseDto usuarioResponseDto = new UsuarioResponseDto();
        usuarioResponseDto.setId(usuario.getId());
        usuarioResponseDto.setNome(usuario.getNome());
        usuarioResponseDto.setEmail(usuario.getEmail());
        usuarioResponseDto.setCpf(usuario.getCpf());
        usuarioResponseDto.setDataCadastro(usuario.getDataCadastro());
        return usuarioResponseDto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }


//    public UsuarioResponseDto(Usuario usuario) {
//        this(usuario.getId(),
//                usuario.getNome(),
//                usuario.getEmail(),
//                usuario.getCpf(),
//                usuario.getDataCadastro());
//    }
}
