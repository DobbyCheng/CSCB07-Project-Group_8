package com.example.b07project.stuentop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.b07project.R;

public class comment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
    }

    public void goback(View v){
        Intent x= new Intent(getApplicationContext(), studeny.class);
        startActivity(x);
    }
}