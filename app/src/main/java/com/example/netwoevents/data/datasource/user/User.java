package com.example.netwoevents.data.datasource.user;

public class User {
    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    private String password;
    private String email;


    public User(String email, String password) {
        this.password = password;
        this.email = email;
    }
}
