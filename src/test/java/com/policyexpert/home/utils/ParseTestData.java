package com.policyexpert.home.utils;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonNode;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ObjectMapper;
import java.io.InputStream;

public class ParseTestData {

    private JsonNode json;

    public ParseTestData(String fileName){
        applyJsonFromFile(fileName);
    }

    private void applyJsonFromFile(String fileName) {

        try(InputStream in=Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName)){
            ObjectMapper mapper = new ObjectMapper();
            json = mapper.readValue(in, JsonNode.class);
        }
        catch(Exception e){
            throw new RuntimeException(e);
        }

    }

    public String getJsonValue(String node, String subNode) {
        return json.get(node).get(subNode).asText();
    }

    public String getJsonValue(String node, String subNode, String subSubNode) {
        return json.get(node).get(subNode).get(subSubNode).asText();
    }

}
