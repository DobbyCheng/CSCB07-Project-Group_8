package com.example.b07project.loginandregister;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class adminloginModel {
    FirebaseDatabase db;

    public adminloginModel() {
        db = FirebaseDatabase.getInstance("https://b07project-940f2-default-rtdb.firebaseio.com/");
    }

    public void adminlogin(adminloginPresenter presenter, String username, String password, ValueEventListener valueEventListener) {
        DatabaseReference ref = db.getReference();
        ref.child("admin").addListenerForSingleValueEvent(valueEventListener);
    }
}