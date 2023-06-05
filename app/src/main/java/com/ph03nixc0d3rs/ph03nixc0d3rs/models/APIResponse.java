package com.ph03nixc0d3rs.ph03nixc0d3rs.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class APIResponse {

    public class Login{

        @SerializedName("token")
        @Expose
        private String token;

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

    }
}
