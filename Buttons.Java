package com.example.fragments;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        String[] letters = new String[] {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","å","ä","ö"};
        LinearLayout layout2 = (LinearLayout) findViewById(R.id.button_layout2);
        LinearLayout layout3 = (LinearLayout) findViewById(R.id.button_layout3);
        LinearLayout layout4 = (LinearLayout) findViewById(R.id.button_layout4);
        LinearLayout layout5 = (LinearLayout) findViewById(R.id.button_layout5);
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        int screenWidth = metrics.widthPixels / 9;
        for (int i = 0; i < 29; i++) {
            Button btn = new Button(this);
            btn.setLayoutParams(new LinearLayout.LayoutParams(screenWidth, LinearLayout.LayoutParams.WRAP_CONTENT));
            btn.setId(i);
            btn.getBackground().setAlpha(20);
            btn.setText(letters[i]);
            btn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    buttonClick(v);
                } });

            if (i <= 7) {
                layout2.addView(btn);
            } else if (i > 7 && i <= 15) {
                layout3.addView(btn);
            } else if (i > 15 && i <= 23){
                layout4.addView(btn);
            } else {
                layout5.addView(btn);
            }
        }
    }

    public void buttonClick(View v) {
        Button btn = (Button) findViewById(v.getId());
        //tv.append(btn.getText().toString());
        btn.setEnabled(false);
        btn.setBackgroundColor(Color.TRANSPARENT);

    }
}
