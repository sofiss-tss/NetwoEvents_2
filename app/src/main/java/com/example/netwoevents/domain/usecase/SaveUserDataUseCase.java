package com.example.netwoevents.domain.usecase;

import com.example.netwoevents.domain.models.UserData;
import com.example.netwoevents.domain.repository.UserRepositoryInterface;

public class SaveUserDataUseCase {
    UserRepositoryInterface ur;

    public SaveUserDataUseCase(UserRepositoryInterface ur) {
        this.ur = ur;
    }

    public Boolean execute(UserData userData) {
        if (!ur.getUserEmail().isEmpty() && !ur.getUserPassword().isEmpty()) {
            return ur.saveUserData(userData);
        }
        return false;
    }
}
