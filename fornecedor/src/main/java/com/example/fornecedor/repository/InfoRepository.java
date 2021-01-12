package com.example.fornecedor.repository;

import com.example.fornecedor.entity.InfoFornecedor;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface InfoRepository extends CrudRepository<InfoFornecedor, Long> {
    Optional<InfoFornecedor> findByEstado(String estado);
}
