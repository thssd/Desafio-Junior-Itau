package com.challenge.itau.controller;

import com.challenge.itau.dto.EstatisticaDTO;
import com.challenge.itau.service.EstatisticasService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(description = "endpoint responsavel por buscar estatisticas de transações")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "transação gravada com sucesso"),
            @ApiResponse(responseCode = "400", description = "erro de requisição")

    })
    public ResponseEntity<EstatisticaDTO> receberEstatiscas(@RequestParam(value = "intervaloBusca",
            required = false, defaultValue = "60") Integer intervaloBusca) {
        return ResponseEntity.ok(estatisticasService.estatisticaTransacao(intervaloBusca));
    }
}
