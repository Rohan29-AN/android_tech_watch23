package com.ph03nixc0d3rs.ph03nixc0d3rs.network;



import com.ph03nixc0d3rs.ph03nixc0d3rs.utils.constant;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientInstance {

    public static Retrofit retrofit=null;

    public static Retrofit getClientInstance(){
        if(retrofit==null){
            retrofit=new Retrofit.Builder().baseUrl(constant.OTHER_BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
