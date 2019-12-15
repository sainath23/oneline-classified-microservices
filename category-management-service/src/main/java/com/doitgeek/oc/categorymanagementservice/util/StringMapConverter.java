package com.doitgeek.oc.categorymanagementservice.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Converter
public class StringMapConverter implements AttributeConverter<Map<String, String>, String> {

    private static ObjectMapper objectMapper;

    static {
        objectMapper = new ObjectMapper();
    }

    @Override
    public String convertToDatabaseColumn(Map<String, String> attribute) {

        if(attribute == null) {
            return "{}";
        }

        try {
            return objectMapper.writeValueAsString(attribute);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Error converting map to JSON", e);
        }
    }

    @Override
    public Map<String, String> convertToEntityAttribute(String dbData) {

        if (dbData == null) {
            return new HashMap<>();
        }

        try {
            return objectMapper.readValue(dbData, new TypeReference<Map<String, String>>() {});
        } catch (IOException e) {
            throw new IllegalArgumentException("Error converting JSON to map", e);
        }
    }
}
