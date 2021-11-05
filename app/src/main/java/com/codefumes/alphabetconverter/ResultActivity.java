package com.codefumes.alphabetconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView wrongTxt,rightTxt;
    int wrong,right,total;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        rightTxt = findViewById(R.id.right_Res);
        wrongTxt = findViewById(R.id.wrong_Res);

        Intent intent = getIntent();
        wrong = intent.getIntExtra("wrong",0);
        right = intent.getIntExtra("right",0);
        total = intent.getIntExtra("total",0);

        rightTxt.setText(Integer.toString(right));
        wrongTxt.setText(Integer.toString(wrong));
    }
}