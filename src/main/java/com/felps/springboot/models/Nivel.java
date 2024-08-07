package com.felps.springboot.models;

public enum Nivel {

    INICIANTE("INICIANTE"),
    INTERMEDIARIO("INTERMEDIARIO"),
    AVANCADO("AVANCADO");

    private final String name;

    Nivel(String name) {
        this.name = this.name();
    }
}
