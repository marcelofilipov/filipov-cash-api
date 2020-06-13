package com.filservtech.filipovcashapi.repository;

import com.filservtech.filipovcashapi.model.Lancamento;
import com.filservtech.filipovcashapi.repository.lancamento.LancamentoRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long>, LancamentoRepositoryQuery {
}
