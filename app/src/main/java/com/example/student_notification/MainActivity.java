package com.example.student_notification;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView RVNotification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RVNotification = findViewById(R.id.recyclerViewComments);
        RVNotification.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        RVNotification.setAdapter(new Adapter(MainActivity.this, new Adapter.OnItemClickListener() {
            @Override
            public void onClick(int pos) {
                Toast.makeText(MainActivity.this, "Notification " + (pos+1), Toast.LENGTH_SHORT).show();
            }
        }));
    }
}