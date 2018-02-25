package com.amar.happybirthday;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    int scoreA;
    int scoreB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scoreA = 0;
        scoreB = 0;
    }

    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.pointsA);
        scoreView.setText(String.valueOf(score));
    }

    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.pointsB);
        scoreView.setText(String.valueOf(score));
    }

    public void score3PointsA(View view) {
        scoreA += 3;
        displayForTeamA(scoreA);
    }

    public void score2PointsA(View view) {
        scoreA += 2;
        displayForTeamA(scoreA);
    }

    public void freeThrowA(View view) {
        scoreA += 1;
        displayForTeamA(scoreA);
    }

    public void score3PointsB(View view) {
        scoreB += 3;
        displayForTeamB(scoreB);
    }

    public void score2PointsB(View view) {
        scoreB += 2;
        displayForTeamB(scoreB);
    }

    public void freeThrowB(View view) {
        scoreB += 1;
        displayForTeamB(scoreB);
    }

    public void resetScore(View view) {
        scoreA = 0;
        scoreB = 0;
        displayForTeamA(scoreA);
        displayForTeamB(scoreB);
    }

}
