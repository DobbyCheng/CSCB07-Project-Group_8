package com.example.b07project.loginandregister;

import com.google.firebase.database.DataSnapshot;

public class loginPresenter {
    loginModel model;
    loginView view;

    public loginPresenter(loginView view, loginModel model) {
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
            model.studentlogin(username, password, this);
        }
    }

    public void userStuff(String username, String password, DataSnapshot snapshot){
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
}
