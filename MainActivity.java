package com.example.myfirstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    private SeekBar seekBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seekBar = (SeekBar) findViewById(R.id.seekBar2);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChangedValue = 0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressChangedValue = progress + 5;
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //TODO
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, "Valittu sanan pituus: " + progressChangedValue, Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void startGame(View view) {
        Intent intent = new Intent(this,GameActivity.class);
        String message = Integer.toString(seekBar.getProgress() + 5);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
    public void exitApp(View view) {
        finish();
        System.exit(0);
    }
}
