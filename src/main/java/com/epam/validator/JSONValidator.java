package com.epam.validator;

import com.google.gson.Gson;

public class JSONValidator implements Validator {
    private final Gson gson = new Gson();

    @Override
    public boolean isValid(String data) {
        try {
            gson.fromJson(data, Object.class);
            return true;
        } catch (com.google.gson.JsonSyntaxException ex) {
            return false;
        }
    }
}
