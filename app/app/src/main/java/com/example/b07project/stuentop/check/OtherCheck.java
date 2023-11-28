package com.example.b07project.stuentop.check;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.b07project.R;

public class OtherCheck extends AppCompatActivity {
    EditText a67,a31,a48,a22,a37,a08,cr;
    CheckBox fin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_check);
    }
    public void  othback(View view){
        Intent x=new Intent(getApplicationContext(), checkpost.class);
        startActivity(x);
    }

    public  void  othcp(View view){
        TextView res=findViewById(R.id.result);
        a67=findViewById(R.id.grade67);
        String g67=a67.getText().toString();
        a31=findViewById(R.id.grade31);
        String g31=a31.getText().toString();
        a22=findViewById(R.id.grade22);
        String g22=a22.getText().toString();
        a48=findViewById(R.id.grade48);
        String g48=a48.getText().toString();
        a08=findViewById(R.id.grade08);
        String g08=a08.getText().toString();
        a37=findViewById(R.id.grade37);
        String g37=a37.getText().toString();
        cr=findViewById(R.id.credit);
        String done=cr.getText().toString();
        fin =findViewById(R.id.checkfinish);
        boolean isdone= fin.isChecked();
        if (!isdone){
            res.setText("IMPOSSIBLE TO ENTER ANYTHING");
        }
        else {
            checking x=new checking();
            if (x.checkvalid1(done)&&x.checkvalid2(g31,g67,g08,g22,g37,g48,"other")){

                res.setText("your reuslt: "+x.checkSpecialist());
            }
            else {
                res.setText("invalid input");
            }
        }
    }
    public  void  othcm(View view){
        TextView res=findViewById(R.id.othresult);
        a67=findViewById(R.id.grade67);
        String g67=a67.getText().toString();
        a31=findViewById(R.id.grade31);
        String g31=a31.getText().toString();
        a22=findViewById(R.id.grade22);
        String g22=a22.getText().toString();
        a48=findViewById(R.id.grade48);
        String g48=a48.getText().toString();
        a08=findViewById(R.id.grade08);
        String g08=a08.getText().toString();
        a37=findViewById(R.id.grade37);
        String g37=a37.getText().toString();
        cr=findViewById(R.id.credit);
        String done=cr.getText().toString();
        fin =findViewById(R.id.checkfinish);
        boolean isdone= fin.isChecked();
        if (!isdone){
            res.setText("your reuslt: "+"IMPOSSIBLE TO ENTER ANYTHING");
        }
        else {
            checking x=new checking();
            if (x.checkvalid1(done)&&x.checkvalid2(g31,g67,g08,g22,g37,g48,"other")){

                res.setText("your reuslt: "+x.checkMajor());
            }
            else {
                res.setText("invalid input");
            }
        }
    }

    public  void  othcn(View view){
        TextView res=findViewById(R.id.result);
        a67=findViewById(R.id.grade67);
        String g67=a67.getText().toString();
        a31=findViewById(R.id.grade31);
        String g31=a31.getText().toString();
        a22=findViewById(R.id.grade22);
        String g22=a22.getText().toString();
        a48=findViewById(R.id.grade48);
        String g48=a48.getText().toString();
        a08=findViewById(R.id.grade08);
        String g08=a08.getText().toString();
        a37=findViewById(R.id.grade37);
        String g37=a37.getText().toString();
        cr=findViewById(R.id.credit);
        String done=cr.getText().toString();
        fin =findViewById(R.id.checkfinish);
        boolean isdone= fin.isChecked();
        if (!isdone){
            res.setText("your reuslt: "+"IMPOSSIBLE TO ENTER ANYTHING");
        }
        else {
            checking x=new checking();
            if (x.checkvalid1(done)&&x.checkvalid2(g31,g67,g08,g22,g37,g48,"other")){

                res.setText("your reuslt: "+x.checkMinor());
            }
            else {
                res.setText("invalid input");
            }
        }
    }

}