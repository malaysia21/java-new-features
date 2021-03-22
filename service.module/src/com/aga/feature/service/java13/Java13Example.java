package com.aga.feature.service.java13;

public class Java13Example {

    public static void main(String[] args) {
        //Preview
        switchExpression();
        //Preview
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

        System.out.println(resultByTwo);
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

        System.out.println(jsonString);
        System.out.println(jsonTextBlock);
    }


}
