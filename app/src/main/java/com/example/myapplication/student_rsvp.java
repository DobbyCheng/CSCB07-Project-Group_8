package com.example.myapplication;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class student_rsvp extends AppCompatActivity {

    private EditText editTextFirstName;
    private EditText editTextLastName;
    private EditText editTextEventName;
    private Button btnRSVP;

    DatabaseReference eventsRef = FirebaseDatabase.getInstance().getReference().child("events");
    Studentwriter studentWriter = new Studentwriter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize EditTexts and Button
        editTextFirstName = findViewById(R.id.editTextFirstName);
        editTextLastName = findViewById(R.id.editTextLastName);
        editTextEventName = findViewById(R.id.editTextEventName);
        btnRSVP = findViewById(R.id.btnRSVP);

        // Set click listener for RSVP button
        btnRSVP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get text from EditText fields
                String firstName = editTextFirstName.getText().toString().trim();
                String lastName = editTextLastName.getText().toString().trim();
                String eventName = editTextEventName.getText().toString().trim();

                // Validate if the fields are not empty
                if (!firstName.isEmpty() && !lastName.isEmpty() && !eventName.isEmpty()) {
                    // Call schedule_enlist method
                    studentWriter.student_enlist(eventName, firstName, lastName);

                    // Optionally, display names in a toast message
                    displayNames(firstName, lastName);
                } else {
                    // Show a toast message for invalid input
                    Toast.makeText(com.example.myapplication.student_rsvp.this, "Please enter both first and last names.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // Function to display first and last names in a toast message
    private void displayNames(String firstName, String lastName) {
        String message = "First Name: " + firstName + "\nLast Name: " + lastName;
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}