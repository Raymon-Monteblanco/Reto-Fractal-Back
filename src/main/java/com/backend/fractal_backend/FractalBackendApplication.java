package com.backend.fractal_backend;

import com.backend.fractal_backend.models.PedidoModel;
import com.backend.fractal_backend.models.ProductoModel;
import com.backend.fractal_backend.services.ProductoService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class FractalBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(FractalBackendApplication.class, args);
	}

}
