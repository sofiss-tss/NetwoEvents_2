package com.example.netwoevents.domain.usecase;



import com.example.netwoevents.domain.models.Message;


public class SendMessageUseCase {
    private String email;
    private String message;

    public void execute(Message msg) {
        email = msg.getEmail();
        message = msg.getMessage();
    }
}
