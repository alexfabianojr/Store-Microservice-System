package com.example.fornecedor.service;

import com.example.fornecedor.entity.InfoFornecedor;
import com.example.fornecedor.repository.InfoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class InfoService {

    private final InfoRepository infoRepository;

    public InfoFornecedor getInfoPorEstado(String estado) {
        return infoRepository.findByEstado(estado).get();
    }
}
