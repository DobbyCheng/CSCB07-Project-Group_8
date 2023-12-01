package com.example.b07project.adminop;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.b07project.R;
import com.example.b07project.stuentop.student;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;

public class viewcomplaint extends AppCompatActivity {


    FirebaseDatabase db;
    RecyclerView recyclerView;

    ViewComplaintsRecyclerViewAdapter comAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewcomplaint);

        recyclerView = findViewById(R.id.recycler_comp);
        db = FirebaseDatabase.getInstance("https://b07project-940f2-default-rtdb.firebaseio.com/");
        DatabaseReference ref = db.getReference();

        ArrayList<ViewComplaintModel> usersList = new ArrayList<>();
        comAdapter = new ViewComplaintsRecyclerViewAdapter(viewcomplaint.this, usersList);
        recyclerView.setAdapter(comAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(viewcomplaint.this));
        //usersList.add(new ViewComplaintModel("s1", "s2","s3","s4","s5"));

        ref.child("complaint").addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                usersList.clear();
                for (DataSnapshot snap : snapshot.getChildren()){
                    String topic = snap.child("topic").getValue(String.class);
                    String content = snap.child("content").getValue(String.class);
                    String name = snap.child("name").getValue(String.class);
                    String date = snap.child("date").getValue(String.class);
                    String id = snap.child("id").getValue(String.class);
                    ViewComplaintModel complaint = new ViewComplaintModel(topic, content, name, date, id);
                    usersList.add(complaint);
                }
                Collections.reverse(usersList);
                comAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error){

            }
        });

//        ViewComplaintsRecyclerViewAdapter recyclerViewAdapter = new ViewComplaintsRecyclerViewAdapter(viewcomplaint.this, usersList);
//
//        recyclerView.setAdapter(recyclerViewAdapter);
//        recyclerView.setLayoutManager(new LinearLayoutManager(viewcomplaint.this));
    }

    public void goback(View v){
        Intent x= new Intent(getApplicationContext(), adminpage.class);
        startActivity(x);
    }

}