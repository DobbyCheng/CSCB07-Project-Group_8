package com.example.b07project.stuentop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.b07project.R;

import java.util.ArrayList;

public class StudentViewEventAdapter extends RecyclerView.Adapter<StudentViewEventAdapter.MyViewHolder>{

    Context context;
    ArrayList<StudentViewEventModel> usersList;
    public StudentViewEventAdapter(Context context, ArrayList<StudentViewEventModel> usersList) {
        this.context = context;
        this.usersList = usersList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(this.context).inflate(R.layout.viewevent_recyclerview_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewEventAdapter.MyViewHolder holder, int position) {
        holder.name.setText(usersList.get(position).getName());
        holder.description.setText(usersList.get(position).getDescription());
        holder.time.setText(usersList.get(position).getTime());
        holder.date.setText(usersList.get(position).getDate());
        holder.id.setText(usersList.get(position).getEventId());
        holder.rating.setText(usersList.get(position).getRating());
    }

    @Override
    public int getItemCount() {
        return this.usersList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name,description,time,date,id,rating;

        public MyViewHolder(@NonNull View itemView){
            super(itemView);

            name = itemView.findViewById(R.id.event_name);
            description = itemView.findViewById(R.id.event_description);
            time = itemView.findViewById(R.id.event_time);
            date = itemView.findViewById(R.id.event_date);
            id = itemView.findViewById(R.id.event_id);
            rating = itemView.findViewById(R.id.event_rating);
        }
    }
}
