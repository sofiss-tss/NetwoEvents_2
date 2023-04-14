package com.example.netwoevents.data.datasource.storagedatasourse;


import com.example.netwoevents.data.datasource.models.User;

public interface UserStorage {

    public Boolean saveData(User user);
    public String showPassword();
    public String showEmail();

}
