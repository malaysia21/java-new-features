package com.aga.feature.service.java10;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Java10Example {

    public static void main(String[] args) {
        localVariable();
        unmodifiableCollections();
        optionalOrElseThrow();
    }


    private static void localVariable() {
        var message = "Java 10";
        //var emptyList = null  // illegal
        //var p = (String s) -> s.length() > 10; // illegal
        System.out.println(message + ": " + message instanceof String);
    }

    private static void unmodifiableCollections() {

        List<String> namesList = new ArrayList<>();
        namesList.add("Jack");
        namesList.add("Tom");

        List<String> copyOfNamesList = List.copyOf(namesList);

        namesList.add("Brad");

        List<String> copyOfNamesList2 = namesList.stream().collect(Collectors.toUnmodifiableList());

        System.out.println(namesList);
        System.out.println(copyOfNamesList);
        System.out.println(copyOfNamesList2);

    }

    private static void optionalOrElseThrow() {
        Optional<String> optionalWithValue = Optional.ofNullable("value");
        Optional<String> optionalEmpty = Optional.empty();
        System.out.println(optionalWithValue.orElseThrow());
        System.out.println(optionalEmpty.orElseThrow()); //throw NoSuchElementException
    }


}
