package com.mshindelar.collection.exception;

public class NoSuchCardException extends Exception {
    public NoSuchCardException(String message) { super(message); }
    public NoSuchCardException(String message, Throwable cause) { super(message, cause); }
}
