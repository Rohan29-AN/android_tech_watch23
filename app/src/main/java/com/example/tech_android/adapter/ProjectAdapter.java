package com.example.tech_android.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tech_android.entity.ProjectModel;
import com.example.tech_android.R;
import com.example.tech_android.databinding.ItemProjectBinding;

import java.util.List;

public class ProjectAdapter extends RecyclerView.Adapter<ProjectAdapter.ViewHolder> {
    List<ProjectModel> _listProject;

    public  class ViewHolder extends RecyclerView.ViewHolder{
        ItemProjectBinding binding;

        public ViewHolder(@NonNull ItemProjectBinding itemView) {
            super(itemView.getRoot());
            this.binding=itemView;
        }
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemProjectBinding binding= DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.item_project,parent,false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ProjectAdapter.ViewHolder holder, int position) {
            if(_listProject!=null){
                ProjectModel projectModel=_listProject.get(position);
                holder.binding.setProjectModel(projectModel);
            }
    }

    @Override
    public int getItemCount() {
        return (_listProject!=null)?_listProject.size():0;
    }
}
