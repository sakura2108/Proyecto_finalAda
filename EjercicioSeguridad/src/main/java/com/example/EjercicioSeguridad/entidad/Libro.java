package com.example.EjercicioSeguridad.entidad;

import javax.persistence.*;

@Entity
@Table(name="libros")
public class Libro {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "libro_id")
    private Long id;

    @Column(name = "libro_isbn", nullable = false)
    private Long isbn;

    @Column(name = "libro_titulo", nullable = false, length = 100)
    private String titulo;

    @Column(name = "libro_año", columnDefinition = "YEAR")
    private Integer year;

    @Column(name = "cant_ejemplares", nullable = false)
    private Integer cantidad;

    @Column(name = "condicion_libro", nullable = false)
    private Integer condicion_libro;


    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Autor autor;

    public Libro() {
    }

    public Libro(Long id, Long isbn, String titulo, Integer year, Integer cantidad, Integer condicion_libro, Autor autor) {
        this.id = id;
        this.isbn = isbn;
        this.titulo = titulo;
        this.year = year;
        this.cantidad = cantidad;
        this.condicion_libro = condicion_libro;
        this.autor = autor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getCondicion_libro() {
        return condicion_libro;
    }

    public void setCondicion_libro(Integer condicion_libro) {
        this.condicion_libro = condicion_libro;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
}
