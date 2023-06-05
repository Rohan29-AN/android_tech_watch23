package com.example.tech_android.network;

import com.example.tech_android.models.APIResponse;
import com.example.tech_android.models.LoginInput;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiInterface {


    /**
     @<Method>("EndPoint")
     Call<Type> methodName(@Body typeParams nameParams);
     **/

    @POST("/api/login")
     Call<APIResponse.Login> loginService(@Body LoginInput data);
}
