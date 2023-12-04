package com.example.b07project.loginandregister;

import com.google.firebase.database.DataSnapshot;

public class adminloginPresenter {

    adminloginModel model;
    adminloginView view;

    public adminloginPresenter(adminloginView view, adminloginModel model) {
        this.model = model;
        this.view = view;
    }

    public void adminlogin() {
        final String username = view.getUsername();
        final String password = view.getPassword();
        if (username.equals("") || password.equals(""))
        {
            view.SetOutputText("You have not put anything");
        }
        else
        {
            model.adminlogin(username, password, this);
        }
    }

    public void userStuff(String username, String password, DataSnapshot snapshot){
        if(snapshot.hasChild(username)){
            final String getPassword = String.valueOf(snapshot.child(username).child("password").getValue());
            if(getPassword.equals(password)){
                view.SetOutputText("Successfully Logged in");
                String deviceId = view.getId();
                model.saveinformation(username, deviceId);
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
}

