
package com.example.admin_viewcommentandratingforeventpage;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView RVComment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RVComment = findViewById(R.id.recyclerViewComments);
        RVComment.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        RVComment.setAdapter(new Adapter(MainActivity.this, new Adapter.OnItemClickListener() {
            @Override
            public void onClick(int pos) {
                Toast.makeText(MainActivity.this, "Comment and rating " + (pos+1), Toast.LENGTH_SHORT).show();
            }
        }));
    }
}