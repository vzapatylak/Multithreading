package com.epam.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FerryEntity extends BaseEntity implements Serializable {
    private long id;
    private int payload;
    private double area;
    private List<VehicleEntity> vehicles;
    private static FerryEntity INSTANCE = null;
    private static Lock lock = new ReentrantLock();
    private static final Logger LOGGER = LogManager.getLogger(FerryEntity.class);

    public int getPayload() {
        return payload;
    }

    public void setPayload(int payload) {
        this.payload = payload;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public List<VehicleEntity> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<VehicleEntity> vehicles) {
        this.vehicles = vehicles;
    }

    public FerryEntity() {
    }

    public FerryEntity(long id, int payload, double area) {
        this.id = id;
        this.payload = payload;
        this.area = area;
    }

    public static FerryEntity getInstance() {
        try {
            if (lock.tryLock(1, TimeUnit.SECONDS)) {
                if (INSTANCE == null) {
                    INSTANCE = new FerryEntity();
                }
            }
        } catch (InterruptedException e) {
            LOGGER.error(e);
        } finally {
            lock.unlock();
        }
        return INSTANCE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FerryEntity ferryEntity = (FerryEntity) o;
        return payload == ferryEntity.payload &&
                area == ferryEntity.area;
    }

    @Override
    public int hashCode() {
        return Objects.hash(payload, area);
    }

    @Override
    public String toString() {
        return "FerryEntity{" +
                "payload=" + payload +
                ", area=" + area +
                '}';
    }
}
