package com.mshindelar.collection.exception;

public class InvalidCollectionItemException extends Exception {
    public InvalidCollectionItemException(String message) { super(message); }
    public InvalidCollectionItemException(String message, Throwable cause) { super(message, cause); }
}
