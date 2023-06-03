package com.example.tech_android.entity;


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


    public int get_ID() {
        return _ID;
    }

    public void set_ID(int _ID) {
        this._ID = _ID;
    }

    public int get_WATCHER() {
        return _WATCHER;
    }

    public void set_WATCHER(int _WATCHER) {
        this._WATCHER = _WATCHER;
    }

    public int get_ISSUES() {
        return _ISSUES;
    }

    public void set_ISSUES(int _ISSUES) {
        this._ISSUES = _ISSUES;
    }

    public String get_TITLE() {
        return _TITLE;
    }

    public void set_TITLE(String _TITLE) {
        this._TITLE = _TITLE;
    }

    public String get_LANGUAGE() {
        return _LANGUAGE;
    }

    public void set_LANGUAGE(String _LANGUAGE) {
        this._LANGUAGE = _LANGUAGE;
    }
}
