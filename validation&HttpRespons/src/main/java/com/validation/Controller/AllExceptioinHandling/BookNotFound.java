package com.validation.Controller.AllExceptioinHandling;

public class BookNotFound extends Exception {
    public BookNotFound(String message) {
        super(message);
    }
}
