package com.example.tech_android.entity;


import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName="project")
public class ProjectModel implements Parcelable {

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


    /*public int get_ID() {
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
    }*/

    public ProjectModel(){

    }

    protected ProjectModel(Parcel in) {
        _ID = in.readInt();
        _WATCHER = in.readInt();
        _ISSUES = in.readInt();
        _TITLE = in.readString();
        _LANGUAGE = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(_ID);
        dest.writeInt(_WATCHER);
        dest.writeInt(_ISSUES);
        dest.writeString(_TITLE);
        dest.writeString(_LANGUAGE);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ProjectModel> CREATOR = new Creator<ProjectModel>() {
        @Override
        public ProjectModel createFromParcel(Parcel in) {
            return new ProjectModel(in);
        }

        @Override
        public ProjectModel[] newArray(int size) {
            return new ProjectModel[size];
        }
    };
}
