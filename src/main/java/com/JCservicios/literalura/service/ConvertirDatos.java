package com.JCservicios.literalura.service;


import com.JCservicios.literalura.exepciones.NotFoundJsonExeption;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;


public class ConvertirDatos implements IConvertirDatos {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public <T> T convertirDatos(String json, Class<T> clase) {
        try {
            JsonNode jsonNode = objectMapper.readTree(json);
            JsonNode arraysNode = jsonNode.get("results");

            if (arraysNode != null  && arraysNode.isArray() && !arraysNode.isEmpty()) {
                JsonNode firstElement = arraysNode.get(0);
                String firstElementJson = objectMapper.writeValueAsString(firstElement);
                return objectMapper.readValue(firstElementJson, clase);
            } else {
                throw new NotFoundJsonExeption("No se ha encontraron un libro con ese titulo.");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public <T> List<T> obtenerArraysDeDatos(String datos, Class<T> clase) {
        try {
            JsonNode rootNode = objectMapper.readTree(datos);

            JsonNode resultsArray = rootNode.get("results");

            if (resultsArray != null && !resultsArray.isEmpty()) {
                List<T> resultList = new ArrayList<>();
                for (JsonNode node : resultsArray) {
                    T result = objectMapper.treeToValue(node, clase);
                    resultList.add(result);
                }
                return resultList;
            } else {
                throw new NotFoundJsonExeption("No se encontraron resultados en el JSON.");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
