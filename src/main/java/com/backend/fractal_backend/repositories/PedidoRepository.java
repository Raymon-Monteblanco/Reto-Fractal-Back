package com.backend.fractal_backend.repositories;

import com.backend.fractal_backend.models.PedidoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PedidoRepository extends JpaRepository<PedidoModel, Long> {
    @Query("SELECT MAX(p.id) FROM PedidoModel p")
    Optional<Long> findMaxId();
}
