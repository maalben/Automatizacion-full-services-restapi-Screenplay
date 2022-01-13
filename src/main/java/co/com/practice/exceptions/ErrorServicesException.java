package co.com.practice.exceptions;

public class ErrorServicesException extends RuntimeException {

    public ErrorServicesException(String exceptionMessage){
        super(exceptionMessage);
    }
}
