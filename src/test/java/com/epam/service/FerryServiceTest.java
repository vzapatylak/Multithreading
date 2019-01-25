package com.epam.service;

import com.epam.BaseTest;
import com.epam.entity.TypeOfCar;
import com.epam.entity.VehicleEntity;

import static org.junit.Assert.assertEquals;

public class FerryServiceTest extends BaseTest {

    private FerryService ferryService;

    public void testPayloadOverflow() {
        int payload = ferry.getPayload();
        ferry.setPayload(payload + 660);
        ferryService.addVehicle(new VehicleEntity(300, 100, TypeOfCar.CAR));
        ferryService.addVehicle(new VehicleEntity(300, 100, TypeOfCar.CAR));
        ferryService.addVehicle(new VehicleEntity(300, 100, TypeOfCar.CAR));

        ferry.setVehicles(vehicles);
        assertEquals(ferry.getVehicles().size(), 2);
    }

    public void testAreaOverflow() {
        double area = ferry.getAreaOfPlatform();
        ferry.setAreaOfPlatform(area + 220);
        ferryService.addVehicle(new VehicleEntity(300, 100, TypeOfCar.CAR));
        ferryService.addVehicle(new VehicleEntity(300, 100, TypeOfCar.CAR));
        ferryService.addVehicle(new VehicleEntity(300, 100, TypeOfCar.CAR));

        ferry.setVehicles(vehicles);
        assertEquals(ferry.getVehicles().size(), 2);
    }
}
