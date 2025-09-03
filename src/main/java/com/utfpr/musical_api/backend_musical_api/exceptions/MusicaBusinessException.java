package com.utfpr.musical_api.backend_musical_api.exceptions;

public class MusicaBusinessException extends Exception {
    public enum Reason { TITLE_ALREADY_EXISTS }

    private final Reason reason;

    public MusicaBusinessException(String message, Reason reason) {
        super(message);
        this.reason = reason;
    }

    public Reason getReason() {
        return reason;
    }
}
