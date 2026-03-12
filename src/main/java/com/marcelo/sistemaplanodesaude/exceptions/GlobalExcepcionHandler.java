package com.marcelo.sistemaplanodesaude.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExcepcionHandler {

    @ExceptionHandler(BeneficiarioJaExisteException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ApiError handleBeneficiarioJaExiste(BeneficiarioJaExisteException e){
        return new ApiError(409, e.getMessage(), LocalDateTime.now());
    }
}
