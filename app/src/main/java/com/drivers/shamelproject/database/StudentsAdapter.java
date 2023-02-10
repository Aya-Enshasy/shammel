package com.drivers.shamelproject.database;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.drivers.shamelproject.databinding.ItemBinding;

import java.util.ArrayList;

public class StudentsAdapter extends RecyclerView.Adapter<StudentsAdapter.viewHolder> {

    Context context;
    private  ArrayList<Student> list ;

    public StudentsAdapter(Context context, ArrayList<Student> list) {
        this.context=context;
        this.list=list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public StudentsAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemBinding binding = ItemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new viewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentsAdapter.viewHolder holder, int position) {

        holder.binding.nameFromDatabase.setText(list.get(position).getName());
        holder.binding.ageFromDatabase.setText(list.get(position).getAge());
    }

    @Override
    public int getItemCount() {
        return list!=null?list.size():0;
    }


    public class viewHolder extends RecyclerView.ViewHolder{
        ItemBinding binding;
        public viewHolder(ItemBinding  binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

    }


}
