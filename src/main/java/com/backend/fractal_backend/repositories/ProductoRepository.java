package com.backend.fractal_backend.repositories;

import com.backend.fractal_backend.models.ProductoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository <ProductoModel,Long> {
}
