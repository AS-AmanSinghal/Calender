package com.aman.calender;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText eventName,particiapants,time;
    private CalendarView calendar;
    private Button button;
    private String Date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eventName=findViewById(R.id.event_name);
        particiapants=findViewById(R.id.participants);
        time=findViewById(R.id.participation_time);
        button=findViewById(R.id.add_btn);
        calendar=findViewById(R.id.calender);
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                Date= Integer.toString(year)+Integer.toString(month+1)+Integer.toString(dayOfMonth);
                Log.d("Date", "onSelectedDayChange: "+Date);
            }
        });
    }
}
