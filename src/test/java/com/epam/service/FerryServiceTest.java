package com.epam.service;

import com.epam.BaseTest;
import com.epam.entity.TypeOfCar;
import com.epam.entity.VehicleEntity;

import java.util.HashSet;

import static org.junit.Assert.assertEquals;

public class FerryServiceTest extends BaseTest {

    public void testPayloadOverflow() {
        ferry.setPayload(660);
        HashSet<VehicleEntity> vehicles = new HashSet<>();
        vehicles.add(new VehicleEntity(300, 100, TypeOfCar.CAR));
        vehicles.add(new VehicleEntity(300, 100, TypeOfCar.CAR));
        vehicles.add(new VehicleEntity(300, 100, TypeOfCar.CAR));

        ferry.setVehicles(vehicles);
        assertEquals(ferry.getVehicles().size(), 2);
    }

    public void testAreaOverflow() {
        ferry.setAreaOfPlatform(220);
        HashSet<VehicleEntity> vehicles = new HashSet<>();
        vehicles.add(new VehicleEntity(300, 100, TypeOfCar.CAR));
        vehicles.add(new VehicleEntity(300, 100, TypeOfCar.CAR));
        vehicles.add(new VehicleEntity(300, 100, TypeOfCar.CAR));

        ferry.setVehicles(vehicles);
        assertEquals(ferry.getVehicles().size(), 2);
    }
}
