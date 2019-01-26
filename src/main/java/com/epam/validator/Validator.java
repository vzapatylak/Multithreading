package com.epam.validator;

import com.epam.exception.JSONParseException;

public interface Validator {

    boolean isValid(String data) throws JSONParseException;
}
