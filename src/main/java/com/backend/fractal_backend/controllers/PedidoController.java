package com.backend.fractal_backend.controllers;

import com.backend.fractal_backend.models.PedidoModel;
import com.backend.fractal_backend.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class PedidoController {

    private final PedidoService pedidoService;

    @Autowired
    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping("/pedidos")
    public List<PedidoModel> obtenerPedidos() {
        return pedidoService.ConsultarPedidos();
    }

    @PostMapping("/pedidos")
    public ResponseEntity<PedidoModel> agregarPedido(@RequestBody PedidoModel pedido) {
        PedidoModel nuevoPedido = pedidoService.agregarPedido(pedido);
        return new ResponseEntity<>(nuevoPedido, HttpStatus.CREATED);
    }

    @GetMapping("/ultimo-id")
    public ResponseEntity<Long> obtenerUltimoId() {
        Long ultimoId = pedidoService.obtenerUltimoId();
        return ResponseEntity.ok(ultimoId);
    }

}

