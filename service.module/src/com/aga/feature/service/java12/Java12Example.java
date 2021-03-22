package com.aga.feature.service.java12;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.NumberFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java12Example {

    public static void main(String[] args) throws IOException {

        stringIntendMethod();

        stringTransformMethod();

        fileMismatchMethod();

        collectorsTeeingMethod();

        compactNumberFormatting();

        //preview
        switchExpression();

        //preview
        instanceOf();
    }

    private static void stringIntendMethod() {
        String value = "Testing".indent(6);
        String value2 = "                   Testing".indent(-10);
        String value3 = "Testing".indent(-10);

        System.out.println(value);
        System.out.println(value2);
        System.out.println(value3);
    }

    private static void stringTransformMethod() {
        String value = "Java 12";
        String transformedValue = value.transform(s ->
                new StringBuilder(s).reverse().toString()
        );

        System.out.println(transformedValue);
    }

    private static void fileMismatchMethod() throws IOException {
        Path path1 = Paths.get("C:\\projects\\java-new-features\\service.module\\test_12_1.txt");
        Path path2 = Paths.get("C:\\projects\\java-new-features\\service.module\\test_12_2.txt");

        long diff = Files.mismatch(path1, path2);

        System.out.println(diff);
    }

    private static void collectorsTeeingMethod() {
        double result = Stream.of(1, 2, 3, 4, 5)
                .collect(Collectors.teeing(
                        Collectors.summingDouble(i -> i),
                        Collectors.counting(),
                        (sum, count) -> sum / count));

        System.out.println(result);
    }

    private static void compactNumberFormatting() {
        NumberFormat formatterCompactNumber = NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.SHORT);
        NumberFormat formatterCurrency = NumberFormat.getCurrencyInstance(Locale.US);

        System.out.println(formatterCompactNumber.format(25000L));
        System.out.println(formatterCurrency.format(25000L));
    }

    private static void switchExpression() {
        DayOfWeek dayOfWeek = LocalDate.now().getDayOfWeek();
        String typeOfDay = switch (dayOfWeek) {
            case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY -> "Working Day";
            case SATURDAY, SUNDAY -> "Day Off";
        };

        System.out.println(typeOfDay);
    }

    private static void instanceOf() {
        Object obj = "Java12";
        if (obj instanceof String s) {
            int length = s.length();
            System.out.println(length);
        }
    }


}
