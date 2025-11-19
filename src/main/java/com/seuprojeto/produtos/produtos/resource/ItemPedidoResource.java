package com.seuprojeto.produtos.produtos.resource;

import com.seuprojeto.produtos.produtos.dto.ItemPedidoRequest;
import com.seuprojeto.produtos.produtos.dto.ItemPedidoResponse;
import com.seuprojeto.produtos.produtos.service.ItemPedidoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itens-pedido")
public class ItemPedidoResource {

    private final ItemPedidoService service;

    public ItemPedidoResource(ItemPedidoService service) {
        this.service = service;
    }

    @PostMapping
    public ItemPedidoResponse salvar(@RequestBody ItemPedidoRequest request) {
        return service.salvar(request);
    }

    @GetMapping
    public List<ItemPedidoResponse> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemPedidoResponse> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemPedidoResponse> atualizar(@PathVariable Long id, @RequestBody ItemPedidoRequest request) {
        return ResponseEntity.ok(service.atualizar(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
