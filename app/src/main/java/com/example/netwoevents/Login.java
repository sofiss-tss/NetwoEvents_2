package com.example.netwoevents;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Bundle arguments = getIntent().getExtras();
        String name = arguments.get("email").toString();
    }

    public void goBack(View v){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}