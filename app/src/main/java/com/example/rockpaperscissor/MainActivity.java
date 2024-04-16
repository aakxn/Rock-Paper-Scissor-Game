package com.example.rockpaperscissor;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity{
    private static final String TAG = "MainActivity";
    TextView userSelectionTextView,compSelectionTextView,wonLostTieTextView,scoreTextView;
    int userScore = 0 , compScore=0;
    Random random;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userSelectionTextView = findViewById(R.id.userSelectionTextView);
        compSelectionTextView = findViewById(R.id.compSelectionTextView);
        wonLostTieTextView = findViewById(  R.id.winLostTieTextView);
        scoreTextView = findViewById(R.id.scoreTextView);

        userSelectionTextView.setText("");
        compSelectionTextView.setText("");
        wonLostTieTextView.setText("");

        random = new Random();


    }

    public void resetButton(View view) {
        wonLostTieTextView.setText("");
        userSelectionTextView.setText("");
        compSelectionTextView.setText("");
        userScore= 0;
        compScore= 0;
        setScoreTextView(userScore,compScore);
    }

    public void rpsButtonSelected(View view) {
        int userSelection = Integer.parseInt(view.getTag().toString());
        Log.i(TAG, "rpsButtonSelected: " + userSelection);
        matchGame(userSelection);
    }
    private void matchGame(int userSelection)
    {
        int low = 1;
        int high = 3;
        int compSelection = random.nextInt(high) + low;
        if (userSelection == compSelection) {

            wonLostTieTextView.setText("Tie");
        } else if ((userSelection - compSelection) % 3 == 1) {
            userScore++;
            wonLostTieTextView.setText("Yay, You Won!");

        } else {
            compScore++;
            wonLostTieTextView.setText("oops you lost");
        }
        switch (userSelection){
            case 1:
                userSelectionTextView.setText("Rock");
                break;
            case 2:
                userSelectionTextView.setText("Paper");
                break;
            case 3:
                userSelectionTextView.setText("Scissor");
                break;
        }

        switch (compSelection){
            case 1:
                compSelectionTextView.setText("Rock");
                break;
            case 2:
                compSelectionTextView.setText("Paper");
                break;
            case 3:
                compSelectionTextView.setText("Scissor");
                break;
        }
        setScoreTextView(userScore,compScore);
    }
    private void setScoreTextView( int userScore,int compScore) {
        scoreTextView.setText(String.valueOf(userScore) + ":" + String.valueOf(compScore));
    }
}

