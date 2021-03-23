package com.aga.feature.service.java15;

public record Student(String name, int age) {
    public Student {
        if(age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
    }
}