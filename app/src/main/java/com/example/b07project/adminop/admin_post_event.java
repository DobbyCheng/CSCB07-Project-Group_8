package com.example.b07project.adminop;

import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.b07project.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class admin_post_event extends AppCompatActivity {
    private EditText editTextName, editTextDate, editTextTime, editTextDescription;
    private Button scheduleEventButton;
    FirebaseDatabase db;
    private DatabaseReference myRef;
    int id;
    String use;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_post_event);
        db = FirebaseDatabase.getInstance("https://b07project-940f2-default-rtdb.firebaseio.com/");
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String cur = dataSnapshot.child("currentuser"+ Settings.Secure.getString(getContentResolver(),Settings.Secure.ANDROID_ID)).getValue(String.class);
                use=cur;
                int iiif=dataSnapshot.child("eventid").getValue(Integer.class);
                id= iiif;
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // 处理错误情况
            }
        });



    }
    public  void AdminPostEvent(View v){
        editTextName = findViewById(R.id.editTextExample);
        editTextDate = findViewById(R.id.editTextExample3);
        editTextTime = findViewById(R.id.editTextExample4);
        editTextDescription = findViewById(R.id.editTextExample5);
        scheduleEventButton = findViewById(R.id.scheduleEventButton);
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        if (validateInput()) {
            // Input is valid, proceed to store data in respective data types
            String name = editTextName.getText().toString();

            String date = editTextDate.getText().toString();
            String time = editTextTime.getText().toString();
            String description = editTextDescription.getText().toString();
            //writing to firebase database
            Event event=new Event(name,date,time,description,id);
            ref.child("events_list").child(String.valueOf(id)).setValue(event);
            ref.child("eventid").setValue(id+1);
            Toast.makeText(getApplicationContext(),"event scheduled",Toast.LENGTH_LONG).show();

        } else {
            Toast.makeText(getApplicationContext(), "Invalid input. Please try again.", Toast.LENGTH_SHORT).show();
        }

    }
    private boolean validateInput() {
        return !editTextName.getText().toString().trim().isEmpty() &&
                !editTextDate.getText().toString().trim().isEmpty() &&
                !editTextTime.getText().toString().trim().isEmpty() &&
                !editTextDescription.getText().toString().trim().isEmpty();
    }

    private void displayUserData(String name, int participantLimit, String date, String time, String description) {
        String userData = "Name: " + name +
                "\nDate: " + date +
                "\nTime: " + time +
                "\nDescription: " + description;

        Toast.makeText(getApplicationContext(), userData, Toast.LENGTH_SHORT).show();
    }

}