package com.mshindelar.collection.exception;

public class NoSuchAccountException extends Exception {
    public NoSuchAccountException(String message) { super(message); }
    public NoSuchAccountException(String message, Throwable cause) { super(message, cause); }
}
