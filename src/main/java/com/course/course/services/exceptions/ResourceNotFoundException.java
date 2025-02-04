package com.course.course.services.exceptions;

import java.io.Serial;
import java.io.Serializable;

public class ResourceNotFoundException extends RuntimeException implements Serializable {

    @Serial
    private final static long serialVersionUID = 1L;

    public ResourceNotFoundException(Object id) {
        super("Resource not found for id " + id);
    }
}
