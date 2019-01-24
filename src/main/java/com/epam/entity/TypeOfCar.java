package com.epam.entity;

public enum TypeOfCar {
    CAR("car"),
    TRUCK("truck");

    private final String value;

    TypeOfCar(String value) {
        this.value = value;
    }
}
