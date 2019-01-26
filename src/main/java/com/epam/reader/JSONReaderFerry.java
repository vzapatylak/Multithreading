package com.epam.reader;

import com.epam.entity.FerryEntity;
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

public class JSONReaderFerry implements Reader<FerryEntity> {
    private static final Logger LOGGER = LogManager.getLogger(JSONReaderFerry.class);
    private final Validator validator;

    public JSONReaderFerry() {
        validator = new JSONValidator();
    }

    @Override
    public List<FerryEntity> parse(Path filePath) {
        List<FerryEntity> ferries = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(filePath, Charset.forName("UTF-8"));
            String data = lines.stream().map(Object::toString)
                    .collect(Collectors.joining(" "));

            if (validator.isValid(data)) {
                JsonElement jelement = new JsonParser().parse(data);
                JsonObject jobject = jelement.getAsJsonObject();
                JsonArray jarray = jobject.getAsJsonArray("ferries");
                for (JsonElement jsonObject : jarray) {
                    jobject = jsonObject.getAsJsonObject();
                    ferries.add(parseToEntity(jobject));
                }
            }
        } catch (JSONParseException e) {
            LOGGER.error("Invalid json " + e);
        } catch (IOException e) {
            LOGGER.error("Error in read " + e);
        }
        return ferries;
    }

    private FerryEntity parseToEntity(JsonObject jobject) {
        long id = jobject.get("id").getAsLong();
        int payload = jobject.get("payload").getAsInt();
        double area = jobject.get("area").getAsDouble();
        return new FerryEntity(id, payload, area);
    }
}
