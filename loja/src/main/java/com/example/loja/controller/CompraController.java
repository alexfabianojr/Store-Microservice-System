package com.example.loja.controller;

import com.example.loja.dto.CompraDTO;
import com.example.loja.service.CompraService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/compra")
@AllArgsConstructor
public class CompraController {

    private final CompraService compraService;

    @PostMapping
    public void realizaCompra(@RequestBody CompraDTO compraDTO) {
        compraService.realizaCompra(compraDTO);
    }
}
