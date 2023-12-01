package com.example.b07project.stuentop;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.b07project.R;

public class ViewAnnouncementAdapter extends RecyclerView.Adapter <RecyclerView.ViewHolder>{
    @NonNull
    private Context mContext;
    private OnItemClickListener mListener;
    //private List<String> list;

    public ViewAnnouncementAdapter(Context context , OnItemClickListener listener){
        this.mContext = context;
        this.mListener = listener;
    }

    @Override
    public  RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //viewType可以通过这个，展示不同的item
        return new LinearViewHolder(LayoutInflater.from(mContext).inflate(R.layout.activity_notification_announcement, parent, false));
        //这里需要传入每个item长什么样的布局，需要去layout中去画我们的布局
    }

    @Override
    //通过getItemViewType的返回值来选择具体的item显示
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        //如果是直接用viewholder的话，是不能用test view的
        //将点击事件放到外面
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,"Notification "+(position+1),Toast.LENGTH_SHORT).show();
                mListener.onClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    class LinearViewHolder extends RecyclerView.ViewHolder{
        private TextView textView;

        public LinearViewHolder(View itemView){
            super(itemView);
        }
    }

    public interface  OnItemClickListener{
        void onClick(int pos);
    }
}