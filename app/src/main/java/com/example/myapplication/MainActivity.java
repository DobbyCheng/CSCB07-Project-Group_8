package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    private EditText editTextFirstName;
    private EditText editTextLastName;
    private Button btnRSVP;

    DatabaseReference student_rsvp = FirebaseDatabase.getInstance().getReference().child("events");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize EditTexts and Button
        editTextFirstName = findViewById(R.id.editTextFirstName);
        editTextLastName = findViewById(R.id.editTextLastName);
        btnRSVP = findViewById(R.id.btnRSVP);

        // Set click listener for RSVP button
        btnRSVP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get text from EditText fields
                String firstName = editTextFirstName.getText().toString().trim();
                String lastName = editTextLastName.getText().toString().trim();



                // Validate if the fields are not empty
                if (!firstName.isEmpty() && !lastName.isEmpty()) {
                    student_rsvp.child("First Name").setValue(firstName);
                    student_rsvp.child("Last Name").setValue(lastName);

                } else {
                    // Show a toast message for invalid input
                    Toast.makeText(MainActivity.this, "Please enter both first and last names.", Toast.LENGTH_SHORT).show();
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