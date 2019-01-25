package com.epam.service;

import com.epam.entity.VehicleEntity;

import java.util.Set;

public interface FerryService {

    Set<VehicleEntity> getVehicles(Long id);

    void addVehicle(VehicleEntity vehicle);
}
