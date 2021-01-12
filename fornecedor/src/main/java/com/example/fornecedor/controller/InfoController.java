package com.example.fornecedor.controller;

import com.example.fornecedor.entity.InfoFornecedor;
import com.example.fornecedor.service.InfoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/info")
@AllArgsConstructor
public class InfoController {

    private final InfoService infoService;

    @GetMapping("/{estado}")
    public InfoFornecedor getInfoPorEstado(@PathVariable String estado) {
        return infoService.getInfoPorEstado(estado);
    }
}
