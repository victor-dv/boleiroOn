package br.com.boleiroOn.domain.lote.dto;

import br.com.boleiroOn.domain.lote.entity.LoteEntity;

public record LoteResponseDto(
        Long id,
        Long leilaoId,
        Integer numeroLote,
        String descricao
) {
    public LoteResponseDto(LoteEntity entity) {
        this(
                entity.getId(),
                entity.getLeilao().getId(),
                entity.getNumeroLote(),
                entity.getDescricao()
        );
    }
}
