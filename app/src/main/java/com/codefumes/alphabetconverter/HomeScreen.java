package com.codefumes.alphabetconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class HomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
    }

    public void startApp(View v){
        Intent intent = new Intent(this, PracticeActivity.class);
        startActivity(intent);
    }

    public void openRepo(View v){
        Uri uri = Uri.parse("https://github.com/OmerBhatti/MC_AlphabetConverter");
        Intent i = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(i);
    }
}