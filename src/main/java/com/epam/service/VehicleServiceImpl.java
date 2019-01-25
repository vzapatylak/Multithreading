package com.epam.service;

import com.epam.dao.VehicleDao;
import com.epam.entity.VehicleEntity;

import java.util.Set;

public class VehicleServiceImpl implements VehicleService {
    private VehicleDao vehicleDao;

    @Override
    public VehicleEntity getById(Long id) {
        return vehicleDao.getById(id);
    }

    @Override
    public Set<VehicleEntity> getAll() {
        return vehicleDao.getAll();
    }
}
