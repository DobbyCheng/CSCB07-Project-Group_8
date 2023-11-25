package com.example.b07project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class adminlogin extends AppCompatActivity {
    FirebaseDatabase db;
    EditText username,password;
    Button logn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminlogin);
        db = FirebaseDatabase.getInstance("https://b07project-940f2-default-rtdb.firebaseio.com/");
    }

    public void admnLogIn(View view) {
        DatabaseReference ref = db.getReference();
        username=findViewById(R.id.adminname);
        password=findViewById(R.id.adminpassword);
        logn=findViewById(R.id.adminlogbtn);
        logn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                if(user.isEmpty() || pass.isEmpty()){
                    Toast.makeText(adminlogin.this,"no empty string", Toast.LENGTH_SHORT).show();
                }
                else{
                    ref.child("admin").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            // check if mobile is exist in database
                            if(snapshot.hasChild(user)){
                                //username is exist in database
                                //now get password of user from database and match it with user entered password

                                final String getPassword = String.valueOf(snapshot.child(user).child("password").getValue());

                                if(getPassword.equals(pass)){
                                    Toast.makeText(adminlogin.this, "Successfully Logged in", Toast.LENGTH_SHORT).show();
                                    //Open main activity on success
                                    startActivity(new Intent(adminlogin.this, adminpage.class));
                                    finish();
                                }
                                else{
                                    Toast.makeText(adminlogin.this,"Wrong Password" + getPassword,Toast.LENGTH_SHORT).show();
                                }
                            }
                            else{
                                Toast.makeText(adminlogin.this, "Wrong Password or Username", Toast.LENGTH_SHORT).show();
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
}