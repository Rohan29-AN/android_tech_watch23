package com.ph03nixc0d3rs.ph03nixc0d3rs.repository;

import android.content.Context;


import androidx.lifecycle.LiveData;


import com.ph03nixc0d3rs.ph03nixc0d3rs.database.AppDatabase;
import com.ph03nixc0d3rs.ph03nixc0d3rs.entity.ProjectModel;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.security.auth.callback.Callback;

public class AppRepo {
    private AppDatabase appDatabase;
    private Executor executor= Executors.newSingleThreadExecutor();


    //LIVE DATA


    public AppRepo(Context context) {
        appDatabase=AppDatabase.getInstance(context);
    }


    public  void insertProject(ProjectModel projectModel){

        executor.execute(new Runnable() {
            @Override
            public void run() {
                appDatabase.projectDAO().insertProject(projectModel);
            }
        });


    }


    public void updateProject(ProjectModel projectModel){

        executor.execute(new Runnable() {
            @Override
            public void run() {
                appDatabase.projectDAO().updateProject(projectModel);
            }
        });


    }



    public void deleteProject(ProjectModel projectModel){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                appDatabase.projectDAO().deleteProjet(projectModel);
            }
        });
    }

    public List<ProjectModel> ListProjectFuture() throws ExecutionException, InterruptedException {


        //Method no 3

        Callable<List<ProjectModel>> callable=new Callable<List<ProjectModel>>() {
            @Override
            public List<ProjectModel> call() throws Exception {
                return appDatabase.projectDAO().getProjectFuture();
            }
        };

        Future<List<ProjectModel>> future=Executors.newSingleThreadExecutor().submit(callable);
        return  future.get();
        //return appDatabase.projectDAO().getProjectFuture();
    }


    //Get ListProject using LiveData
    public LiveData<List<ProjectModel>> ListProjectLive(){
        return appDatabase.projectDAO().getAllProjectLive();
    }
}
