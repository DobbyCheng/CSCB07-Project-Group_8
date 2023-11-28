package com.example.second_real;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private EditText editTextName, editTextParticipantLimit, editTextDate, editTextTime, editTextDescription;
    private Button scheduleEventButton;
    FirebaseDatabase reference;
    private DatabaseReference myRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseReference event = FirebaseDatabase.getInstance().getReference().child("events");

        editTextName = findViewById(R.id.editTextExample);
        editTextParticipantLimit = findViewById(R.id.editTextExample2);
        editTextDate = findViewById(R.id.editTextExample3);
        editTextTime = findViewById(R.id.editTextExample4);
        editTextDescription = findViewById(R.id.editTextExample5);

        // Initialize the Button
        scheduleEventButton = findViewById(R.id.scheduleEventButton);

        // Set click listener for the button
        scheduleEventButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle button click, validate input, and store data
                if (validateInput()) {
                    // Input is valid, proceed to store data in respective data types
                    String name = editTextName.getText().toString();
                    int participantLimit = Integer.parseInt(editTextParticipantLimit.getText().toString());
                    String date = editTextDate.getText().toString();
                    String time = editTextTime.getText().toString();
                    String description = editTextDescription.getText().toString();

                    event.child("date").setValue(date);
                    event.child("name").setValue(name);
                    event.child("Time").setValue(date);
                    event.child("Description").setValue(name);
                    event.child("Participation Limit").setValue(date);

                } else {
                    Toast.makeText(MainActivity.this, "Invalid input. Please try again.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private boolean validateInput() {
        return !editTextName.getText().toString().trim().isEmpty() &&
                !editTextParticipantLimit.getText().toString().trim().isEmpty() &&
                !editTextDate.getText().toString().trim().isEmpty() &&
                !editTextTime.getText().toString().trim().isEmpty() &&
                !editTextDescription.getText().toString().trim().isEmpty();
    }
    private void displayUserData(String name, int participantLimit, String date, String time, String description) {
        String userData = "Name: " + name +
                "\nParticipant Limit: " + participantLimit +
                "\nDate: " + date +
                "\nTime: " + time +
                "\nDescription: " + description;

        Toast.makeText(this, userData, Toast.LENGTH_LONG).show();
    }
}