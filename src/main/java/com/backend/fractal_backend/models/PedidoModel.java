package com.backend.fractal_backend.models;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "pedido")
public class PedidoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero_pedido")
    private Long numeroPedido;

    private java.sql.Date fecha;

    @Column(name = "numero_productos")
    private Integer numeroProductos;

    @Column(name = "precio_final")
    private Double precioFinal;

    @ManyToMany
    @JoinTable(
            name = "pedido_producto",
            joinColumns = @JoinColumn(name = "pedido_id"),
            inverseJoinColumns = @JoinColumn(name = "producto_id"))
    private Set<ProductoModel> productos = new HashSet<>();

    public PedidoModel() {
    }

    public PedidoModel(Long id, Long numeroPedido, Date fecha, Integer numeroProductos, Double precioFinal, Set<ProductoModel> productos) {
        this.id = id;
        this.numeroPedido = numeroPedido;
        this.fecha = fecha;
        this.numeroProductos = numeroProductos;
        this.precioFinal = precioFinal;
        this.productos = productos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumeroPedido() {
        return numeroPedido;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setNumeroPedido(Long numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public Integer getNumeroProductos() {
        return numeroProductos;
    }

    public void setNumeroProductos(Integer numeroProductos) {
        this.numeroProductos = numeroProductos;
    }

    public Double getPrecioFinal() {
        return precioFinal;
    }

    public void setPrecioFinal(Double precioFinal) {
        this.precioFinal = precioFinal;
    }

    public Set<ProductoModel> getProductos() {
        return productos;
    }

    public void setProductos(Set<ProductoModel> productos) {
        this.productos = productos;
    }
}
