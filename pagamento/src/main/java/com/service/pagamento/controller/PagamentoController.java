package com.service.pagamento.controller;

import com.service.pagamento.dto.PagamentoDto;
import com.service.pagamento.service.PagamentoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;


@RequiredArgsConstructor
@RestController
@RequestMapping("/pagametos")
public class PagamentoController {

    private final PagamentoService service;

    @GetMapping
    public Page<PagamentoDto> listar(@PageableDefault() Pageable paginacao) {
        return service.obterTodos(paginacao);
    }

    @GetMapping("/{id}")
    public PagamentoDto buscarPorId(@PathVariable  Long id) {
        return service.obterPorId(id);
    }

    @PostMapping
    public ResponseEntity<PagamentoDto> cadastrar(@RequestBody @Valid PagamentoDto pagamentoDto, UriComponentsBuilder uriBuilder) {
        PagamentoDto pagamento = service.criarPagamento(pagamentoDto);
        URI endereco = uriBuilder.path("/pagamentos/{id}").buildAndExpand(pagamento.getId()).toUri();
        return  ResponseEntity.created(endereco).body(pagamento);
    }

    @PutMapping
    public ResponseEntity<PagamentoDto> atualizar(@RequestBody @Valid PagamentoDto pagamentoDto,Long id) {
        PagamentoDto pagamento = service.atualizar(id, pagamentoDto);
        return ResponseEntity.ok().body(pagamento);
    }

    @DeleteMapping
    public ResponseEntity<PagamentoDto> deletar(@PathVariable @NotNull Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
