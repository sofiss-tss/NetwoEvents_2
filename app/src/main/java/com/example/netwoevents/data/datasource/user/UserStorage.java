package com.example.netwoevents.data.datasource.user;


public interface UserStorage {

    public Boolean saveData(User user);
    public String showPassword();
    public String showEmail();

}
