package com.example.b07project.loginandregister;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.b07project.R;
import com.example.b07project.adminop.adminpage;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class adminlogin extends AppCompatActivity {

    EditText username, password;
    Button log;
    adminloginPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminlogin);
        username = (EditText) findViewById(R.id.adminname);
        password = (EditText) findViewById(R.id.adminpassword);
        log = findViewById(R.id.adminlogbtn);
        presenter = new adminloginPresenter(this, new adminloginModel());

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.adminlogin(username.getText().toString(), password.getText().toString());
            }
        });

    }
    public void SetOutputText(String resultText){
        Toast.makeText(this, resultText, Toast.LENGTH_SHORT).show();
    }

    public void openadminpage(){
        startActivity(new Intent(adminlogin.this, adminpage.class));
        finish();
    }

    public void openregister(){
        Intent x = new Intent(getApplicationContext(), register.class);
        startActivity(x);
        finish();
    }
}