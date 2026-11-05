package com.example.calccalorias.dto;

import com.example.calccalorias.model.Usuario;

public record UsuarioExibicaoDTO(
        Long usuarioId,
        String nome,
        String email
) {
    public UsuarioExibicaoDTO(Usuario usuario){
        this(
                usuario.getUsuarioId(),
                usuario.getNome(),
                usuario.getEmail()
        );
    }
}
