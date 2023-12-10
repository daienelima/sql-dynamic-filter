package com.filter.controller;

import com.filter.exceptions.BadRequestException;
import com.filter.model.Error;
import io.micronaut.context.annotation.Requires;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.server.exceptions.ExceptionHandler;
import jakarta.inject.Singleton;

@Produces
@Singleton
@Requires(classes = {BadRequestException.class, ExceptionHandler.class})
public class ControllerExceptionHandler implements ExceptionHandler<BadRequestException, HttpResponse<Error>> {

    @Override
    public HttpResponse<Error> handle(HttpRequest request, BadRequestException exception) {
        return HttpResponse.serverError(exception.getError())
                .status(HttpStatus.BAD_REQUEST);
    }
}
