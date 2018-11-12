package com.example.magbas00044.trainingtes;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.widget.Toast;

public class AlarmReceiver extends BroadcastReceiver {

    MediaPlayer mediaPlayer;
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "alarm berbunyi", Toast.LENGTH_SHORT).show();
        mediaPlayer=MediaPlayer.create(context, R.raw.alarm);
        mediaPlayer.start();
    }
}
