// EventWriter.java
package com.example.second_real;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class EventWriter {
    public void scheduleEvent(String eventName, String description, int participantLimit,
                              String date, String time) {
        // Generate a new key for the event
        DatabaseReference eventsRef = FirebaseDatabase.getInstance().getReference().child("events");
        DatabaseReference newEventRef = eventsRef.push();
        String eventId = newEventRef.getKey();

        // Create a map to store event details
        Map<String, Object> eventDetails = new HashMap<>();
        eventDetails.put("name", eventName);
        eventDetails.put("description", description);
        eventDetails.put("participantLimit", participantLimit);
        eventDetails.put("date", date);
        eventDetails.put("time", time);

        // Write the event details to the new event node
        newEventRef.setValue(eventDetails);

        // Create a map for the event summary
        Map<String, Object> eventSummary = new HashMap<>();
        eventSummary.put("student feedback", "");
        eventSummary.put("count", 0);
        eventSummary.put("average", 0.0);

        // Write the event summary to the "summary" child of the new event node
        newEventRef.child("summary").setValue(eventSummary);
    }
}