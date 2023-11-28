package com.example.b07project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class checkpost extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkpost);
    }

    public  void  cpgp(View view){
        Intent intent = new Intent(getApplicationContext(), studeny.class);
        startActivity(intent);
    }
    public  void  gtmatcp(View view){
        Intent intent = new Intent(getApplicationContext(), MathadnStaCheck.class);
        startActivity(intent);
    }
    public  void gtothcp(View view){
        Intent intent = new Intent(getApplicationContext(), OtherCheck.class);
        startActivity(intent);
    }
    public  void  gtcscp(View view){
        Intent intent = new Intent(getApplicationContext(), cscheck.class);
        startActivity(intent);
    }
}