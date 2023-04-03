package com.example.netwoevents.ui.presentation;

import android.app.Fragment;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.example.netwoevents.R;

public class MainActivity extends AppCompatActivity {

    private Button btn1;

   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


       btn1 = findViewById(R.id.button1);

       NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager()
               .findFragmentById(R.id.fragmentContainerView);
       NavController navController = navHostFragment.getNavController();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                navController.navigate(R.id.action_homeFragment_to_loginFragment);

            }
        });
    }

}



