package com.example.magbas00044.trainingtes;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SmsActivity extends AppCompatActivity {

    private static final int REQUEST = 1;


    @BindView(R.id.edtMessagesms)
    EditText edtMessagesms;
    @BindView(R.id.btnsmsintent)
    Button btnsmsintent;
    @BindView(R.id.btnsendsms)
    Button btnsendsms;
    @BindView(R.id.phonenumber)
    EditText phonenumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.edtMessagesms, R.id.btnsmsintent, R.id.btnsendsms, R.id.phonenumber})
    public void onViewClicked(View view) {
String no = phonenumber.getText().toString();
String msg= edtMessagesms.getText().toString();


        switch (view.getId()) {
            case R.id.phonenumber:
                Intent i = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
                i.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE);
                startActivityForResult(i, 1);
                break;
            case R.id.edtMessagesms:

                break;
            case R.id.btnsmsintent:
                if(TextUtils.isEmpty(no)){
                    phonenumber.setError("Tidak boleh kosong");
                }else if(TextUtils.isEmpty(msg)){
                    edtMessagesms.setError("Tidak boleh kosong");

                }else{
                    Intent sms= new Intent(Intent.ACTION_VIEW);
                    sms.putExtra("address", no);
                    sms.putExtra("sms_body", msg);
                    sms.setType("vnd.android-dir/mms-sms");

                    startActivity(sms);
                }
                break;
            case R.id.btnsendsms:
                //TODO 7 eksekusi langsung kirim
                if (ContextCompat.checkSelfPermission(this,
                        Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {

                    if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                            Manifest.permission.SEND_SMS)) {

                    } else {
                        ActivityCompat.requestPermissions(this,
                                new String[]{Manifest.permission.SEND_SMS},
                                REQUEST);
                    }
                } else {
                    try {
                        SmsManager smsManager = SmsManager.getDefault();
                        smsManager.sendTextMessage(no, null, msg,
                                null, null);
                        Toast.makeText(this, "Berhasil Dikirim", Toast.LENGTH_SHORT).show();
                    }
                    // TODO error handling
                    catch (Exception e) {
                        e.printStackTrace();
                        Toast.makeText(this, "Gagal Dikirim", Toast.LENGTH_SHORT).show();
                    }
                }

                break;
        }
    }

    //TODO Tangkep response
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            Cursor cursor;
            try {
                Uri uri = data.getData();
                cursor = getContentResolver().query(uri, new String[]{
                                ContactsContract.CommonDataKinds.Phone.NUMBER},
                        null, null, null);

                if (cursor != null && cursor.moveToNext()) {
                    String phone = cursor.getString(0);
                    phonenumber.setText(phone);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
