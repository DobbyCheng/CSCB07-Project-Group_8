package com.example.b07project.loginandregister;

import android.content.ContentResolver;
import android.provider.Settings;

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

    public void saveinformation(String username, String deviceId){
        DatabaseReference ref = db.getReference();
        ref.child("currentuser"+ deviceId).setValue(username);
    }


}