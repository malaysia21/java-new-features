package com.aga.feature.service.java11;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Java11Example {

    private static final Logger logger = LoggerFactory.getLogger(Java11Example.class);

    public static void main(String[] args) throws IOException {
        stringMethodLines();
        stringMethodStrip();
        stringMethodBlank();
        stringMethodRepeat();

        readWriteFileMethod();

        collectionToArray();

        predicateNotMethod();
    }

    private static void stringMethodLines() {
        String testString = "Testing \n Java \n\n 11\n !";
        List<String> stringArray = testString
                .lines()
                .filter(line -> !line.isBlank())
                .map(String::strip)
                .collect(Collectors.toList());

        logger.debug("String method lines(): " + stringArray);
    }

    private static void stringMethodStrip() {
        logger.debug("String method strip(): " + "   test  ".strip());            //"test"
        logger.debug("String method stripLeading(): " + "   test  ".stripLeading());     //"test   "
        logger.debug("String method stripTrailing(): " + "   test  ".stripTrailing());    //"   test"
    }

    private static void stringMethodBlank() {
        logger.debug("String isBlank: " + "test".isBlank());  //false
        logger.debug("String isBlank: " + "".isBlank());   //true
        logger.debug("String isBlank: " + "    ".isBlank());   //true
        logger.debug("String isEmpty: " + "test".isEmpty());  //false
        logger.debug("String isEmpty: " + "".isEmpty());   //true
        logger.debug("String isEmpty: " + "    ".isEmpty());   //false
    }

    private static void stringMethodRepeat() {
        String str = "TESTY".repeat(3);
        logger.debug("String method repeat: " + str);
    }

    private static void collectionToArray() {
        List<String> languageList = Arrays.asList("Java", "Python", "Kotlin");

        //Before Java 11
        String[] languageArrayOld = languageList.toArray(new String[languageList.size()]);

        //Since Java 11
        String[] languageArrayNew = languageList.toArray(String[]::new);

        logger.debug("Collection to array: " + Arrays.toString(languageArrayOld));
        logger.debug("Collection to array: " + Arrays.toString(languageArrayNew));
    }


    private static void readWriteFileMethod() throws IOException {
        Path dir = Paths.get("C:/projects/java-new-features/service.module/src/main/resources/test_11.txt");
        Path filePath = Files.writeString(dir, "Java 11 Test");
        String fileContent = Files.readString(filePath, Charset.defaultCharset());

        logger.debug("Write/Read String: " + fileContent);
    }

    private static void predicateNotMethod() {
        List<String> languageList = Arrays.asList("Java", "Python", "Kotlin", "\n  ", "  ");
        List<String> result = languageList.stream()
                .filter(Predicate.not(String::isBlank))
                .collect(Collectors.toList());

        logger.debug("Predicate not method: (before): " + languageList);
        logger.debug("Predicate not method: (after): " + result);
    }

}
