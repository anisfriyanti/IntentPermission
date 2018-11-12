package com.example.magbas00044.trainingtes;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WifiActivity extends AppCompatActivity {
    WifiManager mWifi;
    @BindView(R.id.sw_wifi)
    Switch swWifi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi);
        ButterKnife.bind(this);

        mWifi = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);


        if (mWifi.isWifiEnabled()) {
            swWifi.setChecked(true);
        } else {
            swWifi.setChecked(false);
        }
        //action
        swWifi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {
                if (b == true) {
                    wifi(true);

                } else {
                    wifi(false);
                }
            }
        });

    }

    private void wifi(boolean b) {
        if (b == true && !mWifi.isWifiEnabled()) {
            mWifi.setWifiEnabled(true);
            Toast.makeText(this, "Wifi diaktifkan", Toast.LENGTH_SHORT).show();
        } else if (b == false && mWifi.isWifiEnabled()) {
            mWifi.setWifiEnabled(false);
            Toast.makeText(this, "tidak diaktifkan", Toast.LENGTH_SHORT).show();
        }

    }


}
