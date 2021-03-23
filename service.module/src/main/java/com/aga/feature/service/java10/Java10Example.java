package com.aga.feature.service.java10;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Java10Example {

    private static final Logger logger = LoggerFactory.getLogger(Java10Example.class);

    public static void main(String[] args) {
        localVariable();
        unmodifiableCollections();
        optionalOrElseThrow();
    }

    private static void localVariable() {
        var message = "Java 10";
        //var emptyList = null  // illegal
        //var p = (String s) -> s.length() > 10; // illegal
        logger.debug("Local variable: " + (message instanceof String));
    }

    private static void unmodifiableCollections() {
        List<String> namesList = new ArrayList<>();
        namesList.add("Jack");
        namesList.add("Tom");

        List<String> copyOfNamesList = List.copyOf(namesList);

        namesList.add("Brad");

        List<String> copyOfNamesList2 = namesList.stream().collect(Collectors.toUnmodifiableList());

        logger.debug("List:" + namesList);
        logger.debug("To unmodifiable list: " + copyOfNamesList);
        logger.debug("To unmodifiable list: " + copyOfNamesList2);
    }

    private static void optionalOrElseThrow() {
        Optional<String> optionalWithValue = Optional.of("value");
        Optional<String> optionalEmpty = Optional.empty();
        logger.debug("Optional with value" + optionalWithValue.orElseThrow());
        logger.debug("Optional empty" + optionalEmpty.orElseThrow()); //throw NoSuchElementException
    }


}
