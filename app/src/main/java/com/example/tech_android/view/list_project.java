package com.example.tech_android.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.tech_android.R;
import com.example.tech_android.adapter.ProjectAdapter;
import com.example.tech_android.databinding.ActivityListProjectBinding;
import com.example.tech_android.viewModels.ProjectViewModel;

import java.util.concurrent.ExecutionException;

public class list_project extends AppCompatActivity {
    private ActivityListProjectBinding binding;
    private ProjectViewModel projectViewModel;
    private ProjectAdapter projectAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_list_project);

        this.binding= DataBindingUtil.setContentView(this,R.layout.activity_list_project);

        //INITVIEW
        initView();
    }

    private void initView(){

        //VIEW MODEL
        this.projectViewModel= ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(ProjectViewModel.class);
        //  this.projectViewModel=new ViewModelProvider(this).get(ProjectViewModel.class);

        //INITIALIZE RECYCLERVIEW
        this.binding.listProject.setLayoutManager(new LinearLayoutManager(this));


        this.projectAdapter=new ProjectAdapter();

        this.binding.listProject.setAdapter(this.projectAdapter);

        try {
            //Get all projects
            System.out.println("Number of project in the DB : "+this.projectViewModel.getListProject().size());
            this.projectAdapter.setProjects(this.projectViewModel.getListProject());
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }



}