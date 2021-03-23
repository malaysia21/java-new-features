package com.aga.feature.service.java14;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Java14Example {

    private static final Logger logger = LoggerFactory.getLogger(Java14Example.class);

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

        logger.debug("Text block: " + multiline);
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

        logger.debug("Switch expression: " + (result));
    }

    private static void instanceOf() {
        Object obj = "Java12";
        if (obj instanceof String s) {
            int length = s.length();
            logger.debug("Pattern matching for instance of: " + length);
        }
    }

    private static void record() {
        Student student = new Student(10, "Kate");
        logger.debug("Record studentId: " + student.id());
        logger.debug("Record studentName: " + student.name());
        logger.debug("Record student: " + student);
    }


    record Student(int id, String name) {
    }
}
