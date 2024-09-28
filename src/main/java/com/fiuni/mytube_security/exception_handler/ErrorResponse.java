package com.fiuni.mytube_security.exception_handler;

import lombok.*;

import java.util.Date;

@Getter
@Setter
public class ErrorResponse {
    private String message;
    private String details;
    private Date timestamp;

    public ErrorResponse(String message, String details) {
        this.message = message;
        this.details = details;
        this.timestamp = new Date();
    }

    //To String JSON
    @Override
    public String toString() {
        return "{" +
                "\"message\":\"" + message + '\"' +
                ", \"details\":\"" + details + '\"' +
                ", \"timestamp\":\"" + timestamp + '\"' +
                '}';
    }
}
