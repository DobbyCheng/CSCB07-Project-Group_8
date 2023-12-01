package com.example.b07project.loginandregister;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.b07project.R;
import com.example.b07project.stuentop.student;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import android.provider.Settings;

public class login extends AppCompatActivity {

    FirebaseDatabase db;
    EditText username,password;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        db = FirebaseDatabase.getInstance("https://b07project-940f2-default-rtdb.firebaseio.com/");
    }

    public void slogin(View view) {
        DatabaseReference ref = db.getReference();
        username = findViewById(R.id.loginusername);
        password = findViewById(R.id.password);
        login = findViewById(R.id.loginBtn);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String usernameTxt = username.getText().toString();
                final String passwordTxt = password.getText().toString();

                if (usernameTxt.isEmpty() || passwordTxt.isEmpty()) {
                    Toast.makeText(login.this, "no empty string", Toast.LENGTH_SHORT).show();
                } else {
                    ref.child("students").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            // check if mobile is exist in database
                            if (snapshot.hasChild(usernameTxt)) {
                                //username is exist in database
                                //now get password of user from database and match it with user entered password

                                String getPassword = String.valueOf(snapshot.child(usernameTxt).child("password").getValue());

                                if (getPassword.equals(passwordTxt)) {
                                    Toast.makeText(login.this, "Successfully Logged in", Toast.LENGTH_SHORT).show();
                                    //Open main activity on success
                                    ref.child("currentuser"+Settings.Secure.getString(getContentResolver(),Settings.Secure.ANDROID_ID)).setValue(usernameTxt);
                                    startActivity(new Intent(login.this, student.class));
                                    finish();
                                } else {
                                    Toast.makeText(login.this, "Wrong Password", Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                Toast.makeText(login.this, "Wrong Password or Username", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });

                }
            }
        });
    }

        public  void  gotosignup(View view){
            Intent intent = new Intent(getApplicationContext(), register.class);
            startActivity(intent);
        }
        public void gotoadmin(View view){
            Intent intent = new Intent(getApplicationContext(), adminlogin.class);
            startActivity(intent);
        }






}
