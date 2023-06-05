package com.ph03nixc0d3rs.ph03nixc0d3rs.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.ph03nixc0d3rs.R;
import com.ph03nixc0d3rs.databinding.ActivitySplashBinding;

public class splash extends AppCompatActivity {
    ActivitySplashBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_splash);

        initView();
    }

    private void initView(){
        this.getSupportActionBar().hide();

        this.binding.start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(splash.this,login.class);
                startActivity(intent);
            }
        });
    }
}