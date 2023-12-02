package com.example.b07project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class adminpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminpage);

    }

    public  void  gotoevent(View v){
        Intent x=new Intent(getApplicationContext(), rsvp.class);
        startActivity(x);
    }

    public  void  gotoschedule(View v){
        Intent x=new Intent(getApplicationContext(), rsvp.class);
        startActivity(x);
    }

    public void gotoviewcomplaints(View v){
        Intent x=new Intent(getApplicationContext(), complaint.class);
        startActivity(x);
    }
    public  void gotopostannouncement(View v){
        Intent x=new Intent(getApplicationContext(), postannouncement.class);
        startActivity(x);
    }

    public  void gotofeedback(View v){
        Intent x=new Intent(getApplicationContext(), comment.class);
        startActivity(x);
    }
}