package com.example.b07project.stuentop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.b07project.R;
import com.example.b07project.adminop.adminpage;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class complaint extends AppCompatActivity {
    FirebaseDatabase db;
    EditText title,content;
    String use;
    String id;
    LocalDate today = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    String formattedDate = today.format(formatter);
    int iid;
    CheckBox ann;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaint);
        db = FirebaseDatabase.getInstance("https://b07project-940f2-default-rtdb.firebaseio.com/");
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();

        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                use = dataSnapshot.child("currentuser"+ Settings.Secure.getString(getContentResolver(),Settings.Secure.ANDROID_ID)).getValue(String.class);
                iid = dataSnapshot.child("complaintlength").getValue(Integer.class);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    public void postcom(View view){
        title=findViewById(R.id.anntitle);
        content=findViewById(R.id.anncontent);
        String title_entered = title.getText().toString();
        String content_entered = content.getText().toString();
        DatabaseReference ref = db.getReference();
        ann = findViewById(R.id.annou);
        boolean isann = ann.isChecked();
        if (title_entered.isEmpty() || content_entered.isEmpty()){
            Toast.makeText(getApplicationContext(), "you haven't make any complaint", Toast.LENGTH_LONG).show();
        }
        else{
            ref.child("complaint").child(String.valueOf(iid)).child("title").setValue(title_entered);
            ref.child("complaint").child(String.valueOf(iid)).child("content").setValue(content_entered);
            ref.child("complaint").child(String.valueOf(iid)).child("id").setValue(String.valueOf(iid));
            if(!isann){
                ref.child("complaint").child(String.valueOf(iid)).child("sender").setValue(use);
            }
            ref.child("complaint").child(String.valueOf(iid)).child("date").setValue(formattedDate);
            ref.child("complaintlength").setValue(iid + 1);
            Toast.makeText(getApplicationContext(),"posted",Toast.LENGTH_LONG).show();
            Intent x=new Intent(getApplicationContext(), complaint.class);
            startActivity(x);
        }
    }


    public void combck(View view){
        Intent x=new Intent(getApplicationContext(), adminpage.class);
        startActivity(x);
    }

}