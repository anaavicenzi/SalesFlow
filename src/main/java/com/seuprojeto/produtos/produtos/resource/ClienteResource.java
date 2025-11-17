package com.seuprojeto.produtos.produtos.resource;

import com.seuprojeto.produtos.produtos.dto.ClienteRequest;
import com.seuprojeto.produtos.produtos.dto.ClienteResponse;
import com.seuprojeto.produtos.produtos.service.ClienteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteResource {

    private final ClienteService service;

    public ClienteResource(ClienteService service) {
        this.service = service;
    }

    @PostMapping
    public ClienteResponse salvar(@RequestBody ClienteRequest request) {
        return service.salvar(request);
    }

    @GetMapping
    public List<ClienteResponse> listar() {
        return service.listar();
    }
}
