package com.JCservicios.literalura.repository;

import com.JCservicios.literalura.entity.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface AutorRepository extends JpaRepository<Autor,Long> {


     Optional<Autor>findByNombre(String nombre);

     @Query("SELECT a FROM Autor a JOIN a.libros ORDER BY a.ID")
     List<Autor> listarAutores();

     @Query("SELECT a FROM Autor a JOIN a.libros WHERE a.nombre ILIKE %:nombre%")
     Optional<Autor> buscarPorNombre(String nombre);

     @Query("SELECT a FROM Autor a JOIN a.libros l WHERE a.anioDeNacimiento <= :anio")
     List<Autor> autoresPorAnioDeNacimiento(Integer anio);
}
