package com.example.EjercicioSeguridad.repositorio;

import com.example.EjercicioSeguridad.entidad.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface LibroRepositorio extends JpaRepository<Libro, Long> {
}
