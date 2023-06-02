package com.example.tech_android.viewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tech_android.repository.DemoRepository;
import com.example.tech_android.view.MainActivity;

public class DemoViewModel extends ViewModel {

    private MutableLiveData<String> demoString;

    public void init(){
        if(demoString!=null){;
            return;
        }
        else{
            DemoRepository demoRepository=new DemoRepository();
            demoString=demoRepository.getString();
        }
    }


    public LiveData<String> getDemoString(){
        return demoString;
    }

}
