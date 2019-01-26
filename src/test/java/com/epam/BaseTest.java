package com.epam;

import com.epam.entity.FerryEntity;
import com.epam.entity.VehicleEntity;
import com.epam.service.VehicleService;
import com.epam.service.VehicleServiceImpl;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.net.URISyntaxException;
import java.util.List;

@RunWith(JUnit4.class)
public class BaseTest {
    protected static FerryEntity ferry;
    protected static List<VehicleEntity> vehicles;
    protected static VehicleService vehicleService;

    @BeforeClass
    public static void init() throws URISyntaxException {
        vehicleService = new VehicleServiceImpl();
        ferry = FerryEntity.getInstance();
        vehicles = vehicleService.getAll();
    }

    @AfterClass
    public static void close() {
        ferry = null;
        vehicles = null;
    }

}
