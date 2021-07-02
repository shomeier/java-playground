package org.sho.jsonpath;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.DocumentContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class JsonPath {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonPath.class);

    public static void main( String[] args ) throws JsonProcessingException {
        final var classloader = Thread.currentThread().getContextClassLoader();
        final var is = classloader.getResourceAsStream("json/google-vision-result.json");
        final DocumentContext context = com.jayway.jsonpath.JsonPath.parse(is);
        final List<String> result = context.read("$.responses[0].labelAnnotations[?(@.score > 0.80)]");

        LOGGER.info("JSON Path Result:\n{}", result);

        final String prettyPrintResult = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(result);
        LOGGER.info("JSON Path Result - Pretty Print: \n{}", prettyPrintResult);
    }
}
