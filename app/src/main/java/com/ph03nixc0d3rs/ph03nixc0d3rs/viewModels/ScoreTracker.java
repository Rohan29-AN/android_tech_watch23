package com.ph03nixc0d3rs.ph03nixc0d3rs.viewModels;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.ph03nixc0d3rs.R;
import com.ph03nixc0d3rs.databinding.ActivityScoreTrackerBinding;


public class ScoreTracker extends AppCompatActivity {
    private int score=0;
    private ActivityScoreTrackerBinding binding;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_score_tracker);

        binding= DataBindingUtil.setContentView(this, R.layout.activity_score_tracker);
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
                binding.score.setText(String.valueOf(score));
            }
        });

        binding.remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score=(score-1) >0 ? (score-1):0;
                binding.score.setText(String.valueOf(score));
            }
        });
    }
}