package com.example.myfirstapp;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;

public class Popup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup);

        int tulos = getIntent().getIntExtra("Tulos", 1);
        TextView tv = (TextView) findViewById(R.id.tulosText);
        if (tulos == 1) {
            tv.setText("Hävisit");
        } else {
            tv.setText("Voitit");
        }

        DisplayMetrics displaym = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaym);
        int width = displaym.widthPixels;
        int height = displaym.heightPixels;

        getWindow().setLayout((int) (width * 0.7), (int) (height * 0.6));
    }

    public void returnToMenu(View view) {
        finish();
    }

}
