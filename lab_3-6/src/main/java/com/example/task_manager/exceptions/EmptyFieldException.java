package com.example.task_manager.exceptions;

public class EmptyFieldException extends RuntimeException{
    public  EmptyFieldException(String message){
         super(message);
    }
}
