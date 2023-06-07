package com.ph03nixc0d3rs.ph03nixc0d3rs.network;


import com.ph03nixc0d3rs.ph03nixc0d3rs.models.APIResponse;
import com.ph03nixc0d3rs.ph03nixc0d3rs.models.LoginInput;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiInterface {


    /**
     @<Method>("EndPoint")
     Call<Type> methodName(@Body typeParams nameParams);
     **/

    @POST("/api/login")
     Call<APIResponse.Login> loginService(@Body LoginInput data);



    // ADD A HEADER
   /* @Headers({
            "Accept:application/json"
    })
    @GET('/api/test')
    Call<Response> apiWithHeader();*/




}
