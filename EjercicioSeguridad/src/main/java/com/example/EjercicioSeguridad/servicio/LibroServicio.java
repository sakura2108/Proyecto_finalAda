package com.example.EjercicioSeguridad.servicio;

import com.example.EjercicioSeguridad.entidad.Autor;
import com.example.EjercicioSeguridad.entidad.Libro;

import java.util.List;

public interface LibroServicio {

    public List<Libro> listarTodosLosLibros();

    public Libro guardarLibro(Libro libro);

    public Libro obtenerLibroPorId (Long id);

    public Libro actualizarLibro(Libro libro);

    public void eliminarLibro(Libro libro);

    public Autor obtenerNombreyApellido(Autor autor);



}
