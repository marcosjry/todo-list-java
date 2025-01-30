package com.marcos.domain.exception;

public class TaskNameAlreadyExistException extends Exception {
    public TaskNameAlreadyExistException(String message) {
        super(message);
    }
}
