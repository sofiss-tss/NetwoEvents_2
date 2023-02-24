package com.example.netwoevents;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private ImageView picture;
    private ImageView question;
    private EditText email;
    private EditText message;
    private Button btn1;
    private Button btn2;
    private TextView txt;
    private String em;

    private static final String TAG = "MyTAG";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        picture = (ImageView)findViewById(R.id.picture);
        picture.setImageResource(R.drawable.p2);
        txt =  (TextView)findViewById(R.id.txtt);
        question = (ImageView)findViewById(R.id.question);

        email = (EditText)findViewById(R.id.email);
        message = (EditText)findViewById(R.id.messages);
        btn2 =  (Button)findViewById(R.id.button2);


        btn2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.i(TAG,"Нажата клавиша продолжить");
                        String ms = null;
                        em = String.valueOf(email.getText());
                        ms = String.valueOf(message.getText());
                        if (!isEmailValid(em)) {
                            Toast.makeText(MainActivity.this,
                                    "Проверьте адрес электронной почты",
                                    Toast.LENGTH_LONG).show();
                            Log.e(TAG,"Неверный адрес электронной почты");
                        }
                        else if (ms.isEmpty()) {

                            Toast.makeText(MainActivity.this,
                                    "Введите сообщение", Toast.LENGTH_LONG).show();
                            Log.w(TAG,"Пустое сообщение");
                        }
                        else {
                            Toast.makeText(MainActivity.this,
                                    "Сообщение получено! Ожидайте ответа на почте",
                                    Toast.LENGTH_LONG).show();
                            txt.setText("Cообщение отправлено");
                            Log.i(TAG,"Сообщение отправлено");
                            question.setImageResource(R.drawable.check);
                            email.setEnabled(false);
                            message.setEnabled(false);
                        }
                    }
                }
        );
    }

    public void startLogin(View v)
    {
        Log.i(TAG,"Нажата клавиша Войти");
        btn1 =  (Button)findViewById(R.id.button1);
        Intent intent = new Intent(this,Login.class);
        intent.putExtra("email", em);
        startActivity(intent);
    }


    public boolean isEmailValid(String email){
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}


//import android.content.Intent;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.View;
//import android.widget.Toast;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.example.netwoevents.databinding.ActivityMainBinding;
//
//public class MainActivity extends AppCompatActivity {
//    private static final String TAG = "MyTAG";
//    private ActivityMainBinding binding;
//    public boolean isEmailValid(String email) {
//        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
//    }
//
//    public void startLogin(View v) {
//        Intent intent = new Intent(this,Login.class);
//        startActivity(intent);
//        Log.i(TAG,"Нажата клавиша Войти");
//    }
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        binding.picture.setImageResource(R.drawable.p2);
//
//        super.onCreate(savedInstanceState);
//        binding = ActivityMainBinding.inflate(getLayoutInflater());
//        View viewRoot = binding.getRoot();
//        setContentView(viewRoot);
//
//        binding.button2.setOnClickListener(
//                new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        Log.i(TAG,"Нажата клавиша продолжить");
//                        String ms = null;
//                        String em = String.valueOf((binding.email).getText());
//                        System.out.println(em);
//                        ms = String.valueOf((binding.messages).getText());
//                        if (!isEmailValid(em)) {
//                            Toast.makeText(MainActivity.this,
//                                    "Проверьте адрес электронной почты", Toast.LENGTH_LONG).show();
//                            Log.e(TAG,"Неверный адрес электронной почты");
//                        } else if (ms.isEmpty()) {
//
//                            Toast.makeText(MainActivity.this,
//                                    "Введите сообщение", Toast.LENGTH_LONG).show();
//                            Log.w(TAG,"Пустое сообщение");
//                        } else {
//                            Toast.makeText(MainActivity.this,
//                                    "Сообщение получено! Ожидайте ответа на почте", Toast.LENGTH_LONG).show();
//                            binding.txtt.setText("Cообщение отправлено");
//                            binding.question.setImageResource(R.drawable.check);
//                            binding.email.setEnabled(false);
//                            binding.messages.setEnabled(false);
//                            Log.i(TAG,"Сообщение отправлено");
//                        }
//
//                    }
//                }
//        );
//    }
//
//
//
//}

