package com.example.b07project.stuentop;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.b07project.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;

public class StudentViewEvent extends AppCompatActivity {


    FirebaseDatabase db;
    RecyclerView recyclerView;

    StudentViewEventAdapter comAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentviewevent);

        recyclerView = findViewById(R.id.recycler_StudentEvent);
        db = FirebaseDatabase.getInstance("https://b07project-940f2-default-rtdb.firebaseio.com/");
        DatabaseReference ref = db.getReference();

        ArrayList<StudentViewEventModel> usersList = new ArrayList<>();
        comAdapter = new StudentViewEventAdapter(StudentViewEvent.this, usersList);
        recyclerView.setAdapter(comAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(StudentViewEvent.this));

        ref.child("events_list").addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                usersList.clear();
                for (DataSnapshot snap : snapshot.getChildren()){
                    String name = snap.child("eventName").getValue(String.class);
                    String description = snap.child("description").getValue(String.class);
                    String time = snap.child("time").getValue(String.class);
                    String date = snap.child("date").getValue(String.class);
                    int eventId = snap.child("eventID").getValue(Integer.class);
                    int ratingSum = snap.child("ratingSum").getValue(Integer.class);
                    int ratingNum = snap.child("ratingNum").getValue(Integer.class);
                    StudentViewEventModel event = new StudentViewEventModel(name,
                            description,time,date,eventId,ratingSum,ratingNum);
                    usersList.add(event);
                }
                Collections.reverse(usersList);
                comAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error){

            }
        });

    }
}