package com.example.escola.Controller.handler;

import com.example.escola.exception.BadRequestException;
import com.example.escola.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErroGenericoResponse> badRequestExceptionHandler(BadRequestException e) {
        ErroGenericoResponse erroResponse = new ErroGenericoResponse(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(), e.getMessage(), "Cadastro não finalizado");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erroResponse);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErroGenericoResponse> notFoundExceptionHandler(NotFoundException e) {
        ErroGenericoResponse erroResponse = new ErroGenericoResponse(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value(), e.getMessage(), "Sua busca não teve sucesso");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erroResponse);
    }
}

