package com.dharamveer.mytogglebutton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class NotificationActivity extends AppCompatActivity {

    String CHANNEL_ID = "111";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

    }

    public void sendNotification(View view) {
        NotificationChannel mChannel = null;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            mChannel = new NotificationChannel(CHANNEL_ID, "notificationChannel", NotificationManager.IMPORTANCE_HIGH);
            NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            nm.createNotificationChannel(mChannel);

            NotificationCompat.Builder noti = new NotificationCompat.Builder(this, CHANNEL_ID);
            noti.setContentTitle("Local Notification");
            noti.setContentText("Hi, Welcome to Tilak");
            noti.setSmallIcon(R.drawable.ic_notifications_black_24dp);
            nm.notify(0, noti.build());

            noti.setPriority(0);
        }
    }
}