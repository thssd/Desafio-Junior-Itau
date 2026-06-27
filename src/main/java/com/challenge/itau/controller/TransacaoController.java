package com.challenge.itau.controller;

import com.challenge.itau.dto.TransacaoDTO;
import com.challenge.itau.service.TransacaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;

    @PostMapping
    @Operation(description = "endpoint responsavel por adicionar transaçções")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "transação gravada com sucesso"),
            @ApiResponse(responseCode = "422", description = "campos não atendem os requisitos" +
                    " da transação"),
            @ApiResponse(responseCode = "400", description = "erro de requisição")

    })
    public ResponseEntity<Void> criarTransacao(@RequestBody TransacaoDTO dto) {
        transacaoService.adicionarTransacao(dto);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping
    @Operation(description = "endpoint responsavel por deletar transaçções")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "transação deletada com sucesso"),
            @ApiResponse(responseCode = "400", description = "erro de requisição")

    })
    public ResponseEntity<Void> deletarTransacao() {
        transacaoService.limparTransacao();

        return ResponseEntity.ok().build();
    }
}
