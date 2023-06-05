package com.ph03nixc0d3rs.ph03nixc0d3rs.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.ph03nixc0d3rs.ph03nixc0d3rs.dao.ProjectDAO;
import com.ph03nixc0d3rs.ph03nixc0d3rs.entity.ProjectModel;


@Database(entities = {ProjectModel.class},exportSchema = false,version = 1)
public abstract class AppDatabase  extends RoomDatabase {



    public static final String DATABASE_NAME="project_database.db";
    public  static AppDatabase instance;
    private static final  Object LOCK=new Object();
    public abstract ProjectDAO projectDAO();


    public static AppDatabase getInstance(Context context){
            if(instance==null){
                synchronized (LOCK){
                    if(instance==null){


                        /***To enable access to the database in the main thread, there are several solutions:
                         * 1- We can append this code box: allowMainThreadQueries ()
                         * 2-We can use liveData.
                         * 3-We can make future callable
                         * ....
                         * ***/


                        instance= Room.databaseBuilder(context.getApplicationContext(),AppDatabase.class,
                                DATABASE_NAME).build();
                    }
                }
            }

            return instance;
    }
}
