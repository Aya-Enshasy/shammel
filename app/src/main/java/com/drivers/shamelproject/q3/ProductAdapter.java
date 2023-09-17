package com.drivers.shamelproject.q3;


import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.drivers.shamelproject.R;
import com.drivers.shamelproject.databinding.ItemBinding;
import com.drivers.shamelproject.recycel.News;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.viewHolder> {

    Context context;
    private  ArrayList<Product> list ;

    public ProductAdapter(Context context, ArrayList<Product> list) {
        this.context=context;
        this.list=list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ProductAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemBinding binding = ItemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new viewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.viewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.binding.title.setText(list.get(position).getName());
        holder.binding.body.setText(list.get(position).getQyt());
        holder.binding.price.setText(list.get(position).getPrice());



         holder.binding.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteItem(position);
            }
        });


    }

    @Override
    public int getItemCount() {
        return list!=null?list.size():0;
    }

    public void deleteItem(int position) {
        DeleteConfirmationDialogFragment dialogFragment = new DeleteConfirmationDialogFragment();
        dialogFragment.setOnDeleteConfirmedListener(new DeleteConfirmationDialogFragment.OnDeleteConfirmedListener() {
            @Override
            public void onDeleteConfirmed() {
                 list.remove(position);
                 notifyItemRemoved(position);
            }
        });
        dialogFragment.show(((FragmentActivity) context).getSupportFragmentManager(), "delete_dialog");
    }
    public class viewHolder extends RecyclerView.ViewHolder{
        ItemBinding binding;
        public viewHolder(ItemBinding  binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

    }


}
