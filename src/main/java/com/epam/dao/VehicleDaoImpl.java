package com.epam.dao;

import com.epam.entity.VehicleEntity;
import com.epam.reader.JSONReaderVehicle;
import com.epam.reader.Reader;
import com.epam.util.Util;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class VehicleDaoImpl implements VehicleDao {
    private Reader<VehicleEntity> reader;
    private Path path;

    public VehicleDaoImpl() throws URISyntaxException {
        reader = new JSONReaderVehicle();
        path = Paths.get(this.getClass().getClassLoader().getResource(Util.NAME_OF_VEHICLE_FILE).toURI());
    }

    @Override
    public List<VehicleEntity> getAll() {
        return reader.parse(path);
    }

}
