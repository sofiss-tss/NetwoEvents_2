package com.example.netwoevents;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {
    private ImageView picture;
    private ImageView question;
    private EditText email;
    private EditText message;
    private Button btn2;
    private TextView txt;
    private String em;

    private static final String TAG = "MyTAG";

    public boolean isEmailValid (String email){
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        picture = (ImageView) getView().findViewById(R.id.picture);
        picture.setImageResource(R.drawable.p2);
        txt =  (TextView) getView().findViewById(R.id.txtt);
        question = (ImageView) getView().findViewById(R.id.question);

        email = (EditText) getView().findViewById(R.id.email);
        message = (EditText) getView().findViewById(R.id.messages);
        btn2 =  (Button) getView().findViewById(R.id.button2);


        btn2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.i(TAG,"Нажата клавиша продолжить");
                        String ms = null;
                        em = String.valueOf(email.getText());
                        ms = String.valueOf(message.getText());
                        if (!isEmailValid(em)) {
                            Toast.makeText(getActivity(),
                                    "Проверьте адрес электронной почты",
                                    Toast.LENGTH_LONG).show();
                            Log.e(TAG,"Неверный адрес электронной почты");
                        }
                        else if (ms.isEmpty()) {

                            Toast.makeText(getActivity(),
                                    "Введите сообщение", Toast.LENGTH_LONG).show();
                            Log.w(TAG,"Пустое сообщение");
                        }
                        else {
                            Toast.makeText(getActivity(),
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


}
