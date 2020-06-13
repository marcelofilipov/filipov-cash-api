package com.filservtech.filipovcashapi.repository;

import com.filservtech.filipovcashapi.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
