package com.example.tech_android.viewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.tech_android.Entity.ProjectModel;
import com.example.tech_android.repository.AppRepo;

import java.util.List;

public class ProjectViewModel extends AndroidViewModel {
    private AppRepo repo;


    public ProjectViewModel(@NonNull Application application) {
        super(application);

        this.repo=  new AppRepo(application);
    }


    public void insertProject(ProjectModel projectModel){
        this.repo.insertProject(projectModel);
    }


    public void updateProject(ProjectModel projectModel){
        this.repo.updateProject(projectModel);
    }

    public void deleteProject(ProjectModel projectModel){
        this.repo.deleteProject(projectModel);
    }

    public List<ProjectModel> getListProject(){
        return this.repo.ListProject();
    }
}
