package com.codefumes.alphabetconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;
import java.util.Random;

public class TestActivity extends AppCompatActivity {

    int totalMCQs = 10;
    int attempted = 0;
    int right = 0;
    int wrong = 0;
    boolean alphabetCase = false;
    Random random;

    char selectedCharacter,correctCharacter;

    List<Button> options;
    TextView rightTxt,wrongTxt,promptTxt, rightCharacter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        random = new Random();
        options.add(findViewById(R.id.option1));
        options.add(findViewById(R.id.option2));
        options.add(findViewById(R.id.option3));

        rightTxt =findViewById(R.id.rightTxt);
        wrongTxt =findViewById(R.id.wrongTxt);
        promptTxt =findViewById(R.id.prompt);
        rightCharacter = findViewById(R.id.character);

        newCombination();
    }

    private boolean getRandomCase(){
        return random.nextBoolean();
    }

    private char getRandomCharacter(boolean uppercase){
        if(uppercase){
            return (char)(random.nextInt(26) + 'A');
        }
        else{
            return (char)(random.nextInt(26) + 'a');
        }
    }

    private void newCombination(){
        if(attempted <= totalMCQs){
            alphabetCase = getRandomCase();
            rightCharacter.setText(getRandomCharacter(alphabetCase));
        }
    }

}