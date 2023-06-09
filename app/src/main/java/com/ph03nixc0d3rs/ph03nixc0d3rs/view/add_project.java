package com.ph03nixc0d3rs.ph03nixc0d3rs.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.ph03nixc0d3rs.R;
import com.ph03nixc0d3rs.databinding.ActivityAddProjectBinding;
import com.ph03nixc0d3rs.ph03nixc0d3rs.entity.ProjectModel;
import com.ph03nixc0d3rs.ph03nixc0d3rs.viewModels.ProjectViewModel;


public class add_project extends AppCompatActivity {
    private ActivityAddProjectBinding binding;
    private String _languageSelected,_title;
    private int _issues,_watcher;
    private String[] languages={"JAVA","SWIFT","DART","C++","C","C#"};
    private ProjectViewModel projectViewModel;
    private ProjectModel projectModel;
    private boolean isEdit=false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       binding= DataBindingUtil.setContentView(this, R.layout.activity_add_project);
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


        //RETRIEVE DATA FROM THE PREVIOUS ACTIVITY
       if(getIntent().hasExtra("project")){
            this.projectModel=getIntent().getParcelableExtra("project");
            binding.title.setText(this.projectModel._TITLE);
            binding.watcher.setText(String.valueOf(this.projectModel._WATCHER));
            binding.issues.setText(String.valueOf(this.projectModel._ISSUES));
            this.isEdit=true;

           int selectedIndex = getPositionByValue(binding.language, this.projectModel._LANGUAGE);
           binding.language.setSelection(selectedIndex);
       }

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

//                    System.out.println("TITLE = "+_title);
//                    System.out.println("WATCHER = "+_watcher);
//                    System.out.println("ISSUES = "+_issues);
//                    System.out.println("LANGUAGE = "+_languageSelected);

                    if(_title.length()==0 || _watcher==-1 ||
                           _issues==-1){
                        Toast.makeText(add_project.this, "Veuillez remplir correctement tous les champs!", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    if(!isEdit){
                        projectModel=new ProjectModel();
                        projectModel._TITLE=_title;
                        projectModel._LANGUAGE=_languageSelected;
                        projectModel._WATCHER=_watcher;
                        projectModel._ISSUES=_issues;
                        projectViewModel.insertProject(projectModel);
                        Toast.makeText(add_project.this, "Insertion OK", Toast.LENGTH_SHORT).show();

                    }
                    else{
                        projectModel._TITLE=_title;
                        projectModel._LANGUAGE=_languageSelected;
                        projectModel._WATCHER=_watcher;
                        projectModel._ISSUES=_issues;
                        projectViewModel.updateProject(projectModel);
                        Toast.makeText(add_project.this, "Update OK", Toast.LENGTH_SHORT).show();

                    }
                    finish();

                }
            });


            binding.language.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    _languageSelected=adapterView.getItemAtPosition(i).toString();
                  //  Toast.makeText(add_project.this, "Language = "+_languageSelected, Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                    _languageSelected=adapterView.getItemAtPosition(0).toString();
                   // Toast.makeText(add_project.this, "Default: "+_languageSelected, Toast.LENGTH_SHORT).show();
                }
            });
    }

    @Override
    public void onBackPressed() {
      //  super.onBackPressed();
        finish();
    }

    private int getPositionByValue(Spinner spinner, String value) {
        ArrayAdapter<String> adapter = (ArrayAdapter<String>) spinner.getAdapter();
        int count = adapter.getCount();

        for (int i = 0; i < count; i++) {
            if (adapter.getItem(i).equals(value)) {
                return i;
            }
        }

        return 0; // Default position if value not found
    }
}