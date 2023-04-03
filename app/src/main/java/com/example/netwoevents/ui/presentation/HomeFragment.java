package com.example.netwoevents.ui.presentation;


import android.content.Intent;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.netwoevents.R;
import com.example.netwoevents.domain.models.Message;
import com.example.netwoevents.domain.usecase.SendMessageUseCase;
import com.example.netwoevents.domain.usecase.SendNotificationUseCase;

public class HomeFragment extends Fragment {
    private ImageView picture;
    private ImageView question;
    private EditText email;
    private EditText message;
    private Button btn2;
    private ImageButton btnMsg;
    private TextView txt;

    private String value;
    private static final String TAG = "MyTAG";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        btnMsg = (ImageButton) getView().findViewById(R.id.button_msg);

        btnMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), EventService.class);
                getActivity().startService(intent);
            }
        });

        if (getArguments() != null) {
            value = getArguments().getString("bundleKey");
            email.setText(value);
        }

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                SendMessageUseCase sendMessageUseCase = new SendMessageUseCase();
                SendNotificationUseCase sendNotificationUseCase = new SendNotificationUseCase();
                String em = String.valueOf(email.getText());
                String ms = String.valueOf(message.getText());

                Message msg = new Message(em, ms);
                if (sendMessageUseCase.execute(msg,getContext())) {

                    sendNotificationUseCase.execute(getContext(),msg);
                    txt.setText("Cообщение отправлено");
                    question.setImageResource(R.drawable.check);
                    email.setEnabled(false);
                    message.setEnabled(false);
                }

            }
        });

    }

}
