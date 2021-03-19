package com.aga.feature.service.java9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Java9Example {

    public static void main(String[] args) throws IOException {
        //try with resource example
        tryWithResource();

        //private method in interface
        InterfaceWithPrivateMethod interfaceTest = new InterfaceWithPrivateMethod() {};
        interfaceTest.methodDefault("Testing interface");

        //new factory methods for immutable Set, List, Map
        createImmutableSet();

        //Optional improvement
        optionalImprovement();
    }


    private static void tryWithResource() throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader("C:/projects/java-new-features/service.module/test.txt"));
        try (fileReader) {
            System.out.println(fileReader.readLine());
        }
    }

    private static void createImmutableSet(){
        Set<String> immutableSet = Set.of("Test1", "Test2");
        Map<Integer, String> immutableMap = Map.of(1, "one", 2, "two", 3, "three");

        System.out.println(immutableSet);
        System.out.println(immutableMap);
    }

    private static void optionalImprovement(){
        Optional<String> optionalValue = Optional.of("A");
        List<String> resultList = optionalValue.stream().map(String::toUpperCase).collect(Collectors.toList());

        System.out.println("Optional to stream: " + resultList);


        Optional<Integer> optionalValue2 = Optional.of(4);
        optionalValue2.ifPresentOrElse(x -> System.out.println("Result found: " + x), () -> System.out.println("Not Found"));

        Optional<String> optionalValue3 = Optional.empty();
        Supplier<Optional<String>> defaultValue = () -> Optional.of("Default value");
        Optional<String> resultValue = optionalValue3.or(defaultValue);

        System.out.println(resultValue.get());
    }


    interface InterfaceWithPrivateMethod{
        default void methodDefault(String s){
            privateMethod(s);
        }
        private void privateMethod(String s){
            System.out.println("Private method: " + s);
        }
    }
}
