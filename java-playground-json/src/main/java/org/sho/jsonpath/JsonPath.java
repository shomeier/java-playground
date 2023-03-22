package org.sho.jsonpath;

import com.alibaba.fastjson2.JSONPath;
import com.alibaba.fastjson2.JSONReader;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.spi.json.JacksonJsonProvider;
import com.jayway.jsonpath.spi.mapper.JacksonMappingProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class JsonPath {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonPath.class);

    public static void main( String[] args ) throws Exception {
        // googleResult();
        apiResultFastJson();
        // apiResultJsonPath();
    }

    private static final Configuration JACKSON_CONFIGURATION = Configuration
            .builder()
            .mappingProvider(new JacksonMappingProvider())
            .jsonProvider(new JacksonJsonProvider())
            .build();


    private static void apiResultFastJson() throws Exception {
        final var classloader = Thread.currentThread().getContextClassLoader();
        final var is = classloader.getResourceAsStream("json/api-results-retrieve-asset.json");
        final var jsonPath = "$.assets.asset[0].meta.itm[?(@.key == 'rncIdentifier')].value[0]";
        String json = new String(is.readAllBytes(), StandardCharsets.UTF_8);

        JSONReader jsonReader = JSONReader.of(json);
        JSONPath jsonPathAli = JSONPath.of(jsonPath);
        final Object resultAli = jsonPathAli.extract(jsonReader);
        String resultAliString = (String) resultAli;
        LOGGER.info("resultAli:\n{}", resultAli);
        LOGGER.info("resultAliString:\n{}", resultAliString);
    }

    private static void apiResultJsonPath() throws Exception {
        final var classloader = Thread.currentThread().getContextClassLoader();
        final var is = classloader.getResourceAsStream("json/api-results-retrieve-asset.json");
        final var jsonPath = "$.assets.asset[0].meta.itm[?(@.key == 'rncIdentifier')].value";
        String json = new String(is.readAllBytes(), StandardCharsets.UTF_8);

        final Object document = JACKSON_CONFIGURATION.jsonProvider().parse(json);

        final DocumentContext context = com.jayway.jsonpath.JsonPath.parse(is);
        // final Object result = context.read("$.assets.asset[0].meta.itm[?(@.key == 'rncIdentifier')].value");

        Object result = com.jayway.jsonpath.JsonPath.read(document, jsonPath);
        final String prettyJson = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(result);

        LOGGER.info("JSON Path Result:\n{}", result);
        LOGGER.info("JSON prettyJsont:\n{}", prettyJson);

        final String prettyPrintResult = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(result);
        LOGGER.info("JSON Path Result - Pretty Print: \n{}", prettyPrintResult);
    }

    private static void googleResult() throws JsonProcessingException {
        final var classloader = Thread.currentThread().getContextClassLoader();
        final var is = classloader.getResourceAsStream("json/google-vision-result.json");
        final DocumentContext context = com.jayway.jsonpath.JsonPath.parse(is);
        final List<String> result = context.read("$.responses[0].labelAnnotations[?(@.score > 0.80)]");

        LOGGER.info("JSON Path Result:\n{}", result);

        final String prettyPrintResult = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(result);
        LOGGER.info("JSON Path Result - Pretty Print: \n{}", prettyPrintResult);
    }
}
