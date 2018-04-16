package com.example.myfirstapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class GameActivity extends AppCompatActivity {
    private static final String TAG = GameActivity.class.getSimpleName();
    private TextView tview;
    private int wordlenght;
    private Dictionary dictionary;
    private Guesses guesses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_game);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        tview = findViewById(R.id.chosenWord);
        wordlenght = Integer.parseInt(message);

        createButtons();
        FileReader fileReader = new FileReader(this);
        List<String> words = fileReader.readFile("sanoja.txt");
        Log.d("lista", String.valueOf(words.isEmpty()));
        dictionary = new Dictionary(wordlenght);
        dictionary.createList(words);
        dictionary.chooseWord();
        String word = dictionary.getWord();
        guesses = new Guesses(word, 8);
        showGuessNum();
        drawWord();
    }

    private void createButtons() {
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
        TextView tv = (TextView) findViewById(R.id.textview4);
        String guessedLetter = btn.getText().toString();
        if (!guesses.checkGuessed(guessedLetter)) { guesses.takeAwayGuess(); }
        if (guesses.gameEnded()) {
            disableButtons(v);
            Intent popup = new Intent(this, Popup.class);
            popup.putExtra("Tulos", 1);
            startActivity(popup);
            finish();
        }
        if (guesses.gameWon()) {
            disableButtons(v);
            Intent popup = new Intent(this, Popup.class);
            popup.putExtra("Tulos", 2);
            startActivity(popup);

        }
        drawWord();
        showGuessNum();
        btn.setEnabled(false);
        btn.setBackgroundColor(Color.TRANSPARENT);

    }

    public void drawWord() {
        tview.setText("");
        String[] revealedWord = guesses.getRevealedWord();
        for (int i = 0; i < revealedWord.length; i++) {
            if (revealedWord[i] == null) {
                tview.append("_ ");
            } else {
                tview.append(revealedWord[i] + " ");
            }
        }
    }

    public void disableButtons(View v) {
        for (int i = 0; i < 29; i++) {
            Button btn = (Button) findViewById(i);
            btn.setEnabled(false);
        }
    }

    public void showGuessNum() {
        TextView tv = (TextView) findViewById(R.id.textview2);
        tv.setText("Arvausten määrä: " + guesses.getNumOfGuesses());
    }
}
