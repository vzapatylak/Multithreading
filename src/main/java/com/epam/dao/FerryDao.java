package com.epam.dao;

import com.epam.entity.VehicleEntity;

public interface FerryDao {

    void addVehicle(VehicleEntity vehicle);

    void removeVehicle(VehicleEntity vehicle);

    double sizeOfFilledArea();

    int sizeOfFilledPayload();
}
