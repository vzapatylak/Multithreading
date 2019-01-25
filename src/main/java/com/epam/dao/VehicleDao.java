package com.epam.dao;

import com.epam.entity.VehicleEntity;

import java.util.Set;

public interface VehicleDao {

    Set<VehicleEntity> getAll();

    VehicleEntity getById(Long id);
}
