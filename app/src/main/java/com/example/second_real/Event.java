package com.example.second_real;

public class Event {

    private int participantLimit;
    private String description;
    private String eventName;
    private String date;
    private String time;

    private int UserId;

    public Event() {
        // Default constructor required for Firebase
    }

    public Event(int participantLimit, String date, String time, String eventName, String description) {
        this.participantLimit = participantLimit;
        this.date = date;
        this.time = time;
        this.eventName = eventName;
        this.description = description;
    }

    // Getters
    public int getParticipantLimit() {
        return participantLimit;
    }

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
    public void setParticipantLimit(int participantLimit) {
        this.participantLimit = participantLimit;
    }

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

    public int getUserID() {
        return UserId;
    }

    public void setUserId(int UserId) {
        this.UserId = UserId;
    }
}
