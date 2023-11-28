package com.example.b07project.adminop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.b07project.MainActivity;
import com.example.b07project.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class viewcomplaint extends AppCompatActivity {


    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewcomplaint);

        recyclerView = findViewById(R.id.recycler);

        ArrayList<ViewComplaintsModel> usersList = new ArrayList<>();
        usersList.add(new ViewComplaintsModel("surprise1"));
        usersList.add(new ViewComplaintsModel("surprise2"));
        usersList.add(new ViewComplaintsModel("surprise3"));
        usersList.add(new ViewComplaintsModel("surprise3"));
        usersList.add(new ViewComplaintsModel("surprise3"));
        usersList.add(new ViewComplaintsModel("surprise3"));
        usersList.add(new ViewComplaintsModel("surprise3"));
        usersList.add(new ViewComplaintsModel("surprise3"));
        usersList.add(new ViewComplaintsModel("surprise3"));
        usersList.add(new ViewComplaintsModel("surprise3"));
        usersList.add(new ViewComplaintsModel("surprise3"));
        usersList.add(new ViewComplaintsModel("surprise4"));
        usersList.add(new ViewComplaintsModel("surprise3"));
        usersList.add(new ViewComplaintsModel("surprise3"));
        usersList.add(new ViewComplaintsModel("surprise3"));
        usersList.add(new ViewComplaintsModel("surprise3"));
        usersList.add(new ViewComplaintsModel("surprise3"));
        usersList.add(new ViewComplaintsModel("surprise8"));

        ViewComplaintsRecyclerViewAdapter recyclerViewAdapter = new ViewComplaintsRecyclerViewAdapter(viewcomplaint.this, usersList);

        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(viewcomplaint.this));
    }
}