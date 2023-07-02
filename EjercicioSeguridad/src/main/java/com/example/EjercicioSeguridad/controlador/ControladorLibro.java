package com.example.EjercicioSeguridad.controlador;

import com.example.EjercicioSeguridad.entidad.Autor;
import com.example.EjercicioSeguridad.entidad.Libro;
import com.example.EjercicioSeguridad.servicio.AutorServicio;
import com.example.EjercicioSeguridad.servicio.LibroServicio;
import com.example.EjercicioSeguridad.servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.Optional;

import java.util.List;

@Controller
public class ControladorLibro {

    @Autowired
    private LibroServicio libroServicio;

    @Autowired
    private AutorServicio autorServicio;

    @Autowired
    private UsuarioServicio Uservicio;



    @GetMapping("/login")
    public String iniciarSesion(){
        return "login";
    }


    @GetMapping("/")
    public String verPaginaDeInicio(Model modelo){
        modelo.addAttribute("usuarios", Uservicio.listarUsuarios());
        return "index";
    }

    @GetMapping("/inicio")
    public String inicio(){
        return "inicio";
    }


    @GetMapping("/home")
    public String paginaPrincipal(){
        return "home";
    }

    @GetMapping("/libros")
    public String listarLibros(Model modelo) {
        modelo.addAttribute("libros", libroServicio.listarTodosLosLibros());
        return "libros";
    }

    @GetMapping("/libro")
    public String listarLibrosInicio(Model modelo) {
        modelo.addAttribute("libros", libroServicio.listarTodosLosLibros());
        return "libro";
    }


    @GetMapping("/libros/nuevo")
    public String crearLibroFormulario(Model modelo) {
        Libro libro = new Libro();
        List<Autor> listaAutores = autorServicio.listarTodosLosAutores();

        modelo.addAttribute("libro", libro);
        modelo.addAttribute("autores", listaAutores);

        return "crear_libro";
    }

    @PostMapping("/libros")
    public String guardarLibro(@ModelAttribute("libro") Libro libro, RedirectAttributes redirect) {
        libroServicio.guardarLibro(libro);

        redirect.addFlashAttribute("msgExito", "El libro ha" +
                " sido agregado con exito");

        return "redirect:/libros";
    }

    @GetMapping("/libros/editar/{id}")
    public String mostrarFormularioDeEditar(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("libro", libroServicio.obtenerLibroPorId(id));
        return "editar_libro";
    }

    @PostMapping("/libros/{id}")
    public String actualizarLibro(@PathVariable Long id, @ModelAttribute("libro") Libro libro, Model modelo) {
        Libro libroExistente = libroServicio.obtenerLibroPorId(id);
        Autor autorExistente = autorServicio.obtenerAutorPorId(id);

        libroExistente.setIsbn(libro.getIsbn());
        libroExistente.setTitulo(libro.getTitulo());
        libroExistente.setYear(libro.getYear());
        autorExistente.setNombre(autorExistente.getNombre());
        libroExistente.setCantidad(libro.getCantidad());
        libroExistente.setCondicion_libro(libro.getCondicion_libro());

        libroServicio.actualizarLibro(libroExistente);
        return "redirect:/libros";
    }


    @PostMapping("/eliminar/libro/{id}")
    public String eliminarLibro(@PathVariable Long id, RedirectAttributes redirect) {
        Libro libro = libroServicio.obtenerLibroPorId(id);

        libroServicio.eliminarLibro(libro);

        redirect.addFlashAttribute("msgExito", "El libro ha " +
                "sido eliminado correctamente");

        return "redirect:/libros";

    }
}
