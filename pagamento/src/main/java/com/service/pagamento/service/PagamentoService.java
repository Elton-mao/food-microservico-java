package com.service.pagamento.service;

import com.service.pagamento.dto.PagamentoDto;
import com.service.pagamento.model.Pagamento;
import com.service.pagamento.repository.PagamentoRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PagamentoService {
    private final PagamentoRepository repository;
    private final ModelMapper mapper;

    public Page<PagamentoDto> obterTodos(Pageable paginacao){
            return repository.findAll(paginacao)
                    .map(p -> mapper.map(p, PagamentoDto.class));
    }

    public  PagamentoDto obterPorId(Long id){
        Pagamento p =  repository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("id não encontrado"));
        return mapper.map(p, PagamentoDto.class);
    }

    public PagamentoDto criarPagamento(PagamentoDto pagamentoDto){
        Pagamento p = mapper.map(pagamentoDto, Pagamento.class);
        p = repository.save(p);
        return mapper.map(p, PagamentoDto.class);
    }

    public PagamentoDto atualizar(Long id, PagamentoDto pagamentoDto){
        Pagamento pagamento = repository.findById(id).get();
        BeanUtils.copyProperties(pagamentoDto,pagamento);
        return mapper.map(pagamento, PagamentoDto.class);
    }
    public void deletar(Long id){
        repository.deleteById(id);
    }
}
