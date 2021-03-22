package com.aga.feature.service.java14;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Java14Example {
    public static void main(String[] args) {

        //standard
        switchExpression();

        //preview
        textBlock();

        //preview
        instanceOf();

        //preview
        record();
    }


    private static void textBlock() {
        String multiline = """
                \s \sTesting new textBlock escape characters. \
                Still in preview mode""";

        System.out.println(multiline);
    }

    private static void switchExpression() {
        DayOfWeek dayOfWeek = LocalDate.now().getDayOfWeek();
        Boolean result = switch (dayOfWeek) {
            case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY -> {
                System.out.println("It is WeekDay");
                yield true;
            }
            case SATURDAY, SUNDAY -> {
                System.out.println("It is Weekend");
                yield false;
            }
        };

        System.out.println(result);
    }

    private static void instanceOf() {
        Object obj = "Java12";
        if (obj instanceof String s) {
            int length = s.length();
            System.out.println(length);
        }
    }

    private static void record() {
        Student student = new Student(10, "Kate");
        System.out.println(student.id());
        System.out.println(student.name());
        System.out.println(student);
    }


record Student(int id, String name) { };
}
