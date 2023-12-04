package com.example.b07project.loginandregister;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.b07project.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
public class adminregister extends AppCompatActivity {
    FirebaseDatabase db;

    String adminUser;
    String adminPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminregister);
        db = FirebaseDatabase.getInstance("https://b07project-940f2-default-rtdb.firebaseio.com/");
    }

    public void adminSignup(View view) {
        DatabaseReference ref = db.getReference();
        final EditText adminUsername = findViewById(R.id.editTextAdminUsername);
        final EditText adminPassword = findViewById(R.id.editTextAdminPassword);
        adminUser = adminUsername.getText().toString();
        adminPass = adminPassword.getText().toString();
        DatabaseReference query = ref.child("admin").child(adminUser);

        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                if (PasswordValidator.isValidPassword(adminPass)) {
                    if (!snapshot.exists()) {
                        Admin admin = new Admin(adminUser, adminPass);
                        ref.child("admin").child(adminUser).setValue(admin);

                        Toast.makeText(getApplicationContext(), "success!", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(getApplicationContext(), adminloginView.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(getApplicationContext(), "Admin username existed", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "password must be in length of 6 to 16, have at least one letter and number", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
            }
        });
    }

    public void goToAdminLogin(View view) {
        Intent intent = new Intent(getApplicationContext(), adminloginView.class);
        startActivity(intent);
    }
}