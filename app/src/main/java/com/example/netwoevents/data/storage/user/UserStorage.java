package com.example.netwoevents.data.storage.user;

import com.example.netwoevents.data.storage.user.User;

public interface UserStorage {

    public Boolean saveData(User user);
    public String getPassword();
    public String getEmail();

}
