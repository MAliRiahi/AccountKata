package com.kata.sg.handlers;

import com.kata.sg.exception.TransactionException;
import com.kata.sg.model.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RestExceptionHandler  extends ResponseEntityExceptionHandler {

    @ExceptionHandler(TransactionException.class)
    public ResponseEntity<ErrorDto> handlerException(TransactionException exception, WebRequest webRequest){
        final HttpStatus notfound = HttpStatus.NOT_ACCEPTABLE;
        final ErrorDto errorDto = ErrorDto.builder()
                .errorCode(exception.getErrorCode())
                .httpCode(notfound.value())
                .message(exception.getMessage())
                .build();
        return new ResponseEntity<>(errorDto,notfound);
    }
}
