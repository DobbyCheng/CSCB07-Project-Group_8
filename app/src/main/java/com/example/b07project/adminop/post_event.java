package com.example.b07project.adminop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.example.b07project.R;
import com.google.firebase.database.ValueEventListener;

public class post_event extends AppCompatActivity {

    FirebaseDatabase db;
    EditText editname,editlimit,editdate,edittime,editdescription;
    String use,name,date,time,description;

    int id,limit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_event);
        db = FirebaseDatabase.getInstance("https://b07project-940f2-default-rtdb.firebaseio.com/");
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String cur = dataSnapshot.child("currentuser"+ Settings.Secure.getString(getContentResolver(),Settings.Secure.ANDROID_ID)).getValue(String.class);
                use=cur;
                int iiif=dataSnapshot.child("eventid").getValue(Integer.class);
                id= iiif;
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // 处理错误情况
            }
        });

    }
    public  void  postevent(View view){
        DatabaseReference ref = db.getReference();
        editdate=findViewById(R.id.input_date);
        editdescription=findViewById(R.id.inputdescription);
        editlimit=findViewById(R.id.inputlimit);
        editname=findViewById(R.id.inputeventname);
        edittime=findViewById(R.id.input_time);
        name=editname.getText().toString();
        description=editdescription.getText().toString();
        String limit_str=editlimit.getText().toString();
        date=editdate.getText().toString();
        time=edittime.getText().toString();
        if(name.isEmpty() || description.isEmpty() || time.isEmpty() || date.isEmpty() || limit_str.isEmpty()) {
            Toast.makeText(getApplicationContext(), "you should input something", Toast.LENGTH_LONG).show();
        }
        else {
            limit=Integer.parseInt(limit_str);
            if(!checktime(time)){
                Toast.makeText(getApplicationContext(), "input time is invalid", Toast.LENGTH_LONG).show();
                return;
            }
            if(!isValidDate(date)){
                Toast.makeText(getApplicationContext(), "date format is invalid", Toast.LENGTH_LONG).show();
                return;
            }

            ++id;
            Event event = new Event(limit, date, time, name, description, id);
            ref.child("eventid").setValue(id);
            ref.child("events_list").child(String.valueOf(id)).setValue(event);
            Toast.makeText(getApplicationContext(), "posted", Toast.LENGTH_LONG).show();
        }
    }

    public boolean checktime(String time) {
        // Regular expression to match 24-hour time format
        String regex = "([01]?[0-9]|2[0-3]):[0-5][0-9]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(time);

        return matcher.matches();
    }

    public static boolean isValidDate(String date) {
        // Regular expression for the date format dd/mm/yyyy
        String regex = "^([0-2][0-9]|3[01])/(0[1-9]|1[012])/(\\d{4})$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(date);

        return matcher.matches();
    }

    public void posteventback(View view){
         Intent x=new Intent(getApplicationContext(), adminpage.class);
         startActivity(x);
    }

}