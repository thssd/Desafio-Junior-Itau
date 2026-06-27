package com.challenge.itau.controller;

import com.challenge.itau.dto.EstatisticaDTO;
import com.challenge.itau.service.EstatisticasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estatistica")
public class EstatisticaController {

    @Autowired
    private EstatisticasService estatisticasService;

    @GetMapping
    public ResponseEntity<EstatisticaDTO> receberEstatiscas(@RequestParam(value = "intervaloBusca",
            required = false, defaultValue = "60") Integer intervaloBusca) {
        return ResponseEntity.ok(estatisticasService.estatisticaTransacao(intervaloBusca));
    }
}
