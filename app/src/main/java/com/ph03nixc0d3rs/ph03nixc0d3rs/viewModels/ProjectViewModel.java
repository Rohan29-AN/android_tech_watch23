package com.ph03nixc0d3rs.ph03nixc0d3rs.viewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;


import com.ph03nixc0d3rs.ph03nixc0d3rs.entity.ProjectModel;
import com.ph03nixc0d3rs.ph03nixc0d3rs.repository.AppRepo;

import java.util.List;
import java.util.concurrent.ExecutionException;

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


    //FUTURE
    public List<ProjectModel> getListProjectFuture() throws ExecutionException, InterruptedException {
        return this.repo.ListProjectFuture();
    }



    public LiveData<List<ProjectModel>> getListProjectLive(){
        return this.repo.ListProjectLive();
    }
}
