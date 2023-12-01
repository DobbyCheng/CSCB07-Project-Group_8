package com.example.b07project.stuentop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.b07project.R;

public class rsvp extends AppCompatActivity {

    String eventId;
    TextView thisevent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rsvp);
        eventId = getIntent().getStringExtra("event_id");
        thisevent=findViewById(R.id.trry);
        thisevent.setText(eventId);
    }

}