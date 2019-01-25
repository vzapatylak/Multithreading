package com.epam.dao;

import com.epam.BaseTest;
import com.epam.entity.State;

import static org.junit.Assert.assertEquals;

public class FerryDaoTest extends BaseTest {
    private FerryDao ferryDao;

    public void testGetState() {
        assertEquals(ferryDao.getState(ferry), State.ARRIVED);
    }

    public void testGetVehiclesByFerry() {
        assertEquals(ferryDao.getVehicles(ferry).size(), 6);
    }
}
