package com.drivers.shamelproject.recycel;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.drivers.shamelproject.R;
import com.drivers.shamelproject.database.Student;
import com.drivers.shamelproject.databinding.ItemBinding;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.viewHolder> {

    Context context;
    private  ArrayList<News> list ;

    public NewsAdapter(Context context, ArrayList<News> list) {
        this.context=context;
        this.list=list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public NewsAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemBinding binding = ItemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new viewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsAdapter.viewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.binding.title.setText(list.get(position).getTitle());
        holder.binding.body.setText(list.get(position).getBody());
        Glide.with(context).load(list.get(position).getImage()).into(holder.binding.imageView2);

        //code delete item
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                //delete item
                list.remove(holder.getPosition());
                notifyDataSetChanged();

                return false;
            }
        });

        //dialog fragment
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment dialogFragment=new DialogFragment();
                TextView textView = dialogFragment.getView().findViewById(R.id.text);
                Button button = dialogFragment.getView().findViewById(R.id.button);
                textView.setText(list.get(position).getTitle());
                dialogFragment.show(((AppCompatActivity) context).getSupportFragmentManager(),"My  Fragment");

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialogFragment.dismiss();
                    }
                });
            }
        });


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
