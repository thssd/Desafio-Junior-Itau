package com.challenge.itau.service;

import com.challenge.itau.dto.EstatisticaDTO;
import com.challenge.itau.dto.TransacaoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.DoubleSummaryStatistics;
import java.util.List;

@Service
public class EstatisticasService {

    @Autowired
    private TransacaoService transacaoService;

    public EstatisticaDTO estatisticaTransacao(Integer intevaloBusca) {
        List<TransacaoDTO> transacaoDTOList = transacaoService.buscarTransacao(intevaloBusca);

        if (transacaoDTOList.isEmpty()){
            return new EstatisticaDTO(0L, 0.0, 0.0, 0.0, 0.0);
        }

        DoubleSummaryStatistics doubleSummaryStatistics = transacaoDTOList.stream()
                .mapToDouble(TransacaoDTO::valor).summaryStatistics();

        return new EstatisticaDTO(doubleSummaryStatistics.getCount(),
                doubleSummaryStatistics.getSum(),
                doubleSummaryStatistics.getAverage(),
                doubleSummaryStatistics.getMin(),
                doubleSummaryStatistics.getMax());
    }
}
