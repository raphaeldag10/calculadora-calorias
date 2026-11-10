package com.example.calccalorias.dto;


import com.example.calccalorias.model.Alimento;

public record AlimentoExibicaoDTO(
        Long alimentoId,
        String nome,
        String porcao,
        Double quantidadeProteina,
        Double quantidadeCarboidrato,
        Double quantidadeGorduras,
        Double totalCalorias
) {

    public AlimentoExibicaoDTO(Alimento alimento) {
        this(
                alimento.getAlimentoId(),
                alimento.getNome(),
                alimento.getPorcao(),
                alimento.getQuantidadeProteina(),
                alimento.getQuantidadeCarboidrado(),
                alimento.getQuantidadeGorduras(),
                alimento.getTotalCalorias()
        );
    }

}