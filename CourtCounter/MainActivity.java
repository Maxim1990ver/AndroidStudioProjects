package com.example.android.courtcounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    int scoreTeamA = 0;
    int scoreTeamB = 0;
    final int ONE_POINT = 1;
    final int TWO_POINTS = 2;
    final int THREE_POINTS = 3;

    private void displayForTeamA(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.team_a_score);
        quantityTextView.setText("" + number);
    }
    public void teamAAddOne(View view) {
        scoreTeamA += ONE_POINT;
        displayForTeamA(scoreTeamA);
    }
    public void teamAAddTwo(View view) {
        scoreTeamA += TWO_POINTS;
        displayForTeamA(scoreTeamA);
    }
    public void teamAAddThree(View view) {
        scoreTeamA += THREE_POINTS;
        displayForTeamA(scoreTeamA);
    }

    private void displayForTeamB(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.team_b_score);
        quantityTextView.setText("" + number);
    }
    public void teamBAddOne(View view) {
        scoreTeamB += ONE_POINT;
        displayForTeamB(scoreTeamB);
    }
    public void teamBAddTwo(View view) {
        scoreTeamB += TWO_POINTS;
        displayForTeamB(scoreTeamB);
    }
    public void teamBAddThree(View view) {
        scoreTeamB += THREE_POINTS;
        displayForTeamB(scoreTeamB);
    }
    public void reset(View view) {
        scoreTeamA = 0;
        scoreTeamB = 0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
    }
}
