package org.jtools.cli;

public class InvalidCliParametersException extends Exception{
    public InvalidCliParametersException(String message) {
        super(message);
    }

    public InvalidCliParametersException(String message, Throwable cause) {
        super(message, cause);
    }
}
