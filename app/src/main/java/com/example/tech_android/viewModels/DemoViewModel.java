package com.example.tech_android.viewModels;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tech_android.models.APIResponse;
import com.example.tech_android.models.LoginInput;
import com.example.tech_android.repository.DemoRepository;
import com.example.tech_android.repository.MainRepository;
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


    //RETROFIT

    private  MutableLiveData<String> mLoginResult;
    private MainRepository mainRepository;


    public DemoViewModel(){
            mLoginResult=new MutableLiveData<>();
            mLoginResult.postValue("Not logged in");
            this.mainRepository=new MainRepository();
        System.out.println("INSTANCATION OK");
    }


    public void login(String email,String password){
        mLoginResult.postValue("Checking...");

        //Login input
        LoginInput loginInput=new LoginInput();
        loginInput.setEmail(email);
        loginInput.setPassword(password);


        this.mainRepository.loginRemote(loginInput, new MainRepository.ILoginResponse() {
            @Override
            public void onResponse(APIResponse.Login loginResponse) {
                Log.e("API RESPONSE",loginResponse.getToken());
                mLoginResult.postValue(loginResponse.getToken());
            }

            @Override
            public void onFailure(Throwable error) {
                Log.e("LOGIN FAILED",error.getMessage());
                mLoginResult.postValue("Login failed:"+ error.getMessage());
            }
        });
    }


    public LiveData<String> getToken(){
        return  mLoginResult;
    }





}
