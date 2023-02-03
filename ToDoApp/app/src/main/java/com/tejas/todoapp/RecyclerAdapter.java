package com.tejas.todoapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    Context context;
    List<Model> tasksList;

    public RecyclerAdapter(Context context, List<Model> tasksList) {
        this.context = context;
        this.tasksList = tasksList;
    }

    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder holder, int position) {

        Model item = tasksList.get(position);

        holder.checkBox.setText(item.getTasks());

        holder.checkBox.setOnLongClickListener(view -> {

            Intent intent = new Intent(context,EditTasksPage.class);
            intent.putExtra("text",item.getTasks());
            intent.putExtra("id",item.getId());

            context.startActivity(intent);


            return true;
        });





    }

    @Override
    public int getItemCount() {
        return tasksList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        CheckBox checkBox;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            checkBox = itemView.findViewById(R.id.checkBox);
        }
    }

}
