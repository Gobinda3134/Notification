package com.example.notification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.notification.Createchannel.CreateChannel;

public class MainActivity extends AppCompatActivity {
    private Button btna, btnb;
private NotificationManagerCompat notificationManagerCompat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btna=findViewById(R.id.btna);
        btnb=findViewById(R.id.btnb);
        notificationManagerCompat= NotificationManagerCompat.from(this);
        CreateChannel channel=new CreateChannel(this);
        channel.createChannel();

        btna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DisplayNotification();

            }
        });

        btnb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DisplayNotification1();

            }
        });
    }

    private void DisplayNotification()
    {
    Notification notification= new NotificationCompat.Builder(this, CreateChannel.CHANNEL_1)
            .setSmallIcon(R.drawable.notification)
            .setContentTitle("first Message")
            .setContentText("First message body")
            .setCategory(NotificationCompat.CATEGORY_MESSAGE).build();

    notificationManagerCompat.notify(1, notification);

    }

    private void DisplayNotification1()
    {
        Notification notification= new NotificationCompat.Builder(this, CreateChannel.CHANNEL_2)
                .setSmallIcon(R.drawable.notification1)
                .setContentTitle("Second Message")
                .setContentText("Second message body")
                .setCategory(NotificationCompat.CATEGORY_MESSAGE).build();

        notificationManagerCompat.notify(2, notification);

    }


}
