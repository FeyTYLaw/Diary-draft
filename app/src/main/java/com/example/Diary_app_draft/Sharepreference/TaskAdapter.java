package com.example.Diary_app_draft.Sharepreference;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.Diary_app_draft.R;

import java.util.Collections;
import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.Holder> {
    private Context context;
    private List<TaskModel> taskModelList;

    public TaskAdapter(List<TaskModel> taskModelList){
        this.taskModelList = taskModelList;
    }

    public TaskAdapter(Context context, List<TaskModel> taskModelList) {
        this.context = context;
        this.taskModelList = taskModelList;
        Collections.reverse(taskModelList);
    }

    public void setTaskModelList(List<TaskModel> taskModelList) {
        this.taskModelList = taskModelList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerlayout, parent,false);
        /*return new Holder(LayoutInflater.from(context)
                .inflate(R.layout.recyclerlayout, parent, false));*/
        return new Holder(view).linkAdapter(this);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        Log.d("Daily", "taskModelList: " + taskModelList);
        holder.txtTaskName.setText(taskModelList.get(position).getTaskName());
        holder.txtTaskAddTime.setText(String.valueOf(taskModelList.get(position).getTaskAddedTime()));
    }

    @Override
    public int getItemCount() {
        return taskModelList != null ? taskModelList.size() : 0;
    }

    public class Holder extends RecyclerView.ViewHolder {
        TextView txtTaskName, txtTaskAddTime;
        private TaskAdapter adapter;

        public Holder(@NonNull View itemView) {
            super(itemView);
            txtTaskName = itemView.findViewById(R.id.oldDiary);
            txtTaskAddTime = itemView.findViewById(R.id.txt_date);
            itemView.findViewById(R.id.remove).setOnClickListener(view -> {
                adapter.taskModelList.remove(getAdapterPosition());
                adapter.notifyItemRemoved(getAdapterPosition());

            });
        }
        public Holder linkAdapter(TaskAdapter adapter){
            this.adapter = adapter;
            return this;

        }
    }



}
