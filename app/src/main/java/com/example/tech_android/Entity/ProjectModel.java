package com.example.tech_android.Entity;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName="project")
public class ProjectModel {

    //id,title,language,watcher,issues
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "p_Id")
    public int _ID;

    @ColumnInfo(name = "p_watcher")
    public int _WATCHER;

    @ColumnInfo(name = "p_issues")
    public int _ISSUES;

    @ColumnInfo(name = "p_title")
    public String _TITLE;

    @ColumnInfo(name = "p_language")
    public String _LANGUAGE;




}
