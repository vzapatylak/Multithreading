package com.epam.dao;

import com.epam.entity.FerryEntity;
import com.epam.entity.VehicleEntity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FerryDaoImpl implements FerryDao {
    FerryEntity ferry = FerryEntity.getInstance();
    private static Lock lock = new ReentrantLock();
    Condition vehicleOnPlatform = lock.newCondition();
    Condition areaOverflowCondition = lock.newCondition();
    Condition payloadOverflowCondition = lock.newCondition();
    private static final Logger LOGGER = LogManager.getLogger(FerryDaoImpl.class);

    @Override
    public void addVehicle(VehicleEntity vehicle) {
        try {
            lock.lock();
            double areaAfterAdding = sizeOfFilledArea() + vehicle.getArea();
            int payloadAfterAdding = sizeOfFilledPayload() + vehicle.getWeight();
            while (ferry.getArea() < areaAfterAdding || ferry.getPayload() < payloadAfterAdding) {
                areaOverflowCondition.await(2, TimeUnit.SECONDS);
                payloadOverflowCondition.await(2, TimeUnit.SECONDS);
            }
            ferry.setArea(areaAfterAdding);
            ferry.setPayload(payloadAfterAdding);
            ferry.getVehicles().add(vehicle);
            LOGGER.info("The " + vehicle.getId() + " vehicle was registered.");
            areaOverflowCondition.signalAll();
            payloadOverflowCondition.signalAll();
        } catch (InterruptedException e) {
            LOGGER.error(e);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void removeVehicle(VehicleEntity vehicle) {
        try {
            lock.lock();
            double areaAfterRemoving = sizeOfFilledArea() - vehicle.getArea();
            int payloadAfterRemoving = sizeOfFilledPayload() - vehicle.getWeight();
            while (!ferry.getVehicles().contains(vehicle)) {
                vehicleOnPlatform.await(2, TimeUnit.SECONDS);
            }
            ferry.setArea(areaAfterRemoving);
            ferry.setPayload(payloadAfterRemoving);
            ferry.getVehicles().remove(vehicle);
            LOGGER.info("The " + vehicle.getId() + " vehicle was deregister.");
            vehicleOnPlatform.signalAll();
        } catch (InterruptedException e) {
            LOGGER.error(e);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public double sizeOfFilledArea() {
        return FerryEntity.getInstance()
                .getVehicles().stream()
                .map(VehicleEntity::getArea)
                .reduce(0.0, Double::sum);
    }

    @Override
    public int sizeOfFilledPayload() {
        return FerryEntity.getInstance()
                .getVehicles().stream()
                .map(VehicleEntity::getWeight)
                .reduce(0, Integer::sum);
    }
}
