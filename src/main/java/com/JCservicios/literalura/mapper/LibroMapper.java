package com.JCservicios.literalura.mapper;

import com.JCservicios.literalura.Enum.Idiomas;
import com.JCservicios.literalura.dto.DatosAutor;
import com.JCservicios.literalura.dto.DatosBook;
import com.JCservicios.literalura.entity.Autor;
import com.JCservicios.literalura.entity.Libro;

import java.util.List;

public class LibroMapper {

    // Metodo para obtener el autor principal de la lista de autores
    public DatosAutor obtenerAutorPrincipal(List<DatosAutor> autores) {
        if (autores == null || autores.isEmpty()) {
            return null;
        }
        return autores.get(0);
    }

    //Metodo para obtener el lenguaje principal de la lista de lenguajes
    public String obtenerLenguajePrincipal(List<String> lenguajes) {
        if (lenguajes == null || lenguajes.isEmpty()) {
            return null;
        }
        return lenguajes.get(0);
    }


    // Metodo para mapear DatosBook a Libro
    public Libro toEntity(DatosBook dto, Autor autor, Idiomas idioma) {
        Libro libro = new Libro();
        libro.setTitulo(dto.title());
        libro.setAutor(autor);
        libro.setIdioma(idioma);
        libro.setDownloads(dto.download());
        return libro;
    }

}
