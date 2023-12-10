package com.filter.exceptions;

import com.filter.model.Error;
import lombok.Getter;

@Getter
public class BadRequestException extends RuntimeException{
    private final Error error;
    public BadRequestException(Error error, Throwable throwable){
        super(throwable);
        this.error = error;
    }
}
