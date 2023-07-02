package com.example.EjercicioSeguridad.repositorio;

import com.example.EjercicioSeguridad.entidad.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepositorio extends JpaRepository<Autor, Long> {
}
