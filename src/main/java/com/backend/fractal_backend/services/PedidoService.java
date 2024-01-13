package com.backend.fractal_backend.services;

import com.backend.fractal_backend.models.PedidoModel;
import com.backend.fractal_backend.repositories.PedidoRepository;
import com.backend.fractal_backend.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ProductoRepository productoRepository;

    @Autowired
    public PedidoService(PedidoRepository pedidoRepository, ProductoRepository productoRepository) {
        this.pedidoRepository = pedidoRepository;
        this.productoRepository = productoRepository;
    }

    public List<PedidoModel> ConsultarPedidos() {
        return pedidoRepository.findAll();
    }

    public PedidoModel agregarPedido(PedidoModel pedido) {
        pedido.setNumeroPedido(obtenerUltimoId()+1);
        return pedidoRepository.save(pedido);
    }

    public Long obtenerUltimoId() {
        Optional<Long> ultimoId = pedidoRepository.findMaxId();
        return ultimoId.orElse(0L);
    }
}


