package com.JCservicios.literalura.repository;

import com.JCservicios.literalura.Enum.Idiomas;
import com.JCservicios.literalura.entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface LibrosRepository extends JpaRepository<Libro, Long> {

    Optional<Libro> findByTitulo(String titulo);

    @Query("SELECT l FROM Libro l JOIN  l.autor ORDER BY l.ID ")
    List<Libro> listarLibros();

    @Query("SELECT l FROM Libro l JOIN  l.autor WHERE l.idioma = :idioma ORDER BY l.ID")
    List<Libro> listarLibrosPorIdioma(Idiomas idioma);

    @Query("SELECT l FROM Libro l JOIN l.autor ORDER BY l.downloads DESC LIMIT 10")
    List<Libro> Top10descargas();


}
