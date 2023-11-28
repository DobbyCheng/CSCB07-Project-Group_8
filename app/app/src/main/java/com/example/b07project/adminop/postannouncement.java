package com.example.b07project.adminop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.b07project.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class postannouncement extends AppCompatActivity {
    FirebaseDatabase db;
    EditText title,content;
    String use;
    String id;

    // 获取当前日期
    LocalDate today = LocalDate.now();

    // 创建日期格式化对象
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    // 格式化日期
    String formattedDate = today.format(formatter);
    int iid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postannouncement);
        db = FirebaseDatabase.getInstance("https://b07project-940f2-default-rtdb.firebaseio.com/");
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();


        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String cur = dataSnapshot.child("currentuser"+ Settings.Secure.getString(getContentResolver(),Settings.Secure.ANDROID_ID)).getValue(String.class);
                use=cur;
                int iiif=dataSnapshot.child("announcementlength").getValue(Integer.class);
                iid= iiif;
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // 处理错误情况
            }
        });
    }

    public void postann(View view){
        title=findViewById(R.id.anntitle);
        content=findViewById(R.id.anncontent);
        String tt=title.getText().toString();
        String ct=content.getText().toString();
        DatabaseReference ref = db.getReference();
        if (tt.isEmpty()||ct.isEmpty()){
            Toast.makeText(getApplicationContext(), "you should input something", Toast.LENGTH_LONG).show();
        }
        else{
            Annc ann=new Annc(use,tt,ct,String.valueOf(iid),formattedDate);
//            ref.child("announcement").child(String.valueOf(iid)).child("title").setValue(tt);
//            ref.child("announcement").child(String.valueOf(iid)).child("content").setValue(ct);
//            ref.child("announcement").child(String.valueOf(iid)).child("id").setValue(String.valueOf(iid));
//            ref.child("announcement").child(String.valueOf(iid)).child("admin").setValue(use);
//            ref.child("announcement").child(String.valueOf(iid)).child("date").setValue(formattedDate);
            ref.child("announcement").child(String.valueOf(iid)).setValue(ann);
            ref.child("announcementlength").setValue(iid+1);
            Toast.makeText(getApplicationContext(),"posted",Toast.LENGTH_LONG).show();
            Intent x=new Intent(getApplicationContext(), postannouncement.class);
            startActivity(x);
        }
    }


    public void annbck(View view){
        Intent x=new Intent(getApplicationContext(), adminpage.class);
        startActivity(x);
    }
}