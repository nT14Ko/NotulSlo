package com.dasikerol.notul;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class LobbyActivity extends AppCompatActivity {
    TextView main,exp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lobby);
        main = findViewById(R.id.txt_score_lobby);
        exp = findViewById(R.id.txt_exp_lobby);
        exp.setText(String.valueOf(Common.EXP));
        main.setText(String.valueOf(Common.SCORE));
    }

    public void slot1(View view) {
        Intent intent = new Intent(LobbyActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void slot2(View view) {
        Intent intent = new Intent(LobbyActivity.this, SecondActivity.class);
        startActivity(intent);
        finish();    }

    public void slot3(View view) {
        Toast.makeText(this, "Coming soon!", Toast.LENGTH_SHORT).show();
    }
}