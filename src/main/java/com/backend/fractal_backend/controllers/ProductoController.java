package com.backend.fractal_backend.controllers;

import com.backend.fractal_backend.models.ProductoModel;
import com.backend.fractal_backend.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.backend.fractal_backend.repositories.ProductoRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductoController {

    private final ProductoService productoService;

    @Autowired
    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping("/productos")
    public List<ProductoModel> obtenerProductos() {
        return productoService.consultarProductos();
    }

    @PostMapping("/productos")
    public ProductoModel crearProducto(@RequestBody ProductoModel producto) {
        return productoService.guardarProducto(producto);
    }

    @GetMapping("/productos/{id}")
    public ResponseEntity<ProductoModel> buscarProductoId(@PathVariable Long id) {
        Optional<ProductoModel> producto = productoService.buscarProductoId(id);

        if (producto.isPresent()) {
            return new ResponseEntity<>(producto.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/productos/{id}")
    public ResponseEntity<ProductoModel> actualizarProducto(@PathVariable Long id, @RequestBody ProductoModel producto) {
        ProductoModel productoActualizado = productoService.actualizarProducto(id, producto);
        return ResponseEntity.ok(productoActualizado);
    }

    @DeleteMapping("/productos/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Long id) {
        boolean eliminado = productoService.eliminarProducto(id);

        if (eliminado) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
