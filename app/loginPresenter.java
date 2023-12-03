package com.example.b07project.loginandregister;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

public class loginPresenter {
    loginModel model;
    login view;

    public loginPresenter(login view, loginModel model) {
        this.view = view;
        this.model = model;
    }

    public void studentlogin() {
        final String username = view.getUsername();
        final String password = view.getPassword();
        if (username.equals("") || password.equals(""))
        {
            view.SetOutputText("You have not put anything");
        }
        else{
            model.studentlogin(username, password, new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if(snapshot.hasChild(username)){
                                final String getPassword = String.valueOf(snapshot.child(username).child("password").getValue());

                                if(getPassword.equals(password)){
                                    view.SetOutputText("Successfully Logged in");
                                    String deviceId = view.getId();
                                    model.saveinformation(username, deviceId);
                                    view.openstudentpage();
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
