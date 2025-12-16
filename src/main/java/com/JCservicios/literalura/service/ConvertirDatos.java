package com.JCservicios.literalura.service;


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

            if (arraysNode != null  && arraysNode.isArray() && arraysNode.size() > 0) {
                JsonNode firstElement = arraysNode.get(0);
                String firstElementJson = objectMapper.writeValueAsString(firstElement);
                return objectMapper.readValue(firstElementJson, clase);
            } else {
                throw new RuntimeException("No se encontraron resultados en el JSON.");
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

            if (resultsArray != null && resultsArray.size() > 0) {
                List<T> resultList = new ArrayList<>();
                for (JsonNode node : resultsArray) {
                    T result = objectMapper.treeToValue(node, clase);
                    resultList.add(result);
                }
                return resultList;
            } else {
                throw new RuntimeException("No se encontraron resultados en el JSON.");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
