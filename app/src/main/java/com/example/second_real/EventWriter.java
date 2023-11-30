package com.example.second_real;
import android.util.Log;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ServerValue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventWriter {
    public void scheduleEvent(String eventName, String description, int participantLimit,
                              String date, String time, List<String> stringList) {
        // Generate a new key for the event
        DatabaseReference eventsRef = FirebaseDatabase.getInstance().getReference().child("events");
        DatabaseReference newEventRef = eventsRef.push();
        String eventId = newEventRef.getKey();

        // Create a map to store event details
        Map<String, Object> eventDetails = new HashMap<>();
        eventDetails.put("Students Attending", stringList);
        eventDetails.put("name", eventName);
        eventDetails.put("description", description);
        eventDetails.put("participantLimit", participantLimit);
        eventDetails.put("date", date);
        eventDetails.put("time", time);
        // Write the event details to the new event node
        newEventRef.setValue(eventDetails);
        // Log the event ID (optional)
        //Log.d("EVENTID", eventId);
    }
}