package com.example.EjercicioSeguridad.servicio;

import com.example.EjercicioSeguridad.entidad.Autor;
import com.example.EjercicioSeguridad.entidad.Libro;
import com.example.EjercicioSeguridad.repositorio.AutorRepositorio;
import com.example.EjercicioSeguridad.repositorio.LibroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImpLibroServicio implements LibroServicio {


    @Autowired
    LibroRepositorio libroRepositorio;
    @Autowired
    AutorRepositorio autorRepositorio;


    @Override
    public List<Libro> listarTodosLosLibros() {
        return libroRepositorio.findAll();
    }

    @Override
    public Libro guardarLibro(Libro libro) {
        return libroRepositorio.save(libro);
    }

    @Override
    public Libro obtenerLibroPorId(Long id) {
        return libroRepositorio.findById(id).get();
    }

    @Override
    public Libro actualizarLibro(Libro libro) {
        return libroRepositorio.save(libro);
    }

    @Override
    public void eliminarLibro(Libro libro) {
        libroRepositorio.delete(libro);
    }

    @Override
    public Autor obtenerNombreyApellido(Autor autor) {
        return autorRepositorio.save(autor);
    }


}
