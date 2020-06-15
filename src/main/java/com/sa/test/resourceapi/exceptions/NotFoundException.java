package com.sa.test.resourceapi.exceptions;

import com.sa.test.resourceapi.entities.Project;

public class NotFoundException extends Exception {
    public NotFoundException(Class exceptionClass, long id) {
        super(exceptionClass.getName() + " with id " + id + " not found");
    }
}
