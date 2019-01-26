package com.epam.service;

import com.epam.dao.VehicleDao;
import com.epam.dao.VehicleDaoImpl;
import com.epam.entity.VehicleEntity;

import java.net.URISyntaxException;
import java.util.List;

public class VehicleServiceImpl implements VehicleService {
    private VehicleDao vehicleDao;

    public VehicleServiceImpl() throws URISyntaxException {
        vehicleDao = new VehicleDaoImpl();
    }

    @Override
    public List<VehicleEntity> getAll() {
        return vehicleDao.getAll();
    }
}
