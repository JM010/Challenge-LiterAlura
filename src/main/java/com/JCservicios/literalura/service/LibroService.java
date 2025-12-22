package com.JCservicios.literalura.service;

import com.JCservicios.literalura.Enum.Idiomas;
import com.JCservicios.literalura.entity.Libro;
import com.JCservicios.literalura.repository.LibrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService {

    private final LibrosRepository repo;

    public  LibroService(LibrosRepository repo) {
        this.repo = repo;
    }

    public Libro guardarLibro(Libro libro) {
        if (libro == null) {
            throw new IllegalArgumentException("El libro no puede ser null");
        } else {
            return repo.save(libro);
        }
    }

    public Optional<Libro> buscarPorTitulo(String titulo) {
        if (titulo == null || titulo.isEmpty()) {
            throw new IllegalArgumentException("El título no puede ser null o vacío");
        }
        return repo.findByTitulo(titulo);
    }

    public List<Libro> listarLibros() {
        return repo.listarLibros();
    }

    public List<Libro> listarLibrosPorIdioma(Idiomas idioma) {
        return repo.listarLibrosPorIdioma(idioma);
    }

    public List<Libro> obtenerTop10Descargas() {
        return repo.Top10descargas();
    }







}
