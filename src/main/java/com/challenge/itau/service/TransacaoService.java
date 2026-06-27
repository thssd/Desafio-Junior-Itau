package com.challenge.itau.service;

import com.challenge.itau.dto.TransacaoDTO;
import com.challenge.itau.infra.exceptions.UnprocessableEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransacaoService {

    private final List<TransacaoDTO> listaTransacao = new ArrayList<>();

    public void adicionarTransacao(TransacaoDTO dto){
        if (dto.dataHora().isAfter(OffsetDateTime.now())){
            throw new UnprocessableEntity("Data e hora inválidos.");
        }

        if (dto.valor() < 0){
            throw new UnprocessableEntity("O valor não pode ser negativo.");
        }

        listaTransacao.add(dto);
    }

    public void limparTransacao(){
        listaTransacao.clear();
    }

    public List<TransacaoDTO> buscarTransacao(Integer intervaloBusca){
        OffsetDateTime dataHoraIntervalo = OffsetDateTime.now().minusSeconds(intervaloBusca);

        return listaTransacao.stream()
                .filter(t -> t.dataHora().isAfter(dataHoraIntervalo))
                .toList();
    }

}
