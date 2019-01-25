package com.epam.entity;

import java.util.Objects;
import java.util.Set;

public class FerryEntity {
    private int payload;
    private double areaOfPlatform;
    private Set<VehicleEntity> vehicles;

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

    public FerryEntity() {
    }

    public FerryEntity(int payload, double areaOfPlatform) {
        this.payload = payload;
        this.areaOfPlatform = areaOfPlatform;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FerryEntity ferryEntity = (FerryEntity) o;
        return payload == ferryEntity.payload &&
                areaOfPlatform == ferryEntity.areaOfPlatform;
    }

    @Override
    public int hashCode() {
        return Objects.hash(payload, areaOfPlatform);
    }

    public static FerryEntity getInstance() {
        return null;
    }

    @Override
    public String toString() {
        return "FerryEntity{" +
                "payload=" + payload +
                ", areaOfPlatform=" + areaOfPlatform +
                '}';
    }

    public Set<VehicleEntity> getVehicles() {
        return vehicles;
    }

    public void setVehicles(Set<VehicleEntity> vehicles) {
        this.vehicles = vehicles;
    }
}
