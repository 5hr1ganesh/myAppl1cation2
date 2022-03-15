package com.dharamveer.mytogglebutton;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

import androidx.appcompat.app.AppCompatActivity;

public class Timepicker extends AppCompatActivity {

    TextView textview1;
    TimePicker timepicker;
    Button changetime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timepicker);

        textview1 = (TextView) findViewById(R.id.textView1);
        timepicker = (TimePicker) findViewById(R.id.timePicker);
        changetime = (Button) findViewById(R.id.btnChangeTime);


        timepicker.setIs24HourView(true);

        changetime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textview1.setText(getCurrentTime());
            }
        });

    }
    public String getCurrentTime(){
        String currentTime="Current Time: "+timepicker.getCurrentHour()+":"+timepicker.getCurrentMinute();
        return currentTime;
      }

    }





