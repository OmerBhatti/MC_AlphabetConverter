package com.codefumes.alphabetconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;
import java.util.Locale;
import java.util.Random;

public class TestActivity extends AppCompatActivity {

    int totalMCQs = getRandom(new int[]{10, 15, 20});
    int attempted = 0;
    int right = 0;
    int wrong = 0;
    boolean uppercase = false;
    Random random;

    char selectedCharacter,correctCharacter;

    Button[] options = new Button[3];
    TextView rightTxt,wrongTxt,promptTxt, rightCharacter , progressTxt;

    @Override
    protected void onStart() {
        super.onStart();
        attempted = 0;
        right = 0;
        wrong = 0;

        rightTxt.setText("Right " + Integer.toString(right));
        wrongTxt.setText("Wrong " + Integer.toString(wrong));

        CreateNewMCQ();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        random = new Random();
        options[0]=(findViewById(R.id.option1));
        options[1]=(findViewById(R.id.option2));
        options[2]=(findViewById(R.id.option3));

        rightTxt = findViewById(R.id.rightTxt);
        wrongTxt = findViewById(R.id.wrongTxt);
        promptTxt = findViewById(R.id.prompt);
        rightCharacter = findViewById(R.id.character);
        progressTxt = findViewById(R.id.progress);
    }

    public void validate(View view){
        if(attempted <= totalMCQs) {
            Button clickedOptionBtn = (Button) view;
            selectedCharacter = clickedOptionBtn.getText().charAt(0);
            if (uppercase) {
                if (selectedCharacter == Character.toLowerCase(correctCharacter)) {
                    right += 1;
                    rightTxt.setText("Right " + Integer.toString(right));
                } else {
                    wrong += 1;
                    wrongTxt.setText("Wrong " + Integer.toString(wrong));
                }
            } else {
                if (selectedCharacter == Character.toUpperCase(correctCharacter)) {
                    right += 1;
                    rightTxt.setText("Right " + Integer.toString(right));
                } else {
                    wrong += 1;
                    wrongTxt.setText("Wrong " + Integer.toString(wrong));
                }
            }
            CreateNewMCQ();
        }
    }

    private void CreateNewMCQ(){
        if(attempted < totalMCQs) {
            random = new Random();
            uppercase = getRandomCase();
            correctCharacter = getRandomCharacter(uppercase);
            rightCharacter.setText(Character.toString(correctCharacter));
            //reset button options
            for (Button option : options) {
                //put opposite case characters in button
                option.setText(Character.toString(getRandomCharacter(!uppercase)));
            }
            int correctButtonIndex = random.nextInt(3);
            if (uppercase) {
                options[correctButtonIndex].setText(Character.toString(correctCharacter).toLowerCase(Locale.ROOT));
            } else {
                options[correctButtonIndex].setText(Character.toString(correctCharacter).toUpperCase(Locale.ROOT));
            }
            progressTxt.setText(Integer.toString(attempted) + "/" + Integer.toString(totalMCQs));
            attempted++;
        }
        else{
            Intent intent = new Intent(this,ResultActivity.class);
            intent.putExtra("right",right);
            intent.putExtra("wrong",wrong);
            intent.putExtra("total",totalMCQs);
            startActivity(intent);
        }
    }

    private boolean getRandomCase(){
        boolean uppercaseLoc = random.nextBoolean();
        if(uppercaseLoc){
            promptTxt.setText("Choose Lower case of");
        }
        else{
            promptTxt.setText("Choose Upper case of");
        }
        return uppercaseLoc;
    }

    private char getRandomCharacter(boolean uppercaseLoc) {
        char c;
        if(uppercaseLoc == true) {
            c = (char) (random.nextInt(26) + 'A');
        } else {
            c = (char) (random.nextInt(26) + 'a');
        }
        return c;
    }

    public static int getRandom(int[] array) {
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }
}