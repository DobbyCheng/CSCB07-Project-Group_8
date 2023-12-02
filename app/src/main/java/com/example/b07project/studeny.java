package com.example.b07project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.b07project.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class studeny extends AppCompatActivity {
    FirebaseDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        db = FirebaseDatabase.getInstance("https://b07project-940f2-default-rtdb.firebaseio.com/");
        TextView currrrent = findViewById(R.id.welcome);
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("currentuser");


//        ref.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                String cur = dataSnapshot.getValue(String.class);
//
//                if (cur != null && !cur.isEmpty()) {
//                    currrrent.setText("Welcome " + cur);
//                } else {
//                    currrrent.setText("Welcome Guest " + (cur != null ? cur : "jhon doe"));
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//                // 处理错误情况
//            }
//        });



    }

    public  void  gotocomplaint(View v){
        Intent x=new Intent(getApplicationContext(), complaint.class);
        startActivity(x);
    }

    public  void  gotocheck(View v){
        Intent x=new Intent(getApplicationContext(), checkpost.class);
        startActivity(x);
    }

    public void gotocomment(View v){
        Intent x=new Intent(getApplicationContext(),comment.class);
        startActivity(x);
    }
    public  void gotorsvp(View v){
        Intent x=new Intent(getApplicationContext(), rsvp.class);
        startActivity(x);
    }

}