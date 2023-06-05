package com.ph03nixc0d3rs.ph03nixc0d3rs.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;


import com.ph03nixc0d3rs.ph03nixc0d3rs.entity.ProjectModel;

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
    public void deleteListOfProject(List<ProjectModel> projectModels);

    @Update
    public int updateListOfProject(List<ProjectModel> projectModels);

    @Insert
    public long[] insertListOfProject(List<ProjectModel> projectModels);

}
