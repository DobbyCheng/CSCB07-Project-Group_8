package com.example.b07project.loginandregister;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.b07project.R;
import com.example.b07project.adminop.adminpage;
import com.example.b07project.stuentop.student;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import android.provider.Settings;

public class login extends AppCompatActivity {
    EditText username,password;
    Button login;

    loginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = (EditText) findViewById(R.id.loginusername);
        password = (EditText) findViewById(R.id.password);
        login = findViewById(R.id.loginBtn);
        presenter = new loginPresenter(this, new loginModel());

        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                presenter.studentlogin(username.getText().toString(), password.getText().toString());
            }
        });
    }

    public void SetOutputText(String resultText){
        Toast.makeText(this, resultText, Toast.LENGTH_SHORT).show();
    }
    public  void  gotosignup(View view){
        Intent intent = new Intent(getApplicationContext(), register.class);
        startActivity(intent);
    }
    public void gotoadmin(View view){
        Intent intent = new Intent(getApplicationContext(), adminlogin.class);
        startActivity(intent);
    }

    public  void  gotoadminsignup(View view){
        Intent intent = new Intent(getApplicationContext(), adminregister.class);
        startActivity(intent);
    }

    public void openstudentpage(){
        startActivity(new Intent(login.this, student.class));
        finish();
    }

    public String getId(){
        return Settings.Secure.getString(getContentResolver(),Settings.Secure.ANDROID_ID);
    }

}
