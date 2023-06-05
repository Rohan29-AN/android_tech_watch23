package com.ph03nixc0d3rs.ph03nixc0d3rs.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;


import com.ph03nixc0d3rs.R;
import com.ph03nixc0d3rs.databinding.ItemProjectBinding;
import com.ph03nixc0d3rs.ph03nixc0d3rs.entity.ProjectModel;
import com.ph03nixc0d3rs.ph03nixc0d3rs.event.OnClickItemInterface;

import java.util.List;

public class ProjectAdapter extends RecyclerView.Adapter<ProjectAdapter.ViewHolder> {
    List<ProjectModel> _listProject;
    OnClickItemInterface onClickItemInterface;


    public ProjectAdapter(OnClickItemInterface onClickItemInterface) {
        this.onClickItemInterface = onClickItemInterface;
    }

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
                holder.binding.setListener(this.onClickItemInterface);
            }
    }

    @Override
    public int getItemCount() {
        return (_listProject!=null)?_listProject.size():0;
    }


    public void setProjects(List<ProjectModel> projects){
        this._listProject=projects;
        notifyDataSetChanged();
    }
}
