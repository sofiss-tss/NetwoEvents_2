package com.example.netwoevents.data.repository;

import android.content.Context;


import com.example.netwoevents.domain.models.UserData;
import com.example.netwoevents.domain.repository.UserRepositoryInterface;

public class UserRepository implements UserRepositoryInterface {

    private Context context;



    public UserRepository(Context context) {
        this.context = context;
    }

    @Override
    public String getUserEmail() {
        return null;
    }

    @Override
    public String getUserPassword() {
        return null;
    }



    @Override
    public Boolean saveUserData(UserData userData) {
        if (userData.getEmail().isEmpty() || userData.getPassword().isEmpty()){
            return false;
        } else {
            return true;
        }
    }
}
