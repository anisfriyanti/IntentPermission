package com.example.magbas00044.trainingtes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btnBtooth)
    Button btnBtooth;
    @BindView(R.id.btnCamera)
    Button btnCamera;
    @BindView(R.id.btnWifi)
    Button btnWifi;
    @BindView(R.id.btnAudiom)
    Button btnAudiom;
    @BindView(R.id.btnNotif)
    Button btnNotif;
    @BindView(R.id.btnTts)
    Button btnTts;
    @BindView(R.id.btn_alarm)
    Button btnAlarm;
    @BindView(R.id.btn_browser)
    Button btnBrowser;
    @BindView(R.id.btn_email)
    Button btnEmail;
    @BindView(R.id.btn_sms)
    Button btnSms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


    }

    @OnClick({R.id.btnBtooth, R.id.btnCamera, R.id.btnWifi, R.id.btnAudiom, R.id.btnNotif, R.id.btnTts, R.id.btn_alarm,
            R.id.btn_browser, R.id.btn_email, R.id.btn_sms})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnBtooth:
                startActivity(new Intent(MainActivity.this, BluetoothActivity.class));
                break;
            case R.id.btnCamera:
                startActivity(new Intent(MainActivity.this, CameraActivity.class));
                break;
            case R.id.btnWifi:
                startActivity(new Intent(MainActivity.this, WifiActivity.class));
                break;
            case R.id.btnAudiom:
                startActivity(new Intent(MainActivity.this, AudioActivity.class));
                break;
            case R.id.btnNotif:
                startActivity(new Intent(MainActivity.this, NotificationActivity.class));
                break;
            case R.id.btnTts:
                startActivity(new Intent(MainActivity.this, TTSActivity.class));
                break;
            case R.id.btn_alarm:
                startActivity(new Intent(MainActivity.this, AlarmActivity.class));
                break;
            case R.id.btn_browser:
                startActivity(new Intent(MainActivity.this, BrowserActivity.class));
                break;
            case R.id.btn_sms:
                startActivity(new Intent(MainActivity.this, SmsActivity.class));
                break;
            case R.id.btn_email:
                startActivity(new Intent(MainActivity.this, EmailActivity.class));
                break;
        }
    }



}
