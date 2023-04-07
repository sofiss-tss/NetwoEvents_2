package com.example.netwoevents.data.storage.user;

import android.content.Context;

public class ImpUserStorage implements UserStorage {

    Context context;
    public ImpUserStorage(Context context) {
        this.context = context;
    }

    @Override
    public Boolean saveData(User user) {
        return true;
    }

    @Override
    public String getPassword() {
        return "77777";
    }

    @Override
    public String getEmail() {
        return "tsv7525@gmail.com";
    }
}
