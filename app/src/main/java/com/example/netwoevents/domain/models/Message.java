package com.example.netwoevents.domain.models;

public class Message {
    public String getEmail() {
        return email;
    }
    public String getMessage() {
        return message;
    }

    private String email;
    private String message;

    public Message(String email, String message) {
        this.email = email;
        this.message = message;
    }
}
