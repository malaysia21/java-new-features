package com.aga.feature.service.java11;

import java.io.FileFilter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Java11Example {

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

        System.out.println(stringArray);
    }

    private static void stringMethodStrip() {
        System.out.println("   test  ".strip());            //"test"
        System.out.println("   test  ".stripLeading());     //"test   "
        System.out.println("   test  ".stripTrailing());    //"   test"
    }

    private static void stringMethodBlank() {
        System.out.println("test".isBlank());  //false
        System.out.println("".isBlank());   //true
        System.out.println("    ".isBlank());   //true
        System.out.println("test".isEmpty());  //false
        System.out.println("".isEmpty());   //true
        System.out.println("    ".isEmpty());   //false
    }

    private static void stringMethodRepeat() {
        String str = "TESTY".repeat(3);
        System.out.println(str);
    }

    private static void collectionToArray() {
        List<String> languageList = Arrays.asList("Java", "Python", "Kotlin");

        //Before Java 11
        String[] languageArrayOld = languageList.toArray(new String[languageList.size()]);

        //Since Java 11
        String[] languageArrayNew = languageList.toArray(String[]::new);

        System.out.println(Arrays.toString(languageArrayOld));
        System.out.println(Arrays.toString(languageArrayNew));
    }


    private static void readWriteFileMethod() throws IOException {
        Path dir = Paths.get("C:\\projects\\java-new-features\\service.module\\test_11.txt");
        Path filePath = Files.writeString(dir, "Java 11 Test");
        String fileContent = Files.readString(filePath, Charset.defaultCharset());

        System.out.println(fileContent);
    }

    private static void predicateNotMethod() {
        List<String> languageList = Arrays.asList("Java", "Python", "Kotlin", "\n  ", "  ");
        List<String> result = languageList.stream()
                .filter(Predicate.not(String::isBlank))
                .collect(Collectors.toList());

        System.out.println(languageList);
        System.out.println(result);
    }

}
