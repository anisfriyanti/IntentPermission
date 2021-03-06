package com.example.magbas00044.trainingtes;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.AnalogClock;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AlarmActivity extends AppCompatActivity {

    @BindView(R.id.textView1)
    TextView textView1;
    @BindView(R.id.analogClock1)
    AnalogClock analogClock1;
    @BindView(R.id.startSetDialog)
    Button startSetDialog;
    @BindView(R.id.alarmprompt)
    TextView alarmprompt;
   TimePickerDialog timePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);
        ButterKnife.bind(this);


    }

    @OnClick(R.id.startSetDialog)
    public void onViewClicked() {
        alarmprompt.setText("");
        openTimePickerDialog(true);
    }

    private void openTimePickerDialog(boolean b) {
        Calendar calendar = Calendar.getInstance();

        timePickerDialog=new TimePickerDialog(this, onTimeSetListener,
                calendar.get(Calendar.HOUR_OF_DAY),
                calendar.get(Calendar.MINUTE), true);
        timePickerDialog.setTitle("Set Waktu Alarm");
        timePickerDialog.show();
    }

    TimePickerDialog.OnTimeSetListener onTimeSetListener= new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            Calendar callnow= Calendar.getInstance();
            Calendar callset= (Calendar)callnow.clone();
            callset.set(Calendar.HOUR_OF_DAY,hourOfDay);
            callset.set(Calendar.MINUTE, minute);
            callset.set(Calendar.SECOND, 0);
            callset.set(Calendar.MILLISECOND,0);

            if (callset.compareTo(callnow)<=0){
                callset.add(Calendar.DATE, 1);

            }
            else if(callnow.compareTo(callnow)>0){
                Log.i("hasil", ">0");

            }
            setAlarm(callset);
        }
    };

    private void setAlarm(Calendar callset) {
        alarmprompt.setText("alarm set on" + callset.getTime());
        Intent intent= new Intent(getApplicationContext(), AlarmReceiver.class);
        PendingIntent pendingIntent= PendingIntent
                .getBroadcast(getApplicationContext(), 1,intent, 0);
        AlarmManager alarmManager= (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, callset.getTimeInMillis(), pendingIntent);
    }
}
