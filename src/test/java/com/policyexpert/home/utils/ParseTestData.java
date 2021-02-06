package com.policyexpert.home.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.policyexpert.home.dto.TestDataDto;
import java.io.InputStream;

public class ParseTestData {
    public static TestDataDto parseJsonFromFile(String fileName) {
        try(InputStream in=Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName)){
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(in, TestDataDto.class);
        }
        catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
