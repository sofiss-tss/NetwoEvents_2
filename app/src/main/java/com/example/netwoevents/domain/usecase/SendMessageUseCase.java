package com.example.netwoevents.domain.usecase;


import android.content.Context;
import android.widget.Toast;
import com.example.netwoevents.domain.models.Message;


public class SendMessageUseCase {

    public Boolean execute(Message msg, Context context)
    {
        if (!CheckEmailValidUseCase.isEmailValid(msg.getEmail())) {
            Toast.makeText(context,
                    "Проверьте адрес электронной почты",
                    Toast.LENGTH_SHORT).show();
        } else if (msg.getMessage().isEmpty()) {
            Toast.makeText(context,
                    "Введите сообщение", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context,
                    "Сообщение получено! Ожидайте ответа на почте",
                    Toast.LENGTH_LONG).show();
            return true;

        }
        return false;
    }
}
