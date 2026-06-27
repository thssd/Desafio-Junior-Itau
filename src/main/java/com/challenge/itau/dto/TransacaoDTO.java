package com.challenge.itau.dto;

import java.time.OffsetDateTime;

public record TransacaoDTO(Double valor,
                           OffsetDateTime dataHora) {
}
