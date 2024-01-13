package com.backend.fractal_backend.services;

import com.backend.fractal_backend.models.ProductoModel;
import com.backend.fractal_backend.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;

    @Autowired
    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public List<ProductoModel> consultarProductos() {
        return productoRepository.findAll();
    }

    public Optional<ProductoModel> buscarProductoId(Long id) {
        return productoRepository.findById(id);
    }

    public ProductoModel guardarProducto(ProductoModel producto) {
        return productoRepository.save(producto);
    }

    public ProductoModel actualizarProducto(Long id, ProductoModel productoActualizado) {
        Optional<ProductoModel> productoExistente = productoRepository.findById(id);

        if (productoExistente.isPresent()) {
            ProductoModel producto = productoExistente.get();
            producto.setNombre(productoActualizado.getNombre());
            producto.setPrecioUnitario(productoActualizado.getPrecioUnitario());
            producto.setCantidad(productoActualizado.getCantidad());

            return productoRepository.save(producto);
        } else {
            throw new RuntimeException("Producto no encontrado con el ID: " + id);
        }
    }

    public boolean eliminarProducto(Long id) {
        Optional<ProductoModel> productoExistente = productoRepository.findById(id);

        if (productoExistente.isPresent()) {
            productoRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
