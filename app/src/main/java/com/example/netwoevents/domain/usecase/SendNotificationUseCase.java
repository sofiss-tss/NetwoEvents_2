package com.example.netwoevents.domain.usecase;

import android.Manifest;
import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.os.Build;

import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;

import com.example.netwoevents.R;
import com.example.netwoevents.domain.models.Message;
import com.example.netwoevents.ui.presentation.MainActivity;

public class SendNotificationUseCase {


    private final String CHANNEL_ID="channel_id";
    private static final int NOTIFICATION_ID = 1;



    public void execute (Context context, Message msg){
        // Есть ли разрешения на отправку уведомления
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.
                POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
            // Если разрешение не получено, запрашиваем его у пользователя
            ActivityCompat.requestPermissions((Activity)context,new String[]{
                    Manifest.permission.POST_NOTIFICATIONS}, 1);
        }

        //Реакция на уведомления
        Intent notificationIntent = new Intent(context, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context,
                0, notificationIntent,
                PendingIntent.FLAG_CANCEL_CURRENT);

        // Создаем канал уведомлений (для Android 8.0 (API 26) и выше.)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            String name = "name_channel";
            String description = "description_channel";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            NotificationManager notificationManager = context.
                    getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }

        // Создаем уведомление
        String text = "Ваше сообщение получено!\nОжидайте ответа на почте " + msg.getEmail();
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context,
                CHANNEL_ID)
                .setSmallIcon(R.drawable.check)
                .setContentTitle("Уведомление от NetwoEvents")
                .setContentIntent(pendingIntent)
                .setContentText("Ваше сообщение получено!")
                .setStyle(new NotificationCompat.BigTextStyle().bigText(text))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.drawable.ne1))
                .setAutoCancel(true); // автоматически закрыть уведомление после нажатия

        // Отправляем уведомление
        NotificationManagerCompat notificationManager = NotificationManagerCompat
                .from(context);
        notificationManager.notify(NOTIFICATION_ID, builder.build());
    }
}
