package br.com.boleiroOn.domain.arrematante.dto;

import br.com.boleiroOn.domain.arrematante.enums.ModalidadeArrematante;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ArrematanteRequestDto(
        @NotNull
        Long leilaoId,

        @NotBlank
        String nome,

        @NotNull
        ModalidadeArrematante modalidade,

        Integer placa,

        String telefone,

        String celular,

        String endereco,

        @NotBlank
        @Email
        String email,

        String urlFotoDocumento
) {
}
