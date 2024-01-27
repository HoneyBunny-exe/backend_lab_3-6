package com.example.task_manager.exceptions;

public class DoesntExistsException extends RuntimeException {
    public DoesntExistsException(String message){
        super(message);
    }
}
