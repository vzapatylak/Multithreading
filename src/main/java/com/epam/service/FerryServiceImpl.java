package com.epam.service;

import com.epam.entity.VehicleEntity;

import java.util.Set;

public class FerryServiceImpl implements FerryService {

    private FerryService ferryService;

    private boolean isFull() {
        return false;
    }

    public void addAutomobile(VehicleEntity vehicleEntity) {
    }

    public void removeAutomobile(VehicleEntity vehicleEntity) {
    }

    private boolean isAreaAllowToAdd(VehicleEntity vehicleEntity) {
        return false;
    }

    private boolean isPayloadAllowToAdd(VehicleEntity vehicleEntity) {
        return false;
    }

    @Override
    public Set<VehicleEntity> getVehicles(Long id) {
        return ferryService.getVehicles(id);
    }

    @Override
    public void addVehicle(VehicleEntity vehicle) {

    }
}
