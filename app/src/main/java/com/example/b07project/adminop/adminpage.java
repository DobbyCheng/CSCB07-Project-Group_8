package com.example.b07project.adminop;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.b07project.R;
import com.example.b07project.loginandregister.login;
import com.example.b07project.stuentop.comment;

public class adminpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminpage);

    }

    public  void  gotoevent(View v){
        Intent x=new Intent(getApplicationContext(), AdminViewEvent.class);
        startActivity(x);
    }

    public  void  gotoschedule(View v){
        Intent x=new Intent(getApplicationContext(), admin_post_event.class);
        startActivity(x);
    }

    public void gotoviewcomplaints(View v){
        Intent x=new Intent(getApplicationContext(), viewcomplaint.class);
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

    public  void  gotoviewannouncement(View v){
        Intent x=new Intent(getApplicationContext(), viewannouncement.class);
        startActivity(x);
    }

    public void gotologin(View v){
        Intent x=new Intent(getApplicationContext(), login.class);
        startActivity(x);
    }
}