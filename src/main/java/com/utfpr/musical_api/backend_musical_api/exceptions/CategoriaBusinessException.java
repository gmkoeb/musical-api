package com.utfpr.musical_api.backend_musical_api.exceptions;

public class CategoriaBusinessException extends RuntimeException{
    public enum Reason { NAME_ALREADY_EXISTS }

    private final Reason reason;

    public CategoriaBusinessException(String message, Reason reason){
        super(message);
        this.reason = reason;
    }

    public Reason getReason() {
        return reason;
    }
}
