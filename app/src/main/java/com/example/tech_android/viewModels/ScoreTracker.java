package com.example.tech_android.viewModels;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.example.tech_android.R;
import com.example.tech_android.databinding.ActivityScoreTrackerBinding;

public class ScoreTracker extends AppCompatActivity {
    private int score=0;
    private ActivityScoreTrackerBinding binding;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_score_tracker);

        binding= DataBindingUtil.setContentView(this,R.layout.activity_score_tracker);
    }

    @Override
    protected void onStart() {
        super.onStart();
        changeScore();
    }

    private void changeScore(){
        binding.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ++score;
                binding.score.setText(score+"");
            }
        });

        binding.remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score=(score-1) >0 ? (score-1):0;
                binding.score.setText(score+"");
            }
        });
    }
}