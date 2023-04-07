package com.example.netwoevents.data.repository;


import com.example.netwoevents.data.storage.user.User;
import com.example.netwoevents.data.storage.user.UserStorage;
import com.example.netwoevents.domain.models.UserData;
import com.example.netwoevents.domain.repository.UserRepositoryInterface;

public class UserRepository implements UserRepositoryInterface {

   private UserStorage userStorage;

    public UserRepository(UserStorage userStorage) {
        this.userStorage = userStorage;
    }

    @Override
    public String getUserEmail() {
        return userStorage.getEmail();
    }

    @Override
    public String getUserPassword() {
       return userStorage.getPassword();
    }



    @Override
    public Boolean saveUserData(UserData userData) {

        User user  = new User(userData.getEmail(),userData.getPassword());
        return userStorage.saveData(user);

    }
}
