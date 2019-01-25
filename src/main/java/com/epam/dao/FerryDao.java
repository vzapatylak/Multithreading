package com.epam.dao;

import com.epam.entity.FerryEntity;
import com.epam.entity.State;
import com.epam.entity.VehicleEntity;

import java.util.Set;

public interface FerryDao {

    State getState(FerryEntity ferry);

    Set<VehicleEntity> getVehicles(FerryEntity ferry);
}
