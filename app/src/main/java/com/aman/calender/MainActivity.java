package com.aman.calender;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText eventName,particiapants,time;
    private CalendarView calendar;
    private Button button;
    private RecyclerView recyclerView;
    private String Date;
    private List<EventData> eventDataList = new ArrayList<>();
    private Adapter adapter;
    private SimpleDateFormat dateFormat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eventName=findViewById(R.id.event_name);
        particiapants=findViewById(R.id.participants);
        time=findViewById(R.id.participation_time);
        button=findViewById(R.id.add_btn);
        calendar=findViewById(R.id.calender);
        dateFormat = new SimpleDateFormat("YYYY-M-d");
        Date = dateFormat.format(calendar.getDate());
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                Date = year + "-" + (month + 1) + "-" + dayOfMonth;
                adapter = new Adapter(getApplicationContext(), eventDataList, Date);
                adapter.notifyDataSetChanged();
                recyclerView.setAdapter(adapter);

            }
        });
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext(), RecyclerView.VERTICAL, false));
        recyclerView.setAdapter(adapter);


        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (String.valueOf(eventName.getText()).trim().isEmpty() || String.valueOf(particiapants.getText()).trim().isEmpty() ||
                        String.valueOf(time.getText()).trim().isEmpty()) {
                    button.setEnabled(false);
                } else {
                    button.setEnabled(true);
                }
            }
        };
        eventName.addTextChangedListener(textWatcher);
        particiapants.addTextChangedListener(textWatcher);
        time.addTextChangedListener(textWatcher);
        button.setEnabled(false);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println(Date);
                EventData eventData = new EventData(Date, String.valueOf(eventName.getText()).trim(),
                        String.valueOf(particiapants.getText()).trim(), String.valueOf(time.getText()).trim());
                eventDataList.add(eventData);
                adapter = new Adapter(getApplicationContext(), eventDataList, Date);
                adapter.notifyDataSetChanged();
                recyclerView.setAdapter(adapter);
                eventName.setText("");
                particiapants.setText("");
                time.setText("");
            }
        });
    }


}
