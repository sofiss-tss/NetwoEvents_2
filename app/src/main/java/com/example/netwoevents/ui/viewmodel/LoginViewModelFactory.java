package com.example.netwoevents.ui.viewmodel;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.netwoevents.data.datasource.user.ExternalStorage;
import com.example.netwoevents.data.datasource.user.SharedPreferencesStorage;
import com.example.netwoevents.data.repository.UserRepository;
import com.example.netwoevents.data.datasource.user.AppSpecificStorage;
import com.example.netwoevents.data.datasource.user.UserStorage;
import com.example.netwoevents.domain.usecase.SaveUserDataUseCase;


public class LoginViewModelFactory implements ViewModelProvider.Factory {

    private Context context;
    private UserRepository userRepository;
    private SaveUserDataUseCase saveUserDataUseCase;

    public LoginViewModelFactory(Context context) {
        this.context = context;

        //UserStorage userStorage= new AppSpecificStorage(context);
        //UserStorage userStorage = new ExternalStorage(context);
        UserStorage  userStorage = new SharedPreferencesStorage(context);
        userRepository = new UserRepository(userStorage);
        saveUserDataUseCase = new SaveUserDataUseCase(userRepository); }
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new LoginViewModel(saveUserDataUseCase) ;
    }


}
