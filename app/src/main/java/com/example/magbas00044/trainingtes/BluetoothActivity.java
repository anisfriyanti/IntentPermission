package com.example.magbas00044.trainingtes;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Set;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BluetoothActivity extends AppCompatActivity {
    BluetoothAdapter mBluetoothAdapter;

    @BindView(R.id.btnDisable)
    Button btnDisable;
    @BindView(R.id.btnEnable)
    Button btnEnable;
    @BindView(R.id.btnPaired)
    Button btnPaired;
    @BindView(R.id.btnDiscover)
    Button btnDiscover;
    @BindView(R.id.lv)
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth);
        ButterKnife.bind(this);
        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    }

    @OnClick({R.id.btnDisable, R.id.btnEnable, R.id.btnPaired, R.id.btnDiscover})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnDisable:
                tidakAktif();
                break;
            case R.id.btnEnable:
                aktif();
                break;
            case R.id.btnPaired:
                paired();
                break;
            case R.id.btnDiscover:
                discover();
                break;
        }
    }

    private void discover() {
        Intent discoverBluetooth = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
        discoverBluetooth.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, 100);
        startActivity(discoverBluetooth);
    }

    private void paired() {
        // TODO Set informasi bluetooth
        Set<BluetoothDevice> paired = mBluetoothAdapter.getBondedDevices();
        // TODO Check paired device ada atau tidak
        if (paired.size() > 0) {
            ArrayList mArrayAdapeter = new ArrayList();
            for (BluetoothDevice device : paired) {
                mArrayAdapeter.add(device.getName() + "\n" + device.getAddress());
            }
            // TODO To include array to adapter
            ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, mArrayAdapeter);
            lv.setAdapter(adapter);
        }
    }

    private void aktif() {
        // TODO Aktifkan bluetooth cek aktif atau tidak
        if (!mBluetoothAdapter.isEnabled()) {
            Intent enableBluettoth = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBluettoth, 1);
        } else {
            Toast.makeText(this, "Bluetooth Sudah Aktif", Toast.LENGTH_SHORT).show();
        }
    }

    private void tidakAktif() {
        if (mBluetoothAdapter.isEnabled()) {
            mBluetoothAdapter.disable();
        }
        else{
            Toast.makeText(this, "Sudah Tidak Aktif", Toast.LENGTH_SHORT).show();
        }
    }


}












