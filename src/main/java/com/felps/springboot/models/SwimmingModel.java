package com.felps.springboot.models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "TB_SWIMMING")
public class SwimmingModel {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idSwimmingTest;
    private String name;
    private String description;

    @Enumerated(EnumType.STRING)
    private Nivel nivel;

    public UUID getIdSwimmingTest() {
        return idSwimmingTest;
    }

    public void setIdSwimmingTest(UUID idSwimmingTest) {
        this.idSwimmingTest = idSwimmingTest;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Nivel getNivel() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }
}
