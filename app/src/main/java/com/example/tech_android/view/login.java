package com.example.tech_android.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.tech_android.R;
import com.example.tech_android.databinding.ActivityLoginBinding;
import com.example.tech_android.viewModels.DemoViewModel;

public class login extends AppCompatActivity {
    ActivityLoginBinding binding;
    DemoViewModel demoViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        binding= DataBindingUtil.setContentView(this,R.layout.activity_login);

        //INITIALIZE VIEW
        this.initView();
    }


    @Override
    protected void onStart() {
        super.onStart();

        //ALL EVENTS
        events();
    }

    private void initView(){
        //HIDE ACTION BAR
        try{
            this.getSupportActionBar().hide();
        }
        catch (Exception e){
            Log.e("Action bar : ",e.getMessage());
        }

        //INITIALIZE VIEWMODEL
      //  this.demoViewModel=new DemoViewModel();
        this.demoViewModel=new ViewModelProvider(this).get(DemoViewModel.class);


        //INIT TEXT
        this.demoViewModel.getToken().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                binding.status.setText(s);
            }
        });
    }

    private void events(){
        this.binding.login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(binding.email.getText().toString().trim()) ||
                        TextUtils.isEmpty(binding.password.getText().toString().trim())){
                    Toast.makeText(login.this, "Veuillez remplir correctement tous les champs!", Toast.LENGTH_SHORT).show();
                    return;
                }

                String _email=binding.email.getText().toString().trim();
                String _password=binding.password.getText().toString().trim();

                demoViewModel.login(_email,_password);

            }
        });
    }


}