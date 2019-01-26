package com.epam.service;

import com.epam.entity.FerryEntity;
import com.epam.entity.VehicleEntity;

import java.util.Set;

public class FerryServiceImpl implements FerryService {

    private FerryService ferryService;

    @Override
    public Set<VehicleEntity> getVehicles(FerryEntity ferry) {
        return ferryService.getVehicles(ferry);
    }

    @Override
    public void addVehicle(VehicleEntity vehicle) {
        ferryService.addVehicle(vehicle);
    }

    @Override
    public double sizeOfFilledArea() {
        return ferryService.sizeOfFilledArea();
    }

    @Override
    public int sizeOfFilledPayload() {
        return ferryService.sizeOfFilledPayload();
    }
}
