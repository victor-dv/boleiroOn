package br.com.boleiroOn.domain.leilao.dto;

import br.com.boleiroOn.domain.leilao.entity.LeilaoEntity;

import java.time.LocalDate;

public record LeilaoResponseDto(
        Long id,
        String nome,
        LocalDate data,
        boolean status,
        String imageUrl
) {
    public LeilaoResponseDto(LeilaoEntity entity) {
        this(entity.getId(), entity.getNome(), entity.getData(), entity.isStatus(), entity.getImageUrl());
    }
}