package com.example.scoreboard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int scoreTemA = 0;
    int scoreTemB = 0;
    TextView scoreView;
    TextView scoreVie;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreVie = (TextView) findViewById(R.id.team_b_score);

        if (savedInstanceState != null) {
            String s = savedInstanceState.getString("Abhi");
            String k =savedInstanceState.getString("abhishek");
            scoreTemA = Integer.parseInt(s);
            scoreTemB = Integer.parseInt(k);
            scoreView.setText("" + scoreTemA);
            scoreVie.setText("" + scoreTemB);
        }
    }

    public void teamAOneScore(View view) {

        scoreTemA = scoreTemA + 1;
        displayForTeamA(scoreTemA);
    }




    public void teamATwoScore(View view) {
        scoreTemA = scoreTemA + 2;
        displayForTeamA(scoreTemA);
    }

    public void teamAThreeScore(View view) {
        scoreTemA = scoreTemA + 3;
        displayForTeamA(scoreTemA);
    }

    private void displayForTeamA(int score) {

        scoreView.setText("" + score);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("Abhi",scoreView.getText().toString());
        outState.putString("abhishek", scoreVie.getText().toString());
    }

    public void teamBOneScore(View view) {
        scoreTemB = scoreTemB + 1;
        displayForTeamB(scoreTemB);
    }

    public void teamBTwoScore(View view) {
        scoreTemB = scoreTemB + 2;
        displayForTeamB(scoreTemB);
    }

    public void teamBThreeScore(View view) {
        scoreTemB = scoreTemB + 3;
        displayForTeamB(scoreTemB);
    }

    private void displayForTeamB(int score) {

        scoreVie.setText(String.valueOf(score));
    }

    public void resetButton(View view) {
        scoreTemA = 0;
        scoreTemB = 0;
        displayForTeamA(0);
        displayForTeamB(0);

    }
}