package br.com.boleiroOn.config.infra.relatorio.dto;

import java.time.LocalDateTime;

public record RelatorioAuditoriaDto(
    Long id,
    String arrematanteNome,
    String loteDescricao,
    Integer numeroLote,
    String tipoDocumento,
    String statusEmail,
    LocalDateTime dataEnvio,
    String urlS3
) {}
