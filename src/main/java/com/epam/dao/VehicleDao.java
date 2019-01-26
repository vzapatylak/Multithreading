package com.epam.dao;

import com.epam.entity.VehicleEntity;

import java.util.List;

public interface VehicleDao {

    List<VehicleEntity> getAll();
}
