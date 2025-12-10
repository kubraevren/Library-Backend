package com.kubraevren.library.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<ErrorObject> handleApplicationException(ApplicationException ex){
        ErrorObject errorObject=new ErrorObject();

        errorObject.setStatusCode(ex.getStatus().value());
        errorObject.setMessage(ex.getMessage());
        return new ResponseEntity<>(errorObject,ex.getStatus());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorObject> handleValidationException(MethodArgumentNotValidException ex){
        ErrorObject errorObject=new ErrorObject();
        errorObject.setStatusCode(HttpStatus.BAD_REQUEST.value());

        String message=ex.getBindingResult().getAllErrors()
                .stream()
                .map(error->error.getDefaultMessage())
                .collect(Collectors.joining(", "));
        errorObject.setMessage(message);
        return new ResponseEntity<>(errorObject,HttpStatus.BAD_REQUEST);
    }




    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorObject> handleGeneralException(Exception ex) {
        ErrorObject errorObject = new ErrorObject();
        errorObject.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorObject.setMessage("Beklenmedik hata: " + ex.getMessage());
        return new ResponseEntity<>(errorObject, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
