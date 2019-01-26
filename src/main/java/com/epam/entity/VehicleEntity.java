package com.epam.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.Serializable;
import java.util.Objects;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class VehicleEntity extends BaseEntity implements Serializable, Runnable {
    private int weight;
    private double area;
    private TypeOfCar type;
    private CyclicBarrier barrier;
    private static final Logger LOGGER = LogManager.getLogger(FerryEntity.class);

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

    public CyclicBarrier getBarrier() {
        return barrier;
    }

    public void setBarrier(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    public VehicleEntity() {
    }

    public VehicleEntity(int weight, double area, TypeOfCar type) {
        this.weight = weight;
        this.area = area;
        this.type = type;
    }

    public VehicleEntity(long id, int weight, double area, TypeOfCar type) {
        this.setId(id);
        this.weight = weight;
        this.area = area;
        this.type = type;
    }

    @Override
    public void run() {
        try {
            LOGGER.info("The " + getId() + " vehicle entered the platform completely.");
            barrier.await(2, TimeUnit.SECONDS);
            LOGGER.info("The " + getId() + " vehicle left the platform.");
        } catch (InterruptedException | BrokenBarrierException | TimeoutException e) {
            LOGGER.error(e);
        }
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
