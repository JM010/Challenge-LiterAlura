package com.JCservicios.literalura.entity;

import com.JCservicios.literalura.Enum.Idiomas;
import jakarta.persistence.*;

import java.util.OptionalInt;


@Entity
@Table(name="libros")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @ManyToOne
    @JoinColumn(name= "autor_id", nullable = false)
    private Autor autor;

    @Enumerated(EnumType.STRING)
    private Idiomas idioma;

    private Integer downloads;


    public Libro (){}

    public  Libro (Long id, String titulo, Autor autor, Idiomas idioma, Integer downloads){
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.idioma = idioma;
        this.downloads = OptionalInt.of(downloads).orElse(0);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Idiomas getIdioma() {
        return idioma;
    }

    public void setIdioma(Idiomas idioma) {
        this.idioma = idioma;
    }


    public Integer getDownloads() {
        return downloads;
    }

    public void setDownloads(Integer downloads) {
        this.downloads = downloads;
    }

    @Override
    public String toString() {
       return  """
         ──────────────────────────────────────────────
          ................ « LIBRO » ................. 
        ├──────────────────────┬───────────────────────┤
          ID                   │ %-21s                
          Título               │ %-21s               
          Idioma               │ %-21s               
          Descargas            │ %-21s              
          Autor                │ %-21s                
         ──────────────────────────────────────────────
        """.formatted(
                id,
                titulo,
                idioma,
                downloads,
                autor != null ? autor.getNombre() : "—"
        );
    }
}
