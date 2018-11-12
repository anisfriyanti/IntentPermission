package com.example.magbas00044.trainingtes;

import android.Manifest;
import android.content.Context;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AudioActivity extends AppCompatActivity {

    @BindView(R.id.btn_ring)
    Button btnRing;
    @BindView(R.id.btn_silent)
    Button btnSilent;
    @BindView(R.id.btn_vibrate)
    Button btnVibrate;

    AudioManager audio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio);
        ButterKnife.bind(this);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(new String[]{Manifest.permission.MODIFY_AUDIO_SETTINGS}, 1);
        }
        audio =(AudioManager) getApplicationContext().getSystemService(Context.AUDIO_SERVICE);
    }

    @OnClick({R.id.btn_ring, R.id.btn_silent, R.id.btn_vibrate})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_ring:
                audio.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
                Toast.makeText(this, "Mode Ring", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_silent:
                audio.setRingerMode(AudioManager.RINGER_MODE_SILENT);
                Toast.makeText(this, "Mode Silent", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_vibrate:
                audio.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
                Toast.makeText(this, "Mode Vibrate", Toast.LENGTH_SHORT).show();

                break;
        }
    }

}
