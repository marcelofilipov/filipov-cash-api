package com.filservtech.filipovcashapi.repository.lancamento;

import com.filservtech.filipovcashapi.model.Lancamento;
import com.filservtech.filipovcashapi.repository.filter.LancamentoFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LancamentoRepositoryQuery {
    public Page<Lancamento> filtrar(LancamentoFilter lancamentoFilter, Pageable pageable);
}
