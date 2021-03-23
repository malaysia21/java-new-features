package com.aga.feature.service.java15;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Java15Example {

    private static final Logger logger = LoggerFactory.getLogger(Java15Example.class);

    public static void main(String[] args) {
        //second preview
        recordClass();

       //preview
        Person person1 = new Employee("Kate", 30);
        Person person2 = new Manager();

        sealedClassed(person1);
        sealedClassed(person2);

        //second preview
        patternMatching(person1);
    }

    private static void recordClass() {
        var person = new Student("Kate", 15);
        logger.debug("Record: " +  person);

    }

    private static void sealedClassed(Person person) {
        if (person instanceof Employee) {
            logger.debug("Sealed Classed: Employee");
        }
        else if (person instanceof Manager) {
            logger.debug("Sealed Classed: Manager");
        }
    }

    private static void patternMatching(Person person) {
        if (person instanceof Employee employee && employee.getAge() > 18) {
            logger.debug("Pattern Matching instance of: Employee is over 18");
        }
    }

}
