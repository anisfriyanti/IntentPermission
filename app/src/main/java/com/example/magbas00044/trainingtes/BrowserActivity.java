package com.example.magbas00044.trainingtes;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BrowserActivity extends AppCompatActivity {

    @BindView(R.id.btnAksesBrowser)
    Button btnAksesBrowser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnAksesBrowser)
    public void onViewClicked() {
        startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse(getString(R.string.imaUrl))));

    }
}
