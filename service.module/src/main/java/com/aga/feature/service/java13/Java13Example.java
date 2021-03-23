package com.aga.feature.service.java13;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Java13Example {

    private static final Logger logger = LoggerFactory.getLogger(Java13Example.class);

    public static void main(String[] args) {
        //preview
        switchExpression();
        //preview
        textBlock();
    }

    private static void switchExpression() {
        int value = 50;
        String operation = "multiply";
        int resultByTwo = switch (operation) {
            case "divide" -> {
                yield value / 2;
            }
            case "multiply" -> {
                yield value * 2;
            }
            default -> value;
        };

        logger.debug("Switch expression: " + resultByTwo);
    }

    private static void textBlock() {
        String jsonString
                = "{\n" +
                "    \"id\": \"2652\",\n" +
                "    \"characteristics\": [{\n" +
                "            \"name\": \"characteristicName\",\n" +
                "            \"value\": \"characteristicValue\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"name\": \"name\n" +
                "}";

        String jsonTextBlock = """
                {
                     "id": "2652",
                     "characteristics": [{
                             "name": "characteristicName",
                             "value": "characteristicValue"
                         }
                     ],
                     "name": "name
                 }
                """;

        logger.debug("String: " + jsonString);
        logger.debug("Text block: " + jsonTextBlock);
    }


}
