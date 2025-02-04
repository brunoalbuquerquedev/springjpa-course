package com.course.course.services.exceptions;

import java.io.Serial;
import java.io.Serializable;

public class DbException extends RuntimeException implements Serializable {

    @Serial
    private final static long serialVersionUID = 1L;

    public DbException() {
        super();
    }
}
