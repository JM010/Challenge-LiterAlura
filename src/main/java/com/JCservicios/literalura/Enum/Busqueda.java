package com.JCservicios.literalura.Enum;

public enum Busqueda {
    LIBRO_AUTOR("search="),
    ORDENAR_POR_POPULARIDAD("sort");

    private final String codigo;

    Busqueda(String string) {
        this.codigo = string;
    }

    public String getCodigo() {
        return codigo;
    }
}
