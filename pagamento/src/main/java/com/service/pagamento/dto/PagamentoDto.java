package com.service.pagamento.dto;

import com.service.pagamento.model.Status;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class PagamentoDto {

    private Long id;

    private BigDecimal valor;

    private String nome;

    private String numero;

    private String expiracao;

    private String codigo;

    private Status status;

    private Long pedidoId;

    private Long formaDePagamento;

}
