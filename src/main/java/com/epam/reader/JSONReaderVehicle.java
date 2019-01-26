package com.epam.reader;

import com.epam.entity.TypeOfCar;
import com.epam.entity.VehicleEntity;
import com.epam.exception.JSONParseException;
import com.epam.validator.JSONValidator;
import com.epam.validator.Validator;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JSONReaderVehicle implements Reader<VehicleEntity> {
    private static final Logger LOGGER = LogManager.getLogger(JSONReaderVehicle.class);
    private final Validator validator;

    public JSONReaderVehicle() {
        validator = new JSONValidator();
    }

    @Override
    public List<VehicleEntity> parse(Path filePath) {
        List<VehicleEntity> vehicles = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(filePath, Charset.forName("UTF-8"));
            String data = lines.stream().map(Object::toString)
                    .collect(Collectors.joining(" "));
            if (validator.isValid(data)) {
                JsonElement jelement = new JsonParser().parse(data);
                JsonObject jobject = jelement.getAsJsonObject();
                JsonArray jarray = jobject.getAsJsonArray("vehicles");
                for (JsonElement jsonObject : jarray) {
                    jobject = jsonObject.getAsJsonObject();
                    vehicles.add(parseToEntity(jobject));
                }
            }
        } catch (JSONParseException e) {
            LOGGER.error("Invalid json " + e);
        } catch (IOException e) {
            LOGGER.error("Error in read " + e);
        }
        return vehicles;
    }

    private VehicleEntity parseToEntity(JsonObject jobject) {
        long id = jobject.get("id").getAsLong();
        int weight = jobject.get("weight").getAsInt();
        double area = jobject.get("area").getAsDouble();
        TypeOfCar type = TypeOfCar.valueOf(jobject.get("type").getAsString());
        return new VehicleEntity(id, weight, area, type);
    }
}
