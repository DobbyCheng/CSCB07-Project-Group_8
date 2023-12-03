package com.example.myapplication;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
//testing
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class view_event_backend extends AppCompatActivity {

    private EditText editTextEventName;
    private Button btnViewEvent;
    private TextView textViewSummary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.getting_event_feedback);

        editTextEventName = findViewById(R.id.editTextEventName);
        btnViewEvent = findViewById(R.id.btnViewEvent);
        textViewSummary = findViewById(R.id.textViewSummary);

        btnViewEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String eventName = editTextEventName.getText().toString().trim();

                if (!eventName.isEmpty()) {
                    // Call the method to retrieve event summary
                    viewEventSummary(eventName);
                } else {
                    Toast.makeText(view_event_backend.this, "Please enter an event name", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void viewEventSummary(String eventName) {
        DatabaseReference eventsRef = FirebaseDatabase.getInstance().getReference().child("events_list");

        // Query to find the event by name
        Query eventQuery = eventsRef.orderByChild("name").equalTo(eventName);
        eventQuery.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    // Event found, retrieve its summary
                    for (DataSnapshot eventSnapshot : dataSnapshot.getChildren()) {
                        DataSnapshot summarySnapshot = eventSnapshot.child("summary");

                        String studentFeedback = summarySnapshot.child("student feedback").getValue(String.class);
                        long count = summarySnapshot.child("count").getValue(Long.class);
                        double average = summarySnapshot.child("average").getValue(Double.class);

                        // Display the summary in the TextView
                        String summaryText = "Student Feedback: " + studentFeedback
                                + "\nCount: " + count
                                + "\nAverage: " + average;
                        textViewSummary.setText(summaryText);
                    }
                } else {
                    // Event not found
                    Toast.makeText(view_event_backend.this, "Event not found", Toast.LENGTH_SHORT).show();
                    textViewSummary.setText("");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle error
                Toast.makeText(view_event_backend.this, "Database error: " + databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
