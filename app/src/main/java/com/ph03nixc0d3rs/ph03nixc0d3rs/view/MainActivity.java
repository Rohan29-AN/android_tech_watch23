package com.ph03nixc0d3rs.ph03nixc0d3rs.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.TextView;


import com.ph03nixc0d3rs.R;
import com.ph03nixc0d3rs.ph03nixc0d3rs.viewModels.DemoViewModel;


public class MainActivity extends AppCompatActivity {
    private TextView demoText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }


    private void initView(){
        this.demoText=(TextView) findViewById(R.id.demoText);
        DemoViewModel demoViewModel= new ViewModelProvider(this).get(DemoViewModel.class);
        demoViewModel.init();


        demoViewModel.getDemoString().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                demoText.setText(s);
            }
        });

    }
}