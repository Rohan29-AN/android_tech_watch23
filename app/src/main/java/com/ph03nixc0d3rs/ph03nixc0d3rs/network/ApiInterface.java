package com.ph03nixc0d3rs.ph03nixc0d3rs.network;


import com.ph03nixc0d3rs.ph03nixc0d3rs.models.APIResponse;
import com.ph03nixc0d3rs.ph03nixc0d3rs.models.LoginInput;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

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

    //GET WITH PARAMS
    @GET("/api/getUser/{id}")
    Call<Response> apiGetWithParams(@Path("id") int id);

    //QUERY PARAMETERS IN URL
   // @GET("/api/getUserList?sort=desc")
   // This query is equivalent to this

    @GET("/api/getUserList2")
    Call<Response> apiGetWithQueryinParams(@Query("sort") String sort);





}
