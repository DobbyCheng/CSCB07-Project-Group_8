package com.example.myapplication;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class Studentwriter {

    public void student_enlist(final String eventName, final String firstName, final String lastName) {
        final DatabaseReference eventsRef = FirebaseDatabase.getInstance().getReference().child("events");

        // Query to find the event by name
        Query eventQuery = eventsRef.orderByChild("name").equalTo(eventName);
        eventQuery.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                boolean eventFound = false;

                for (DataSnapshot eventSnapshot : dataSnapshot.getChildren()) {
                    String eventId = eventSnapshot.getKey();
                    DatabaseReference studentsAttendingRef = eventsRef.child(eventId).child("Students Attending");

                    // Create a map to store student details
                    Map<String, Object> studentDetails = new HashMap<>();
                    studentDetails.put("Last Name", lastName);
                    studentDetails.put("First Name", firstName);

                    // Write the student details under "Students Attending" for the found event
                    studentsAttendingRef.push().setValue(studentDetails);

                    eventFound = true;
                }

                if (!eventFound) {
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Handle error
            }
        });
    }
}

