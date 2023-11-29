package com.example.b07project.adminop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.b07project.R;

import java.util.ArrayList;

public class ViewAnnouncementRecyclerViewAdapter extends RecyclerView.Adapter<ViewAnnouncementRecyclerViewAdapter.MyViewHolder>{

    Context context;
    ArrayList<ViewAnnouncementModel> usersList;
    public ViewAnnouncementRecyclerViewAdapter(Context context, ArrayList<ViewAnnouncementModel> usersList) {
        this.context = context;
        this.usersList = usersList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(this.context).inflate(R.layout.viewannouncement_recyclerview_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewAnnouncementRecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.textView.setText(usersList.get(position).getAdmin());
        holder.textView.setText(usersList.get(position).getTitle());
        holder.textView.setText(usersList.get(position).getContent());
        holder.textView.setText(usersList.get(position).getId());
        holder.textView.setText(usersList.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        return this.usersList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView textView;

        public MyViewHolder(@NonNull View itemView){
            super(itemView);

            textView = itemView.findViewById(R.id.announcement_id);
        }
    }
}
