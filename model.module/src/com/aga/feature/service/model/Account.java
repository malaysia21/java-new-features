package com.aga.feature.service.model;

public class Account {

    private final String name;

    public Account(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Account{name=" + name + "}";
    }
}
