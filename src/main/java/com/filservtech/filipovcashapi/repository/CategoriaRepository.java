package com.filservtech.filipovcashapi.repository;

import com.filservtech.filipovcashapi.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
