package com.seuprojeto.produtos.produtos.resource;

import com.seuprojeto.produtos.produtos.dto.FornecedorRequest;
import com.seuprojeto.produtos.produtos.dto.FornecedorResponse;
import com.seuprojeto.produtos.produtos.service.FornecedorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fornecedores")
public class FornecedorResource {

    private final FornecedorService service;

    public FornecedorResource(FornecedorService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<FornecedorResponse> salvar(@RequestBody FornecedorRequest request) {
        return ResponseEntity.ok(service.salvar(request));
    }
}
