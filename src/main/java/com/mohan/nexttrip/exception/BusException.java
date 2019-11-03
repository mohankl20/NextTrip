package com.mohan.nexttrip.exception;

public class BusException extends RuntimeException
{

    public BusException(String messageKey, Throwable cause)
    {
        super(messageKey, cause);
    }

    public BusException(String message)
    {
        super(message);
    }

}
