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
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.title.setText(usersList.get(position).getTitle());
        holder.id.setText(usersList.get(position).getId());
        holder.date.setText(usersList.get(position).getDate());
        holder.content.setText(usersList.get(position).getContent());
        holder.admin.setText(usersList.get(position).getAdmin());
    }

    @Override
    public int getItemCount() {
        return this.usersList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView title;
        public TextView date;
        public TextView id;
        public TextView content;
        public TextView admin;

        public MyViewHolder(@NonNull View itemView){
            super(itemView);

            id = itemView.findViewById(R.id.announcement_id);
            title = itemView.findViewById(R.id.announcement_title);
            date = itemView.findViewById(R.id.announcement_date);
            content = itemView.findViewById(R.id.announcement_content);
            admin = itemView.findViewById(R.id.announcement_admin);
        }
    }
}
