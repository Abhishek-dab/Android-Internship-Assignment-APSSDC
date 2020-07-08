package com.example.recycleview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    int myImages[];
    String muNames[];
    String myVersions[];
    String myApi[];
    String myRelease[];
    Context ct;

    public MyAdapter(MainActivity mainActivity, int[] images, String[] names, String[] versions, String[] api, String[] release) {
        myImages =images;
        myVersions = versions;
        muNames = names;
        myApi = api;
        myRelease = release;
        ct = mainActivity;
    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v = LayoutInflater.from(ct).inflate(R.layout.item,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(v);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {

        holder.iv.setImageResource(myImages[position]);
        holder.tv.setText("Name: "+muNames[position]);
        holder.tv1.setText("Version: " +myVersions[position]);
        holder.tv2.setText("API: "+myApi[position]);
        holder.tv3.setText("Release: " +myRelease[position]);

    }

    @Override
    public int getItemCount() {
        return myImages.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView iv;
        TextView tv;
        TextView tv1;
        TextView tv2;
        TextView tv3;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.poster);
            tv = itemView.findViewById(R.id.code);
            tv1 = itemView.findViewById(R.id.version);
            tv2 = itemView.findViewById(R.id.api);
            tv3 = itemView.findViewById(R.id.date);
        }
    }
}
