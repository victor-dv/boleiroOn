package br.com.boleiroOn.domain.arrematante.dto;

import br.com.boleiroOn.domain.arrematante.entity.ArrematanteEntity;
import br.com.boleiroOn.domain.arrematante.enums.ModalidadeArrematante;

public record ArrematanteResponseDto(
        Long id,
        Long leilaoId,
        String nome,
        ModalidadeArrematante modalidade,
        Integer placa,
        String email,
        String urlFotoDocumento
) {
    public ArrematanteResponseDto(ArrematanteEntity entity) {
        this(
                entity.getId(),
                entity.getLeilao().getId(),
                entity.getNome(),
                entity.getModalidade(),
                entity.getPlaca(),
                entity.getEmail(),
                entity.getUrlFotoDocumento()
        );
    }
}
