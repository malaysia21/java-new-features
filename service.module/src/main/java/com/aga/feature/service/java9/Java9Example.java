package com.aga.feature.service.java9;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;



public class Java9Example {
    private static final Logger logger = LoggerFactory.getLogger(Java9Example.class);

    public static void main(String[] args) throws IOException {

        tryWithResource();

        InterfaceWithPrivateMethod interfaceTest = new InterfaceWithPrivateMethod() {};
        interfaceTest.methodDefault("Testing interface");

        createImmutableSet();

        optionalImprovement();

    }


    private static void tryWithResource() throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader("C:/projects/java-new-features/service.module/src/main/resources/test_9.txt"));
        try (fileReader) {
            logger.debug("Try with resource: " + fileReader.readLine());
        }
    }

    private static void createImmutableSet() {
        Set<String> immutableSet = Set.of("Test1", "Test2");
        Map<Integer, String> immutableMap = Map.of(1, "one", 2, "two", 3, "three");

        logger.debug("Immutable Set: " + immutableSet.toString());
        logger.debug("Immutable Map: " + immutableMap.toString());
    }

    private static void optionalImprovement() {
        Optional<String> optionalValue = Optional.of("A");
        List<String> resultList = optionalValue.stream().map(String::toUpperCase).collect(Collectors.toList());

        logger.debug("Optional stream: " + resultList);


        Optional<Integer> optionalValue2 = Optional.of(4);
        optionalValue2.ifPresentOrElse(x -> logger.debug("Result found: " + x), () -> logger.debug("Not Found"));

        Optional<String> optionalValue3 = Optional.empty();
        Supplier<Optional<String>> defaultValue = () -> Optional.of("Default value");
        Optional<String> resultValue = optionalValue3.or(defaultValue);

        resultValue.ifPresent(value -> logger.debug("Optional or: " + value));
    }


    interface InterfaceWithPrivateMethod {
        default void methodDefault(String s) {
            privateMethod(s);
        }

        private void privateMethod(String s) {
            logger.debug("Interface private method: " + s);
        }
    }
}
