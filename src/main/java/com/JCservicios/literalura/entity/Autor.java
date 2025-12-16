package com.JCservicios.literalura.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name= "autores")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private Integer anioDeNacimiento;

    private Integer anioDeFallecimiento;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.EAGER )
    private List<Libro> libros =  new ArrayList<>();

    public  Autor (){}

    public Autor(String nombre, Integer anioNacimiento, Integer anioFallecimiento) {
        this.nombre = nombre;
        this.anioDeNacimiento = anioNacimiento;
        this.anioDeFallecimiento = anioFallecimiento;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getAnioDeNacimiento() {
        return anioDeNacimiento;
    }

    public void setAnioDeNacimiento(Integer anioDeNacimiento) {
        this.anioDeNacimiento = anioDeNacimiento;
    }

    public Integer getAnioDeFallecimiento() {
        return anioDeFallecimiento;
    }

    public void setAnioDeFallecimiento(Integer anioDeFallecimiento) {
        this.anioDeFallecimiento = anioDeFallecimiento;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void agregarLibro (Libro libro) {
        this.libros.add(libro);
        libro.setAutor(this);
    }

    @Override
    public String toString() {
        String libroString =(!libros.isEmpty()) ? libros.stream()
                .map(Libro::getTitulo)
                .collect(Collectors.joining(", ")) :
                "Sin libros registrados";

        return """
         ──────────────────────────────────────────────
         ................ « AUTOR » ................. 
        ├──────────────────────┬───────────────────────┤
          ID                   │ %-21s                
          Nombre               │ %-21s               
          Año de nacimiento    │ %-21s               
          Año de fallecimiento │ %-21s               
          Libros               │ %-21s              
        ───────────────────────┴────────────────────────
        """.formatted(
                id,
                nombre,
                anioDeNacimiento != null ? anioDeNacimiento : "—",
                anioDeFallecimiento != null ? anioDeFallecimiento : "—",
                libroString
        );
    }

}
