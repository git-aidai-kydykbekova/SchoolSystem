package com.example.Software_P.dto;

public class ParentDTO {
    private String name;
    private String surname;

    public String getName() {
        return name;
    }

    public ParentDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public ParentDTO setSurname(String surname) {
        this.surname = surname;
        return this;
    }
}
