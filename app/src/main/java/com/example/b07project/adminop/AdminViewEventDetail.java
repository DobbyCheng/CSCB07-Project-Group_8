package com.example.b07project.adminop;

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

public class AdminViewEventDetail extends AppCompatActivity {

    String eventId;
    FirebaseDatabase db;
    String participantlist, commentlist, eventName;
    int ratingnum,ratingsum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_view_event_detail);
        eventId = getIntent().getStringExtra("event_id");
        db = FirebaseDatabase.getInstance("https://b07project-940f2-default-rtdb.firebaseio.com/");
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();

        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                eventName = dataSnapshot.child("events_list").child(String.valueOf(eventId)).child("eventName").getValue(String.class);
                ratingsum = dataSnapshot.child("events_list").child(String.valueOf(eventId)).child("ratingSum").getValue(Integer.class);
                ratingnum = dataSnapshot.child("events_list").child(String.valueOf(eventId)).child("ratingNum").getValue(Integer.class);
                participantlist= dataSnapshot.child("events_list").child(String.valueOf(eventId)).child("participant").getValue(String.class);
                commentlist= dataSnapshot.child("events_list").child(String.valueOf(eventId)).child("commentlist").getValue(String.class);
                updateUI();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // 处理错误情况
            }
        });
    }

    public void updateUI(){
        TextView ratingView = findViewById(R.id.event_detail_rating);
        String formattedNumber = String.format("%.2f", (double)ratingsum/(double)ratingnum);
        ratingView.setText("Rating: " + formattedNumber+
                "\n"+"Rating Count: " + Integer.toString(ratingnum));
        TextView commentView = findViewById(R.id.event_detail_comment);
        commentView.setText("Comment: "+splitComment(commentlist));
        TextView participantView = findViewById(R.id.event_detail_participants);
        participantView.setText("Participants: "+splitParticipant(participantlist));
        TextView nameView = findViewById(R.id.event_detail_name);
        nameView.setText("Event name: "+eventName);
    }

    public String splitParticipant(String s){
        String[] a = s.split("/#");
        String res = "\n";
        boolean f = true;
        for(String ppl:a){
            if(ppl == null) continue;
            if(f){
                f = false;
                res += ppl;
                continue;
            }
            res += "; " + ppl;
        }
        return res;
    }

    public String splitComment(String s){
        String[] a = s.split("/#");
        String res = "";
        for(String ppl:a){
            if(ppl == null) continue;
            res += "\n" + ppl;
        }
        return res;
    }

    public void goback(View view){
        Intent x= new Intent(getApplicationContext(), AdminViewEvent.class);
        startActivity(x);
    }
}