package com.ph03nixc0d3rs.ph03nixc0d3rs.repository;



import com.ph03nixc0d3rs.ph03nixc0d3rs.models.APIResponse;
import com.ph03nixc0d3rs.ph03nixc0d3rs.models.LoginInput;
import com.ph03nixc0d3rs.ph03nixc0d3rs.network.ApiInterface;
import com.ph03nixc0d3rs.ph03nixc0d3rs.network.RetrofitClientInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainRepository {

    public interface ILoginResponse{
        void onResponse(APIResponse.Login loginResponse);

        void onFailure(Throwable error);
    }


    public void  loginRemote(LoginInput loginInput, ILoginResponse  loginResponse ){
        ApiInterface apiInterface= RetrofitClientInstance.getClientInstance().create(ApiInterface.class);

        Call<APIResponse.Login> call=apiInterface.loginService(loginInput);

        call.enqueue(new Callback<APIResponse.Login>() {
            @Override
            public void onResponse(Call<APIResponse.Login> call, Response<APIResponse.Login> response) {
                if(response.isSuccessful()){
                    loginResponse.onResponse(response.body());
                }
                else{
                    loginResponse.onFailure(new Throwable(response.message()));
                }
            }

            @Override
            public void onFailure(Call<APIResponse.Login> call, Throwable t) {
                loginResponse.onFailure(t);
            }
        });
    }
}
