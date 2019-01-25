package com.epam.dao;

import com.epam.BaseTest;
import com.epam.entity.VehicleEntity;

import static org.junit.Assert.assertEquals;

public class VehicleDaoTest extends BaseTest {

    public void testGetAll() {
        assertEquals(vehicleService.getAll().size(), 6);
    }

    public void testGetById() {
        VehicleEntity vehicle = vehicleService.getById(1L);
        assertEquals(vehicle.getId(), 1L);
    }

}
