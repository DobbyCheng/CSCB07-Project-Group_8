package com.example.b07project.adminop;

import java.util.List;

public class Event {


    private String description;
    private String eventName;
    private String date;
    private String time;

    private  List<String> stringList;

    private int EventID ;

    public Event() {
        // Default constructor required for Firebase
    }

    public Event( String date, String time,
                  String eventName,String description, int EventID) {
        this.date = date;
        this.time = time;
        this.eventName = eventName;
        this.description = description;
        this.EventID= EventID;
        this.stringList = null;
    }

    // Getters


    public String getDescription() {
        return description;
    }

    public String getEventName() {
        return eventName;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    // Setters

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getEventID() {
        return EventID;
    }

    public void setEventID(int EventID) {
        this.EventID = EventID;
    }
}
