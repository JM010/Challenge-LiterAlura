package com.JCservicios.literalura.service;

import java.util.List;

public interface IConvertirDatos {

    <T> T convertirDatos(String datos, Class<T> clase);


    <T> List<T> obtenerArraysDeDatos(String datos, Class<T> clase);

}
