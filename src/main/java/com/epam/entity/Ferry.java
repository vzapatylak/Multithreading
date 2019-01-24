package com.epam.entity;

import java.util.Objects;

public class Ferry {
    private int payload;
    private double areaOfPlatform;

    public int getPayload() {
        return payload;
    }

    public void setPayload(int payload) {
        this.payload = payload;
    }

    public double getAreaOfPlatform() {
        return areaOfPlatform;
    }

    public void setAreaOfPlatform(double areaOfPlatform) {
        this.areaOfPlatform = areaOfPlatform;
    }

    public Ferry() {
    }

    public Ferry(int payload, double areaOfPlatform) {
        this.payload = payload;
        this.areaOfPlatform = areaOfPlatform;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ferry ferry = (Ferry) o;
        return payload == ferry.payload &&
                areaOfPlatform == ferry.areaOfPlatform;
    }

    @Override
    public int hashCode() {
        return Objects.hash(payload, areaOfPlatform);
    }

    @Override
    public String toString() {
        return "Ferry{" +
                "payload=" + payload +
                ", areaOfPlatform=" + areaOfPlatform +
                '}';
    }
}
