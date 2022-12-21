package com.example.day8.exception;

public class APIException extends RuntimeException{

    public APIException(String msg)
    {
        super(msg);
    }
}