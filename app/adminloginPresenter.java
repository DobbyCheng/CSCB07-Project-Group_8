package com.example.b07project.loginandregister;

import android.app.Activity;
import android.content.Intent;
import android.provider.Settings;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.b07project.R;
import com.example.b07project.adminop.adminpage;
import com.example.b07project.adminop.postannouncement;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

public class adminloginPresenter {

    adminloginModel model;
    adminlogin view;

    public adminloginPresenter(adminlogin view, adminloginModel model) {
        this.model = model;
        this.view = view;
    }

    public void adminlogin(String username, String password) {
        if (username.equals("") || password.equals(""))
        {
            view.SetOutputText("You have not put anything");
        }
        else{
            model.adminlogin(this, username, password, new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if(snapshot.hasChild(username)){
                                final String getPassword = String.valueOf(snapshot.child(username).child("password").getValue());

                                if(getPassword.equals(password)){
                                    view.SetOutputText("Successfully Logged in");
                                    view.openadminpage();
                                }
                                else
                                {
                                    view.SetOutputText("Wrong Password");
                                }
                            }
                            else
                            {
                                view.SetOutputText("Wrong Password or Username");
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                        }
                    }
            );
        }
    }
}

