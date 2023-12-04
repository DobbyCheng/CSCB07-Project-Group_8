package com.example.b07project.loginandregister;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class loginModel {
    FirebaseDatabase db;

    public loginModel(){
        db = FirebaseDatabase.getInstance("https://b07project-940f2-default-rtdb.firebaseio.com/");
    }

    public void studentlogin(String username, String password, loginPresenter presenter) {
        DatabaseReference ref = db.getReference();

        ref.child("students").addListenerForSingleValueEvent(new ValueEventListener(){
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                presenter.userStuff(username, password, snapshot);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void saveinformation(String username, String deviceId){
        DatabaseReference ref = db.getReference();
        ref.child("currentuser"+ deviceId).setValue(username);
    }
}
