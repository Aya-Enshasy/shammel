package com.drivers.shamelproject.q2;


import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
 import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
 import com.drivers.shamelproject.databinding.Item2Binding;

import java.util.ArrayList;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.viewHolder> {

    Context context;
    private  ArrayList<Photos> list ;
    MyDatabase myDatabase;

    public ImageAdapter(Context context, ArrayList<Photos> list) {
        this.context=context;
        this.list=list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ImageAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Item2Binding binding = Item2Binding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new viewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageAdapter.viewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.binding.title.setText(list.get(position).getTitle());

        Glide.with(context).load(list.get(position).getUrl()).into(holder.binding.image);

         holder.binding.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean res = myDatabase.deleteItem(list.get(position));
                if (res){
                    Toast.makeText(context, "deleted successfully", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(context, "error", Toast.LENGTH_SHORT).show();
                }
                notifyDataSetChanged();
            }
        });


    }

    @Override
    public int getItemCount() {
        return list!=null?list.size():0;
    }


    public class viewHolder extends RecyclerView.ViewHolder{
        Item2Binding binding;
        public viewHolder(Item2Binding  binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

    }


}
