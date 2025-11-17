package com.seuprojeto.produtos.produtos.resource;

import com.seuprojeto.produtos.produtos.dto.ProdutoRequest;
import com.seuprojeto.produtos.produtos.dto.ProdutoResponse;
import com.seuprojeto.produtos.produtos.service.ProdutoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoResource {

    private final ProdutoService service;

    public ProdutoResource(ProdutoService service) {
        this.service = service;
    }

    @PostMapping
    public ProdutoResponse salvar(@RequestBody ProdutoRequest request) {
        return service.salvar(request);
    }

    @GetMapping
    public List<ProdutoResponse> listar() {
        return service.listar();
    }
}
