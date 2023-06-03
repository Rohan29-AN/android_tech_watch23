package com.example.tech_android.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.tech_android.R;
import com.example.tech_android.adapter.ProjectAdapter;
import com.example.tech_android.databinding.ActivityListProjectBinding;
import com.example.tech_android.entity.ProjectModel;
import com.example.tech_android.event.OnClickItemInterface;
import com.example.tech_android.viewModels.ProjectViewModel;

import java.util.List;

public class list_project extends AppCompatActivity implements OnClickItemInterface {
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


    @Override
    protected void onStart() {
        super.onStart();
        //EVENT
        eventUI();
    }



    private void initView(){

        //VIEW MODEL
        this.projectViewModel= ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(ProjectViewModel.class);
        //  this.projectViewModel=new ViewModelProvider(this).get(ProjectViewModel.class);

        //INITIALIZE RECYCLERVIEW
        this.binding.listProject.setLayoutManager(new LinearLayoutManager(this));


        this.projectAdapter=new ProjectAdapter(this);

        this.binding.listProject.setAdapter(this.projectAdapter);


        //USING FUTURE
       /* try {
            //Get all projects
            System.out.println("Number of project in the DB : "+this.projectViewModel.getListProjectFuture().size());
            this.projectAdapter.setProjects(this.projectViewModel.getListProjectFuture());
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
            */


        //USING LIVE DATA


        this.projectViewModel.getListProjectLive().observe(this, new Observer<List<ProjectModel>>() {
            @Override
            public void onChanged(List<ProjectModel> projectModels) {
                if(projectModels.size()>0){
                    projectAdapter.setProjects(projectModels);
                    binding.dataEmpty.setVisibility(View.GONE);
                    binding.listProject.setVisibility(View.VISIBLE);
                    System.out.println("ATO INDRAY");
                }
                else{
                    binding.dataEmpty.setVisibility(View.VISIBLE);
                    System.out.println("ATOOO");
                }
            }
        });

    }


    private void eventUI(){
            this.binding.addProject.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(list_project.this,add_project.class);
                    startActivity(intent);
                }
            });
    }

    @Override
    public void onClickItem(ProjectModel projectModel, boolean isEdit) {
        if(isEdit){
            //UPDATE
            Intent intent=new Intent(this,add_project.class);
            intent.putExtra("project",projectModel);
            startActivity(intent);
        }
        else{
            //DELETE
            this.projectViewModel.deleteProject(projectModel);
        }
    }
}