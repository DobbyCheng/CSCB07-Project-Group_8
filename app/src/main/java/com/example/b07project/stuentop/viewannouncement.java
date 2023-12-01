package com.example.b07project.stuentop;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.b07project.R;

public class viewannouncement extends AppCompatActivity {

    private RecyclerView RVNotification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification_announcement_main);

        RVNotification = findViewById(R.id.recyclerViewComments);
        RVNotification.setLayoutManager(new LinearLayoutManager(viewannouncement.this));
        RVNotification.setAdapter(new ViewAnnouncementAdapter(viewannouncement.this, new ViewAnnouncementAdapter.OnItemClickListener() {
            @Override
            public void onClick(int pos) {
                Toast.makeText(viewannouncement.this, "Notification " + (pos+1), Toast.LENGTH_SHORT).show();
            }
        }));
    }
}