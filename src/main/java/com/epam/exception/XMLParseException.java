package com.epam.exception;

public class XMLParseException extends Exception {

    public XMLParseException(String message) {
        super("XML parse exception: " + message);
    }
}
