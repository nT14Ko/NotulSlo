package com.dasikerol.notul;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class LobbyActivity extends AppCompatActivity {
    TextView main,exp;
    SharedPreferences preferences;
    int score,ex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lobby);
        main = findViewById(R.id.txt_score_lobby);
        exp = findViewById(R.id.txt_exp_lobby);
        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        score = preferences.getInt("score", 1000);
        ex = preferences.getInt("exp", 0);
        exp.setText(String.valueOf(ex));
        main.setText(String.valueOf(score));
    }

    public void slot1(View view) {
        Intent intent = new Intent(LobbyActivity.this, SecondActivity.class);
        startActivity(intent);
        finish();
    }

    public void slot2(View view) {
        Intent intent = new Intent(LobbyActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void slot3(View view) {
        Toast.makeText(this, "Coming soon!", Toast.LENGTH_SHORT).show();
    }
}