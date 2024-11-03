package com.mshindelar.collection.exception;


public class NoSuchCollectionException extends Exception {
    public NoSuchCollectionException(String message) { super(message); }
    public NoSuchCollectionException(String message, Throwable cause) { super(message, cause); }
}
