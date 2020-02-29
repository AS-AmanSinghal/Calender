package com.aman.calender;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Random;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private Context context;
    private LayoutInflater inflater;
    private List<EventData> eventData;
    private String Date;
    private TextView eventName, participants, time;
    private LinearLayout card;

    public Adapter(Context context, List<EventData> eventData, String Date) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.eventData = eventData;
        this.Date = Date;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new Adapter.ViewHolder(inflater.inflate(R.layout.event_card, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        if (Date.equals(eventData.get(i).getDate())) {
            Random random = new Random();
            int color = Color.argb(255,
                    random.nextInt(256),
                    random.nextInt(256),
                    random.nextInt(256));
            card.setBackgroundColor(color);
            eventName.setText(eventData.get(i).getEventName());
            participants.setText(eventData.get(i).getParticipants());
            time.setText(eventData.get(i).getTime());
            card.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, EventActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra("event_name", eventData.get(i).getEventName());
                    intent.putExtra("participants", eventData.get(i).getParticipants());
                    intent.putExtra("time", eventData.get(i).getTime());
                    context.startActivity(intent);
                }
            });
        } else {
            eventName.setVisibility(View.GONE);
            participants.setVisibility(View.GONE);
            time.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return eventData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            eventName = itemView.findViewById(R.id.event_name);
            participants = itemView.findViewById(R.id.participants);
            time = itemView.findViewById(R.id.participation_time);
            card = itemView.findViewById(R.id.card);
        }
    }
}
