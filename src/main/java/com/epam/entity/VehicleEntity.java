package com.epam.entity;

import java.util.Objects;

public class VehicleEntity {
    private long id;
    private int weight;
    private double area;
    private TypeOfCar type;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public TypeOfCar getType() {
        return type;
    }

    public void setType(TypeOfCar type) {
        this.type = type;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public VehicleEntity() {
    }

    public VehicleEntity(int weight, double area, TypeOfCar type) {
        this.weight = weight;
        this.area = area;
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VehicleEntity that = (VehicleEntity) o;
        return weight == that.weight &&
                area == that.area &&
                type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(weight, area, type);
    }

    @Override
    public String toString() {
        return "VehicleEntity{" +
                "weight=" + weight +
                ", area=" + area +
                ", type=" + type +
                '}';
    }
}
