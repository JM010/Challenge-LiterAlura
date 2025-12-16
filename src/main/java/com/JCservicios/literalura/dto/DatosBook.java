package com.JCservicios.literalura.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosBook(

        @JsonAlias("title") String title,
        @JsonAlias("authors") List<DatosAutor> autores,
        @JsonAlias("languages") List<String> languages,
        @JsonAlias("download_count") Integer download
){
}
