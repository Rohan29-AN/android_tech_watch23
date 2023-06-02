package com.example.tech_android.repository;

import android.content.Context;

import com.example.tech_android.Entity.ProjectModel;
import com.example.tech_android.database.AppDatabase;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class AppRepo {
    private AppDatabase appDatabase;
    private Executor executor= Executors.newSingleThreadExecutor();

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

    public List<ProjectModel> ListProject(){
        return appDatabase.projectDAO().getProjectFuture();
    }
}
