package com.seuprojeto.produtos.produtos.resource;

import com.seuprojeto.produtos.produtos.dto.CategoriaRequest;
import com.seuprojeto.produtos.produtos.dto.CategoriaResponse;
import com.seuprojeto.produtos.produtos.service.CategoriaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {

    private final CategoriaService service;

    public CategoriaResource(CategoriaService service) {
        this.service = service;
    }

    @PostMapping
    public CategoriaResponse salvar(@RequestBody CategoriaRequest request) {
        return service.salvar(request);
    }

    @GetMapping
    public List<CategoriaResponse> listar() {
        return service.listar();
    }
}
