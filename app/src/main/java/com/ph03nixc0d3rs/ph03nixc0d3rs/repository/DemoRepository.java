package com.ph03nixc0d3rs.ph03nixc0d3rs.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class DemoRepository {

    private MutableLiveData<String> demoString=new MutableLiveData<>();


    public MutableLiveData<String> getString(){
        setString();
        MutableLiveData<String> uptatedString=demoString;
        return uptatedString;

    }


    private void setString(){
        demoString.postValue("Updated string");
    }

}
