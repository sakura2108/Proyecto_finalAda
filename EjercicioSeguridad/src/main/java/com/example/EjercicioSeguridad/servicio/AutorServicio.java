package com.example.EjercicioSeguridad.servicio;

import com.example.EjercicioSeguridad.entidad.Autor;

import java.util.List;

public interface AutorServicio {

    public List<Autor> listarTodosLosAutores();

    public Autor guardarAutor(Autor autor);

    public Autor obtenerAutorPorId (Long id);

    public Autor actualizarAutor(Autor autor);

    public void eliminarAutor(Autor autor);



}
