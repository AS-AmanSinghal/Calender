package com.aman.calender;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class EventActivity extends AppCompatActivity {

    TextView eventName, time, participants;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        eventName = findViewById(R.id.event_name);
        participants = findViewById(R.id.participants);
        time = findViewById(R.id.participation_time);
        if (getSupportActionBar() != null) {

            getSupportActionBar().setTitle("Event");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        eventName.setText(getIntent().getStringExtra("event_name"));
        participants.setText(getIntent().getStringExtra("participants"));
        time.setText(getIntent().getStringExtra("time"));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;

    }
}
