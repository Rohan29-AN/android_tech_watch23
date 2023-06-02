package com.example.tech_android.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.tech_android.Entity.ProjectModel;

import java.util.List;

@Dao
public interface ProjectDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertProject(ProjectModel projectModel);

    @Update
    public void updateProject(ProjectModel projectModel);

    @Delete
    public void deleteProjet(ProjectModel projectModel);

    @Query("SELECT * from project")
    public LiveData<List<ProjectModel>> getAllProjectLive();

    @Query("SELECT * from project")
    List<ProjectModel> getProjectFuture();


    @Query("SELECT * from project where p_Id=:id")
    ProjectModel getProject(int id);


    @Delete
    List<Integer> deleteListOfProject(List<ProjectModel> projectModels);

    @Update
    List<Integer> updateListOfProject(List<ProjectModel> projectModels);

    @Insert
    List<Integer> insertListOfProject(List<ProjectModel> projectModels);

}
