package com.example.tech_android.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.tech_android.R;
import com.example.tech_android.databinding.ActivityAddProjectBinding;
import com.example.tech_android.entity.ProjectModel;
import com.example.tech_android.viewModels.ProjectViewModel;

import org.w3c.dom.Text;

public class add_project extends AppCompatActivity {
    private ActivityAddProjectBinding binding;
    private String _languageSelected,_title;
    private int _issues,_watcher;
    private String[] languages={"JAVA","SWIFT","DART","C++","C","C#"};
    private ProjectViewModel projectViewModel;


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

        initSpinner(languages);

        //INITIALIZE VIEW MODEL
        this.projectViewModel= new ViewModelProvider(this).get(ProjectViewModel.class);

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

                    _title=binding.title.getText().toString().trim();
                    _watcher=!TextUtils.isEmpty(binding.watcher.getText().toString())?Integer.parseInt(binding.watcher.getText().toString()):-1;
                    _issues=!TextUtils.isEmpty(binding.issues.getText().toString())?Integer.parseInt(binding.issues.getText().toString()):-1;

                    System.out.println("TITLE = "+_title);
                    System.out.println("WATCHER = "+_watcher);
                    System.out.println("ISSUES = "+_issues);
                    System.out.println("LANGUAGE = "+_languageSelected);

                    if(_title.length()==0 || _watcher==-1 ||
                           _issues==-1){
                        Toast.makeText(add_project.this, "Veuillez remplir correctement tous les champs!", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    ProjectModel projectModel=new ProjectModel();
                    projectModel._TITLE=_title;
                    projectModel._LANGUAGE=_languageSelected;
                    projectModel._WATCHER=_watcher;
                    projectModel._ISSUES=_issues;

                    projectViewModel.insertProject(projectModel);
                    Toast.makeText(add_project.this, "Insertion OK", Toast.LENGTH_SHORT).show();
                    finish();
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
                    _languageSelected=adapterView.getItemAtPosition(0).toString();
                    Toast.makeText(add_project.this, "Default: "+_languageSelected, Toast.LENGTH_SHORT).show();
                }
            });
    }

    @Override
    public void onBackPressed() {
      //  super.onBackPressed();
        finish();
    }
}