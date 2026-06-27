package com.challenge.itau.controller.dtos;

import java.time.OffsetDateTime;

public record TransacaoDTO(Double valor,
                           OffsetDateTime dataHora) {
}
