package com.example.task_manager.exceptions;


public class AlreadyExistsException extends RuntimeException{
	public AlreadyExistsException(String message){
		super(message);
	}
}