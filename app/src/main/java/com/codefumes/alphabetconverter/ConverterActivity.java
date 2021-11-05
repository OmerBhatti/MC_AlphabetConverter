package com.codefumes.alphabetconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Paint;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Console;
import java.util.ArrayList;
import java.util.Locale;

public class ConverterActivity extends AppCompatActivity {

    boolean Capital = true;
    TextView to;
    TextView from;
    TextView description;
    Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        to = findViewById(R.id.to);
        from = findViewById(R.id.from);
        description = findViewById(R.id.description);
    }

    public void buttonClicked(View v) {
        Button button = (Button) v;
        String buttonText = button.getText().toString();
        if (Capital) {
            from.setText(buttonText);
            to.setText(buttonText.toLowerCase(Locale.ROOT));

            // setting description and toast
            String formatted = from.getText()+" in lower case is " + to.getText();
            description.setText(formatted);
            if(toast != null){
                toast.cancel();
            }
            toast = Toast.makeText(this,formatted,Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.BOTTOM,0,0);
            toast.show();

        } else {
            from.setText(buttonText);
            to.setText(buttonText.toUpperCase(Locale.ROOT));

            // setting description and toast
            String formatted = from.getText()+" in upper case is " + to.getText();
            description.setText(formatted);
            if(toast != null){
                toast.cancel();
            }
            toast = Toast.makeText(this,formatted,Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.BOTTOM,0,0);
            toast.show();
        }
    }

    public void ToggleMode(View v) {
        Capital = !Capital;
        if (Capital) {
            from.setText("A");
            to.setText("a");
            description.setText("A in lower case is a");
            //Todo change all buttons to Upper Case
            ArrayList<View> buttons = findViewById(R.id.root).getTouchables();
            for (View buttonView : buttons) {
                Button btn = (Button) buttonView;
                String btnText = btn.getText().toString();
                if(btnText != "Switch"){
                    btn.setText(btnText.toUpperCase(Locale.ROOT));
                }
            }

        } else {
            from.setText("a");
            to.setText("A");
            description.setText("a in upper case is A");
            //Todo change all buttons to Lower case
            ArrayList<View> buttons = findViewById(R.id.root).getTouchables();
            for (View buttonView : buttons) {
                Button btn = (Button) buttonView;
                String btnText = btn.getText().toString();
                if(btnText != "Switch"){
                    btn.setText(btnText.toLowerCase(Locale.ROOT));
                }
            }
        }
    }
}