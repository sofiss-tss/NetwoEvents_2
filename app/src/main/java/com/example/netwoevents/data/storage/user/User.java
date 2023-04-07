package com.example.netwoevents.data.storage.user;

public class User {
    private String password;
    private String email;


    public User( String email, String password) {
        this.password = password;
        this.email = email;
    }
}
