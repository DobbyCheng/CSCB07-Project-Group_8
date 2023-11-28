package com.example.b07project.loginandregister;

import com.example.b07project.R;
import com.example.b07project.loginandregister.login;
import com.example.b07project.loginandregister.stu;
import com.google.firebase.database.FirebaseDatabase;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
public class register extends AppCompatActivity{
    FirebaseDatabase db;

    String user;
    String pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        db = FirebaseDatabase.getInstance("https://b07project-940f2-default-rtdb.firebaseio.com/");
    }

    public void signup(View view){
        DatabaseReference ref = db.getReference();
        final EditText sUsername = (EditText) findViewById(R.id.editTextStudentUsername);
        final EditText sPassword = (EditText) findViewById(R.id.editTextStudentPassword);
        user = sUsername.getText().toString();
        pass = sPassword.getText().toString();
        DatabaseReference query = ref.child("students").child(user);

        query.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot snapshot) {
                if(!snapshot.exists())
                {
                    stu ss=new stu(user,pass);
                    ref.child("students").child(user).setValue(ss);
//                    ref.child("students").child(user).child("username").setValue(user);
//                    ref.child("students").child(user).child("password").setValue(pass);

                    Toast.makeText(getApplicationContext(),"success!",Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(getApplicationContext(), login.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(getApplicationContext(), "username existed", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
            }
        });
    }

    public void gotologin(View view) {
        Intent intent = new Intent(getApplicationContext(), login.class);
        startActivity(intent);
    }
}