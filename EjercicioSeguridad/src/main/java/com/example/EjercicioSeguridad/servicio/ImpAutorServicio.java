package com.example.EjercicioSeguridad.servicio;

import com.example.EjercicioSeguridad.entidad.Autor;
import com.example.EjercicioSeguridad.repositorio.AutorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImpAutorServicio implements AutorServicio{

    @Autowired
    AutorRepositorio autorRepositorio;

    @Override
    public List<Autor> listarTodosLosAutores() {
        return autorRepositorio.findAll();
    }

    @Override
    public Autor guardarAutor(Autor autor) {
        return autorRepositorio.save(autor);
    }

    @Override
    public Autor obtenerAutorPorId(Long id) {
        return autorRepositorio.findById(id).get();
    }

    @Override
    public Autor actualizarAutor(Autor autor) {
        return autorRepositorio.save(autor);
    }

    @Override
    public void eliminarAutor(Autor autor) {
        autorRepositorio.delete(autor);
    }



}
