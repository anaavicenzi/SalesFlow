package com.seuprojeto.produtos.produtos.resource;

import com.seuprojeto.produtos.produtos.dto.PedidoRequest;
import com.seuprojeto.produtos.produtos.dto.PedidoResponse;
import com.seuprojeto.produtos.produtos.service.PedidoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoResource {

    private final PedidoService service;

    public PedidoResource(PedidoService service) {
        this.service = service;
    }

    @PostMapping
    public PedidoResponse salvar(@RequestBody PedidoRequest request) {
        return service.salvar(request);
    }

    @GetMapping
    public List<PedidoResponse> listar() {
        return service.listar();
    }
}
