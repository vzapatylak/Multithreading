package com.epam.exception;

public class JSONParseException extends Exception {

    public JSONParseException(String message) {
        super("JSON parse exception: " + message);
    }
}
