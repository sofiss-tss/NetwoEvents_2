package com.example.netwoevents.domain.repository;

import com.example.netwoevents.domain.models.UserData;

public interface UserRepositoryInterface {

    String getUserEmail();
    String getUserPassword();
    Boolean  saveUserData(UserData userData);
}
