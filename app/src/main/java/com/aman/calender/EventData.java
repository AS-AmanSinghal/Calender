package com.aman.calender;

public class EventData {
    private String date;
    private String eventName;
    private String participants;
    private String time;

    public EventData(String date, String eventName, String participants, String time) {
        this.date = date;
        this.eventName = eventName;
        this.participants = participants;
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getParticipants() {
        return participants;
    }

    public void setParticipants(String participants) {
        this.participants = participants;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
