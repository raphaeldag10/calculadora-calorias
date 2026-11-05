package com.example.calccalorias.dto;

public record UsuarioCadastroDTO(
        Long usuarioId,
        String nome,
        String email,
        String senha
) {

}
