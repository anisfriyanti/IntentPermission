package com.example.magbas00044.trainingtes;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.AudioManager;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NotificationActivity extends AppCompatActivity {

    @BindView(R.id.btnnotification)
    Button btnnotification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnnotification)
    public void onViewClicked() {
        NotificationCompat.Builder mBuilder=
                new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.notif)
                .setContentTitle("Manis App")
                .setContentText("ini pesan notifikasi")
                .setAutoCancel(true);

        long[] getar= {1000, 1000, 1000};
        Uri sound= RingtoneManager.getDefaultUri(AudioManager.STREAM_NOTIFICATION);

        Intent resultIntent= new Intent(this, NotificationActivity.class);
        PendingIntent pending= PendingIntent.getActivity(this, 0, resultIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        mBuilder.setContentIntent(pending);
        mBuilder.setSound(sound);
        mBuilder.setVibrate(getar);

        NotificationManager mNotificationM= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        mNotificationM.notify(10, mBuilder.build());
    }
}
