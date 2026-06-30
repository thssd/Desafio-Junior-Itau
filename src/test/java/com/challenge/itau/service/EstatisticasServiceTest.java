package com.challenge.itau.service;

import com.challenge.itau.dto.EstatisticaDTO;
import com.challenge.itau.dto.TransacaoDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.OffsetDateTime;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EstatisticasServiceTest {

    @InjectMocks
    EstatisticasService estatisticasService;

    @Mock
    TransacaoService transacaoService;

    TransacaoDTO transacaoDTO;

    EstatisticaDTO estatisticaDTO;

    @BeforeEach
    void setUp() {
        transacaoDTO = new TransacaoDTO(20.00, OffsetDateTime.now());
        estatisticaDTO = new EstatisticaDTO(1L, 20.00, 20.00, 20.00, 20.00);

    }

    @Test
    @DisplayName("verificar se estatisticas estão iguais")
    void estatisticaTransacao_Cenario1() {
        when(transacaoService.buscarTransacao(60))
                .thenReturn(Collections.singletonList(transacaoDTO));

        EstatisticaDTO resultado = estatisticasService.estatisticaTransacao(60);

        verify(transacaoService, times(1)).buscarTransacao(60);

        assertThat(resultado).usingRecursiveComparison().isEqualTo(estatisticaDTO);
    }

    @Test
    @DisplayName("quando a lista de transações está vazia tem que retornar uma lista com atributos zerados")
    void estatisticaTransacao_Cenario2() {
        EstatisticaDTO estatisticaEsperada = new EstatisticaDTO(0L, 0.0, 0.0, 0.0, 0.0);

        when(transacaoService.buscarTransacao(60))
                .thenReturn(Collections.emptyList());

        EstatisticaDTO resultado = estatisticasService.estatisticaTransacao(60);

        verify(transacaoService, times(1)).buscarTransacao(60);

        assertThat(resultado).usingRecursiveComparison().isEqualTo(estatisticaEsperada);
    }
}