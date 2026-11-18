package com.example.calccalorias.dto;

import jakarta.validation.constraints.NotNull;

public record AlimentoCadastroDTO(
        Long alimentoId,
        String nome,
        String porcao,
        @NotNull Double quantidadeProteina,
        @NotNull Double quantidadeCarboidrato,
        @NotNull Double quantidadeGorduras
) {

}
