package com.example.netwoevents.domain.usecase;

public class CheckEmailValidUseCase {

    public static boolean isEmailValid (String email){
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}
