package com.example.magbas00044.trainingtes;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TTSActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {

    @BindView(R.id.textspeech)
    EditText textspeech;
    @BindView(R.id.btnTTStext)
    Button btnTTStext;

    TextToSpeech tts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tts);
        ButterKnife.bind(this);
        tts =new TextToSpeech(this, this);
    }

    @OnClick({ R.id.btnTTStext})
    public void onViewClicked() {
   String text= textspeech.getText().toString();
   tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }


    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {
            Locale indo = Locale.getDefault();
            int hasil = tts.setLanguage(indo);
            if (hasil == TextToSpeech.LANG_MISSING_DATA || hasil == TextToSpeech.LANG_NOT_SUPPORTED) {
                Toast.makeText(this, "Tidak Mendukung", Toast.LENGTH_SHORT).show();
            } else {
                onViewClicked();
                btnTTStext.setEnabled(true);
            }
        } else {
            Toast.makeText(this, "TTS Tidak Support di Hape Ini", Toast.LENGTH_SHORT).show();
        }
    }
    }


