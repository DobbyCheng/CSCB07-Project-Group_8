package com.example.b07project.stuentop.check;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.b07project.R;

public class cscheck extends AppCompatActivity {

    EditText a67,a31,a48,a22,a37,a08,cr;
    CheckBox fin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkcs);
    }
    public void  csgb(View view){
        Intent x=new Intent(getApplicationContext(), checkpost.class);
        startActivity(x);
    }

    public  void  cscp(View view){
        //TextView res=findViewById(R.id.csresult);
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
            //res.setText("your result: "+"IMPOSSIBLE TO ENTER ANYTHING");
            Toast.makeText(this, "your result: "+"IMPOSSIBLE TO ENTER ANYTHING", Toast.LENGTH_SHORT).show();
        }
        else {
            checking x=new checking();
            if (x.checkvalid1(done)&&x.checkvalid2(g31,g67,g08,g22,g37,g48,"CS")){
                //res.setText("your result: "+x.checkSpecialist());
                Toast.makeText(this, "your result: "+x.checkSpecialist(), Toast.LENGTH_SHORT).show();
            }
            else {
                //res.setText("invalid input");
                Toast.makeText(this, "invalid input", Toast.LENGTH_SHORT).show();
            }
        }
    }
    public  void  cscm(View view){
        //TextView res=findViewById(R.id.csresult);
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
            //res.setText("your result: "+"IMPOSSIBLE TO ENTER ANYTHING");
            Toast.makeText(this, "your result: "+"IMPOSSIBLE TO ENTER ANYTHING", Toast.LENGTH_SHORT).show();
        }
        else {
            checking x=new checking();
            if (x.checkvalid1(done)&&x.checkvalid2(g31,g67,g08,g22,g37,g48,"CS")){
                //res.setText("your result: "+x.checkMajor());
                Toast.makeText(this, "your result: "+x.checkMajor(), Toast.LENGTH_SHORT).show();
            }
            else {
                //res.setText("invalid input");
                Toast.makeText(this, "invalid input", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public  void  cscn(View view){
        //TextView res=findViewById(R.id.csresult);
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
            //res.setText("your result: "+"IMPOSSIBLE TO ENTER ANYTHING");
            Toast.makeText(this, "your result: "+"IMPOSSIBLE TO ENTER ANYTHING", Toast.LENGTH_SHORT).show();
        }
        else {
            checking x=new checking();
            if (x.checkvalid1(done)&&x.checkvalid2(g31,g67,g08,g22,g37,g48,"CS")){
                //res.setText("your result: "+x.checkMinor());
                Toast.makeText(this, "your result: "+x.checkMinor(), Toast.LENGTH_SHORT).show();
            }
            else {
                //res.setText("invalid input");
                Toast.makeText(this, "invalid input", Toast.LENGTH_SHORT).show();
            }
        }
    }
}