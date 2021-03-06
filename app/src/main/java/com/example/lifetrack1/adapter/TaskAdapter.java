package com.example.lifetrack1.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lifetrack1.OnLongItemListener;
import com.example.lifetrack1.R;
import com.example.lifetrack1.databinding.ItemTaskBinding;
import com.example.lifetrack1.model.TaskModel;

import java.util.ArrayList;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {
    ArrayList<TaskModel> list;
    ItemTaskBinding binding;
    OnLongItemListener listener ;
    boolean isFillDay;



    public TaskAdapter(ArrayList<TaskModel> list, OnLongItemListener listener) {
        this.list = list;
        this.listener = listener;
    }



    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ItemTaskBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new TaskViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        holder.onFill(list.get(position));
    }
    public void setFillDayTrue(boolean isFillDay){
        this.isFillDay=isFillDay;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class TaskViewHolder extends RecyclerView.ViewHolder {
        public TaskViewHolder(@NonNull ItemTaskBinding binding) {
            super(binding.getRoot());
        }

        public void onFill(TaskModel model){
            binding.taskTv.setText(model.getTask());
            binding.deadlineTv.setText(model.getDeadline());
            binding.repeatTv.setText(model.getRepeatCount());
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    listener.itemLongClick(model);
                    return true;
                }
            });
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.itemClick(model);
                }
            });
        }
    }


}

