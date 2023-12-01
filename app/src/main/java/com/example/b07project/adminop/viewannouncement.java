package com.example.b07project.adminop;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

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

public class viewannouncement extends AppCompatActivity {


    FirebaseDatabase db;
    RecyclerView recyclerView;
    ViewAnnouncementRecyclerViewAdapter annAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewannouncement);

        recyclerView = findViewById(R.id.recycler_ann);
        db = FirebaseDatabase.getInstance("https://b07project-940f2-default-rtdb.firebaseio.com/");
        DatabaseReference ref = db.getReference();

        ArrayList<ViewAnnouncementModel> usersList = new ArrayList<>();
        annAdapter = new ViewAnnouncementRecyclerViewAdapter(viewannouncement.this, usersList);
        recyclerView.setAdapter(annAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(viewannouncement.this));
        //usersList.add(new ViewAnnouncementModel("s1", "s2","s3","s4","s5"));

        ref.child("announcement").addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                usersList.clear();
                for (DataSnapshot snap : snapshot.getChildren()){
                    String admin = snap.child("admin").getValue(String.class);
                    String title = snap.child("title").getValue(String.class);
                    String content = snap.child("content").getValue(String.class);
                    String id = snap.child("id").getValue(String.class);
                    String date = snap.child("date").getValue(String.class);
                    ViewAnnouncementModel ann = new ViewAnnouncementModel(admin, title, content, id, date);
                    usersList.add(ann);
                }
                Collections.reverse(usersList);
                annAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error){

            }
        });
    }

    public void goback(View v){
        Intent x= new Intent(getApplicationContext(), adminpage.class);
        startActivity(x);
    }
}