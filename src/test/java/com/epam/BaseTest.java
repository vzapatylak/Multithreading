package com.epam;

import com.epam.entity.FerryEntity;
import com.epam.entity.VehicleEntity;
import com.epam.service.VehicleService;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Set;

@RunWith(JUnit4.class)
public class BaseTest {
    protected FerryEntity ferry;
    protected Set<VehicleEntity> vehicles;
    protected VehicleService vehicleService;

    @BeforeClass
    public void init() {
        ferry = FerryEntity.getInstance();
        vehicles = vehicleService.getAll();
    }

    @AfterClass
    public void close() {
        ferry = null;
        vehicles = null;
    }

}
