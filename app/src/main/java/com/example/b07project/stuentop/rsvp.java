package com.example.b07project.stuentop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.b07project.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class rsvp extends AppCompatActivity {

    String eventId;
    TextView thisevent;
    String cur,participantlist, commentlist,date, introo;
    int ratingnum,ratingsum,participantleft;
    FirebaseDatabase db;


//
//    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rsvp);
        eventId = getIntent().getStringExtra("event_id");
        thisevent=findViewById(R.id.eventintro);
//        thisevent.setText(eventId);
        db = FirebaseDatabase.getInstance("https://b07project-940f2-default-rtdb.firebaseio.com/");
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                cur = dataSnapshot.child("currentuser"+ Settings.Secure.getString(getContentResolver(),Settings.Secure.ANDROID_ID)).getValue(String.class);
                ratingsum = dataSnapshot.child("events_list").child(String.valueOf(eventId)).child("ratingSum").getValue(Integer.class);
                ratingnum = dataSnapshot.child("events_list").child(String.valueOf(eventId)).child("ratingNum").getValue(Integer.class);
                participantleft=dataSnapshot.child("events_list").child(String.valueOf(eventId)).child("left").getValue(Integer.class);
                participantlist= dataSnapshot.child("events_list").child(String.valueOf(eventId)).child("participant").getValue(String.class);
                commentlist= dataSnapshot.child("events_list").child(String.valueOf(eventId)).child("commentlist").getValue(String.class);
                date= dataSnapshot.child("events_list").child(String.valueOf(eventId)).child("date").getValue(String.class);
                introo =dataSnapshot.child("events_list").child(String.valueOf(eventId)).child("description").getValue(String.class);
                thisevent.setText("Description: "+introo);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // 处理错误情况
            }
        });

    }




    public  void rsvpp(View view){
        DatabaseReference ref = db.getReference();

        if (participantleft>0){
            if(!participantlist.contains((cur+"/#"))){
            Toast.makeText(rsvp.this, "success",Toast.LENGTH_SHORT).show();
            participantleft--;
            ref.child("events_list").child(String.valueOf(eventId)).child("left").setValue(participantleft);
            participantlist=participantlist+cur+"/#";
            ref.child("events_list").child(String.valueOf(eventId)).child("participant").setValue(participantlist);
            }
            else {
                Toast.makeText(rsvp.this, "you have already signed up",Toast.LENGTH_SHORT).show();
            }

        }
        else {
            Toast.makeText(rsvp.this, "enrollment has reached capacity",Toast.LENGTH_SHORT).show();
        }
    }

    public void givefeedback(View view){
        DatabaseReference ref = db.getReference();
        EditText escore,ecomment;
        String scomment;
        ecomment=findViewById(R.id.studentcomment);
        scomment=ecomment.getText().toString();
        int sscore;
        escore=findViewById(R.id.score);
        sscore=Integer.parseInt(escore.getText().toString());

        // 获取当前日期
        LocalDate today = LocalDate.now();
        // 创建日期格式化对象
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        // 格式化日期
        String formattedDate = today.format(formatter);
        if(compareDates(formattedDate, date).equals("earlier")){
            Toast.makeText(getApplicationContext(), "you cannot comment on future events", Toast.LENGTH_LONG).show();
            return;
        }
        if(!participantlist.contains(cur+"/#")){
            Toast.makeText(rsvp.this,"you should rsvp this event first",Toast.LENGTH_LONG).show();
            return;
        }

        if(-1<sscore&&sscore<6) {
            ratingnum++;
            ratingsum += sscore;
            commentlist=commentlist+scomment+"/#";
            ref.child("events_list").child(String.valueOf(eventId)).child("ratingNum").setValue(ratingnum);
            ref.child("events_list").child(String.valueOf(eventId)).child("ratingSum").setValue(ratingsum);
            ref.child("events_list").child(String.valueOf(eventId)).child("commentlist").setValue(commentlist);
            escore.setText("");
            ecomment.setText("");
            Toast.makeText(rsvp.this, "successfully uploaded", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(rsvp.this, "your score should between 0 to 5", Toast.LENGTH_LONG).show();
        }

    }

    public static String compareDates(String date1, String date2) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date firstDate = sdf.parse(date1);
            Date secondDate = sdf.parse(date2);

            if (firstDate.before(secondDate)) {
                return "earlier";
            } else if (firstDate.after(secondDate)) {
                return "later";
            } else {
                return "the same date";
            }

        } catch (ParseException e) {
            return "Invalid date format";
        }
    }

    public void revppback(View view){
        Intent x= new Intent(getApplicationContext(),StudentViewEvent.class);
        startActivity(x);
    }

}