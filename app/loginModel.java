package com.example.b07project.loginandregister;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class loginModel {
    FirebaseDatabase db;

    public loginModel(){
        db = FirebaseDatabase.getInstance("https://b07project-940f2-default-rtdb.firebaseio.com/");
    }

    public void studentlogin(String username, String password, ValueEventListener valueEventListener) {
        DatabaseReference ref = db.getReference();
        ref.child("students").addListenerForSingleValueEvent(valueEventListener);
    }

    public void saveinformation(String username, String deviceId){
        DatabaseReference ref = db.getReference();
        ref.child("currentuser"+ deviceId).setValue(username);
    }
}
