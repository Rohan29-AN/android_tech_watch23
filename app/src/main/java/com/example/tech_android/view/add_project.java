package com.example.tech_android.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.tech_android.R;
import com.example.tech_android.databinding.ActivityAddProjectBinding;

public class add_project extends AppCompatActivity {
    private ActivityAddProjectBinding binding;
    private String _languageSelected;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       binding= DataBindingUtil.setContentView(this,R.layout.activity_add_project);
       initView();
    }

    @Override
    protected void onStart() {
        super.onStart();
        onClick();
    }

    private void initView(){


        //INITIALIZE SPINNER
        String[] languages={"French","English","Malagasy","Hindi"};
        initSpinner(languages);


    }

    private void  initSpinner(String[] data){
        ArrayAdapter<String> spinnerAdapter=new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,data);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.language.setAdapter(spinnerAdapter);
    }

    private void onClick(){
            binding.add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(add_project.this, "Hello", Toast.LENGTH_SHORT).show();
                }
            });


            binding.language.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    _languageSelected=adapterView.getItemAtPosition(i).toString();
                    Toast.makeText(add_project.this, "Language = "+_languageSelected, Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });
    }
}