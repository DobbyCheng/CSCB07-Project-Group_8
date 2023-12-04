package com.example.b07project.loginandregister;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.b07project.R;
import com.example.b07project.adminop.adminpage;

public class adminloginView extends AppCompatActivity {

    EditText username, password;
    Button log;
    adminloginPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminlogin);
        username = (EditText) findViewById(R.id.adminname);
        password = (EditText) findViewById(R.id.adminpassword);
        log = findViewById(R.id.adminlogbtn);
        presenter = new adminloginPresenter(this, new adminloginModel());

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.adminlogin();
            }
        });

    }
    public void SetOutputText(String resultText){
        Toast.makeText(this, resultText, Toast.LENGTH_SHORT).show();
    }

    public void openadminpage(){
        startActivity(new Intent(adminloginView.this, adminpage.class));
        finish();
    }

    public String getUsername(){
        return ((EditText) findViewById(R.id.adminname)).getText().toString();
    }

    public String getPassword(){
        return ((EditText) findViewById(R.id.adminpassword)).getText().toString();
    }

    public String getId(){
        return Settings.Secure.getString(getContentResolver(),Settings.Secure.ANDROID_ID);
    }

}