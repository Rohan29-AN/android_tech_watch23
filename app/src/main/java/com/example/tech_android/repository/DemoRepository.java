package com.example.tech_android.repository;

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
