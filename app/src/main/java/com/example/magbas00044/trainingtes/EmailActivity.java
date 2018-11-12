package com.example.magbas00044.trainingtes;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EmailActivity extends AppCompatActivity {

    @BindView(R.id.edtTo)
    EditText edtTo;
    @BindView(R.id.edtSubject)
    EditText edtSubject;
    @BindView(R.id.edtMessage)
    EditText edtMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);
        ButterKnife.bind(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        String to =edtTo.getText().toString();
        String subject = edtSubject.getText().toString();
        String message = edtMessage.getText().toString();

        if(id==R.id.send) {
            if (TextUtils.isEmpty(to)) {
                edtTo.setError("Tidak boleh kosong");
            } else if (TextUtils.isEmpty(subject)) {
                edtSubject.setError("Kosong");

            } else if (TextUtils.isEmpty(message)) {
                edtMessage.setError("kOSONG");

            } else {
//                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
//                        "mailto",to, null));
//                emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
//                emailIntent.putExtra(Intent.EXTRA_TEXT, message);
//                startActivity(Intent.createChooser(emailIntent, "Send email..."));
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:")); // only email apps should handle this
                intent.putExtra(Intent.EXTRA_SUBJECT, subject);
                intent.putExtra(Intent.EXTRA_TEXT, message);
                startActivity(Intent.createChooser(intent, "Send email..."));

                //pake semua send via
//                Intent intent = new Intent(Intent.ACTION_SEND);
//                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{to});
//                intent.putExtra(Intent.EXTRA_SUBJECT, message);
//                intent.putExtra(Intent.EXTRA_TEXT,message);
//
//                intent.setType("message/rfc822");
//                startActivity(Intent.createChooser(intent, "Silah"));
            }
        }else{
        edtTo.setText("");
        edtMessage.setText("");
        edtSubject.setText("");
        }

        return super.onOptionsItemSelected(item);
    }

}
