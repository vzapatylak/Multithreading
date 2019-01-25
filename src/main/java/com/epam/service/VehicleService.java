package com.epam.service;

import com.epam.entity.VehicleEntity;

import java.util.Set;

public interface VehicleService {

    VehicleEntity getById(Long id);

    Set<VehicleEntity> getAll();
}
