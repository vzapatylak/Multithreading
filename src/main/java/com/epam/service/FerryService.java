package com.epam.service;

import com.epam.entity.FerryEntity;
import com.epam.entity.VehicleEntity;

import java.util.Set;

public interface FerryService {

    Set<VehicleEntity> getVehicles(FerryEntity ferry);

    void addVehicle(VehicleEntity vehicle);

    double sizeOfFilledArea();

    int sizeOfFilledPayload();
}
