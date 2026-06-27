package com.challenge.itau.controller;

import com.challenge.itau.dto.TransacaoDTO;
import com.challenge.itau.service.TransacaoService;
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
    public ResponseEntity<Void> criarTransacao(@RequestBody TransacaoDTO dto) {
        transacaoService.adicionarTransacao(dto);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarTransacao() {
        transacaoService.limparTransacao();

        return ResponseEntity.ok().build();
    }
}
