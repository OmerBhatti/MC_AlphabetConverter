package com.codefumes.alphabetconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class ResultActivity extends AppCompatActivity {

    TextView wrongTxt,rightTxt,remarkTxt;
    int wrong,right,total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        rightTxt = findViewById(R.id.right_Res);
        wrongTxt = findViewById(R.id.wrong_Res);
        remarkTxt = findViewById(R.id.remarks);

        Intent intent = getIntent();
        wrong = intent.getIntExtra("wrong",0);
        right = intent.getIntExtra("right",0);
        total = intent.getIntExtra("total",0);

        rightTxt.setText(Integer.toString(right));
        wrongTxt.setText(Integer.toString(wrong));

        String remark = "";
        if(right>=0 && right<=5){
            remark = "Practice More!";
        }
        else if(right>5 && right<=8){
            remark = "Average :)";
        }
        else if(right>9 && right<=total){
            remark = "Excellent !!";
        }
        remarkTxt.setText(remark);

    }

    public void shareResult(View view){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT,"I took a test on Alphabet Converter App.\nHere is the result:\n  Right = "+Integer.toString(right)+"\n  Wrong = "+Integer.toString(wrong));
        startActivity(intent);
    }

    public void goBacktoPractice(View v){
        Intent intent = new Intent(this, PracticeActivity.class);
        startActivity(intent);
    }

}