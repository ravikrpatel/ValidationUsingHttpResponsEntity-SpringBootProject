package com.validation.GlobalExceptionHandler;


import com.validation.Controller.AllExceptioinHandling.BookNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class ExceptionHandlerAdvices {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NoSuchElementException.class)
    public Map<String,String > Nosuchelementexception(NoSuchElementException ex){
        Map<String, String> error= new HashMap<>();
        error.put("errmessage",ex.getMessage());
        return error;
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String> Invalidinput(MethodArgumentNotValidException ex){
        Map<String, String> invalidinputerror= new HashMap<>();
         invalidinputerror.put(String.valueOf(ex.getFieldError()),ex.getMessage());
         return invalidinputerror;


    }


    @ExceptionHandler(BookNotFound.class)
    public Map<String, String> exceptionBookNotFound(BookNotFound ex){
        Map<String, String> errorexception= new HashMap<>();
         errorexception.put("errormessage", ex.getMessage());
        return errorexception;

    }
}
