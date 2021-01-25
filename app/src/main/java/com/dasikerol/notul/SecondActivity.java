package com.dasikerol.notul;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.dasikerol.notul.ImageViewScrolling.IEventEnd;
import com.dasikerol.notul.ImageViewScrolling.ImageViewScrolling;
import com.dasikerol.notul.ImageViewScrolling.ImageViewScrolling2;

import java.util.Random;

public class SecondActivity extends AppCompatActivity implements IEventEnd  {

    ImageViewScrolling2 image1,image2,image3,image4,image5,image6,image7,image8,image9,image10,image11,image12,image13,image14,image15;
    Button buttonSpin;
    Button buttonAutoSpin;
    TextView txt_score, txt_bet, txt_exp;
    Random random1,random2,random3,random4,random5;
    int one;
    int two;
    int three;
    int four;
    int five;
    Boolean autoSpin;
    Boolean spinEnd;
    Boolean canChange;
    int bet;
    Toast toast;
    SharedPreferences preferences;
    private int score, exp;


    int count_done=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        buttonSpin = findViewById(R.id.b1uttonSpin);
        buttonAutoSpin = findViewById(R.id.b1uttonAutoSpin);
        bet = 50;
        autoSpin = false;
        spinEnd = true;
        canChange = true;
        random1 = new Random();
        random2 = new Random();
        random3 = new Random();
        random4 = new Random();
        random5 = new Random();
        one = randomLine();
        two = randomLine();
        three = randomLine();
        four = randomLine();
        five = randomLine();
        txt_exp = findViewById(R.id.t1xt_exp_main);
        image1 = findViewById(R.id.i1mage1);
        image2 = findViewById(R.id.i1mage2);
        image3 = findViewById(R.id.i1mage3);
        image4 = findViewById(R.id.i1mage4);
        image5 = findViewById(R.id.i1mage5);
        image6 = findViewById(R.id.i1mage6);
        image7 = findViewById(R.id.i1mage7);
        image8 = findViewById(R.id.i1mage8);
        image9 = findViewById(R.id.i1mage9);
        image10 = findViewById(R.id.i1mage10);
        image11 = findViewById(R.id.i1mage11);
        image12 = findViewById(R.id.i1mage12);
        image13 = findViewById(R.id.i1mage13);
        image14 = findViewById(R.id.i1mage14);
        image15 = findViewById(R.id.i1mage15);
        txt_score = findViewById(R.id.t1xt_score_main);
        txt_bet = findViewById(R.id.t1xt_bet);
        image1.setEventEnd(SecondActivity.this);
        image2.setEventEnd(SecondActivity.this);
        image3.setEventEnd(SecondActivity.this);
        image4.setEventEnd(SecondActivity.this);
        image5.setEventEnd(SecondActivity.this);
        image6.setEventEnd(SecondActivity.this);
        image7.setEventEnd(SecondActivity.this);
        image8.setEventEnd(SecondActivity.this);
        image9.setEventEnd(SecondActivity.this);
        image10.setEventEnd(SecondActivity.this);
        image11.setEventEnd(SecondActivity.this);
        image12.setEventEnd(SecondActivity.this);
        image13.setEventEnd(SecondActivity.this);
        image14.setEventEnd(SecondActivity.this);
        image15.setEventEnd(SecondActivity.this);
        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        score = preferences.getInt("score", 1000);
        exp = preferences.getInt("exp", 0);
        toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_SHORT);
        LayoutInflater inflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.toast, null);
        toast.setView(view);
        txt_exp.setText(String.valueOf(exp));
        txt_score.setText(String.valueOf(score));
    }


    @Override
    public void eventEnd(int result, int count) {
        if(count_done<14){
            count_done++;
        } else {
            count_done = 0;
            if (image1.getValue() == image2.getValue() && image2.getValue() == image3.getValue() && image3.getValue() == image4.getValue() && image4.getValue() == image5.getValue()){
//                Toast.makeText(this, "You win SUPER BIG prise", Toast.LENGTH_SHORT).show();
                score += bet * 20;
                exp += bet * 20;
                txt_exp.setText(String.valueOf(exp));
                txt_score.setText(String.valueOf(score));
        preferences.edit().putInt("score", score).apply();
        preferences.edit().putInt("exp", exp).apply();
                image1.anim();
                image2.anim();
                image3.anim();
                image4.anim();
                image5.anim();
            } else if (image1.getValue() == image2.getValue() && image2.getValue() == image3.getValue() && image3.getValue() == image4.getValue() && image4.getValue() != image5.getValue()){
                Toast.makeText(this, "You win prise", Toast.LENGTH_SHORT).show();
                score += bet *10;
                exp += bet * 10;
                txt_exp.setText(String.valueOf(exp));
                txt_score.setText(String.valueOf(score));

        preferences.edit().putInt("score", score).apply();
        preferences.edit().putInt("exp", exp).apply();
                image1.anim();
                image2.anim();
                image3.anim();
                image4.anim();
            } else if (image1.getValue() == image2.getValue() && image2.getValue() == image3.getValue() && image3.getValue() != image4.getValue()) {
                Toast.makeText(this, "You win big prise", Toast.LENGTH_SHORT).show();
                score += bet *2;
                exp += bet * 2;
                txt_exp.setText(String.valueOf(exp));
                txt_score.setText(String.valueOf(score));

        preferences.edit().putInt("score", score).apply();
        preferences.edit().putInt("exp", exp).apply();
                image1.anim();
                image2.anim();
                image3.anim();
            }else if (image1.getValue() == image2.getValue() && image2.getValue() != image3.getValue() ) {
                Toast.makeText(this, "You win small prise", Toast.LENGTH_SHORT).show();
                image1.anim();
                score += bet;
                exp += bet;
                txt_exp.setText(String.valueOf(exp));
                txt_score.setText(String.valueOf(score));

        preferences.edit().putInt("score", score).apply();
        preferences.edit().putInt("exp", exp).apply();
                image1.anim();
                image2.anim();
            }


            if (image6.getValue() == image7.getValue() && image7.getValue() == image8.getValue() && image8.getValue() == image9.getValue() && image9.getValue() == image10.getValue()){
                Toast.makeText(this, "You win SUPER BIG prise", Toast.LENGTH_SHORT).show();
                score += bet * 20;
                exp += bet * 20;
                txt_exp.setText(String.valueOf(exp));
                txt_score.setText(String.valueOf(score));

        preferences.edit().putInt("score", score).apply();
        preferences.edit().putInt("exp", exp).apply();
                image6.anim();
                image7.anim();
                image8.anim();
                image9.anim();
                image10.anim();
            } else if (image6.getValue() == image7.getValue() && image7.getValue() == image8.getValue() && image8.getValue() == image9.getValue() && image9.getValue() != image10.getValue()){
                Toast.makeText(this, "You win BIG prise", Toast.LENGTH_SHORT).show();
                score += bet * 10;
                exp += bet * 10;
                txt_exp.setText(String.valueOf(exp));
                txt_score.setText(String.valueOf(score));

        preferences.edit().putInt("score", score).apply();
        preferences.edit().putInt("exp", exp).apply();
                image6.anim();
                image7.anim();
                image8.anim();
                image9.anim();
            } else if (image6.getValue() == image7.getValue() && image7.getValue() == image8.getValue() && image8.getValue() != image9.getValue()) {
                Toast.makeText(this, "You win big prise", Toast.LENGTH_SHORT).show();
                score += bet * 2;
                exp += bet * 2;
                txt_exp.setText(String.valueOf(exp));
                txt_score.setText(String.valueOf(score));

        preferences.edit().putInt("score", score).apply();
        preferences.edit().putInt("exp", exp).apply();
                image6.anim();
                image7.anim();
                image8.anim();
            }else if (image6.getValue() == image7.getValue() && image7.getValue() != image8.getValue() ) {
                Toast.makeText(this, "You win small prise", Toast.LENGTH_SHORT).show();
                image6.anim();
                score += bet;
                exp += bet;
                txt_exp.setText(String.valueOf(exp));
                txt_score.setText(String.valueOf(score));

        preferences.edit().putInt("score", score).apply();
        preferences.edit().putInt("exp", exp).apply();
                image6.anim();
                image7.anim();
            }


            if (image11.getValue() == image12.getValue() && image12.getValue() == image13.getValue() && image3.getValue() == image14.getValue() && image14.getValue() == image15.getValue()){
                Toast.makeText(this, "You win SUPER BIG prise", Toast.LENGTH_SHORT).show();
                score += bet * 20;
                exp += bet * 20;
                txt_exp.setText(String.valueOf(exp));
                txt_score.setText(String.valueOf(score));

        preferences.edit().putInt("score", score).apply();
        preferences.edit().putInt("exp", exp).apply();
                image11.anim();
                image12.anim();
                image13.anim();
                image14.anim();
                image15.anim();
            } else if (image11.getValue() == image12.getValue() && image12.getValue() == image13.getValue() && image13.getValue() == image14.getValue() && image14.getValue() != image15.getValue()){
                Toast.makeText(this, "You win BIG prise", Toast.LENGTH_SHORT).show();
                score += bet * 20/2;
                exp += bet * 10;
                txt_exp.setText(String.valueOf(exp));
                txt_score.setText(String.valueOf(score));

        preferences.edit().putInt("score", score).apply();
        preferences.edit().putInt("exp", exp).apply();
                image11.anim();
                image12.anim();
                image13.anim();
                image14.anim();
            } else if (image11.getValue() == image12.getValue() && image12.getValue() == image13.getValue() && image13.getValue() != image14.getValue()) {
                Toast.makeText(this, "You win big prise", Toast.LENGTH_SHORT).show();
                score += bet * 20/10;
                exp += bet * 2;
                txt_exp.setText(String.valueOf(exp));
                txt_score.setText(String.valueOf(score));

        preferences.edit().putInt("score", score).apply();
        preferences.edit().putInt("exp", exp).apply();
                image11.anim();
                image12.anim();
                image13.anim();
            }else if (image11.getValue() == image12.getValue() && image12.getValue() != image13.getValue() ) {
                Toast.makeText(this, "You win small prise", Toast.LENGTH_SHORT).show();
                score += bet * 20/20;
                exp += bet;
                txt_exp.setText(String.valueOf(exp));
                image11.anim();
                txt_score.setText(String.valueOf(score));

        preferences.edit().putInt("score", score).apply();
        preferences.edit().putInt("exp", exp).apply();
                image11.anim();
                image12.anim();
            }
            canChange = true;
            score -= bet;
            txt_score.setText(String.valueOf(score));

        preferences.edit().putInt("score", score).apply();
        preferences.edit().putInt("exp", exp).apply();
            if (autoSpin){
                spin();
            }
        }
    }
    private int randomLine(){
        return random1.nextInt((15-5)+1)+5;
    }

    public void onClickSpin(View view) {
        autoSpin = false;
        canChange = false;
        spin();

    }

    public void onClickAutoSpin(View view) {
        autoSpin = !autoSpin;
        if (canChange){
            canChange = false;
        }
        spin();
    }
    private void spin(){
        if(score >= 50){
            canChange = false;
            spinEnd = false;
            image1.setValueRandom(new Random().nextInt(6), one);
            image6.setValueRandom(new Random().nextInt(6), one);
            image11.setValueRandom(new Random().nextInt(6), one);
            image2.setValueRandom(new Random().nextInt(6), two);
            image7.setValueRandom(new Random().nextInt(6), two);
            image12.setValueRandom(new Random().nextInt(6), two);
            image3.setValueRandom(new Random().nextInt(6), three);
            image8.setValueRandom(new Random().nextInt(6), three);
            image13.setValueRandom(new Random().nextInt(6), three);
            image4.setValueRandom(new Random().nextInt(6), one);
            image9.setValueRandom(new Random().nextInt(6), one);
            image14.setValueRandom(new Random().nextInt(6), one);
            image5.setValueRandom(new Random().nextInt(6), one);
            image10.setValueRandom(new Random().nextInt(6), one);
            image15.setValueRandom(new Random().nextInt(6), one);

        } else {
            Toast.makeText(SecondActivity.this, "You have not enough money", Toast.LENGTH_SHORT).show();
        }
    }

    public void downBet(View view) {
        if(canChange){
            bet -= 10;
            txt_bet.setText(String.valueOf(bet));
        }

    }

    public void upBet(View view) {
        if(canChange){
            bet += 10;
            txt_bet.setText(String.valueOf(bet));
        }

    }

    public void onClickLobby(View view) {
        Intent intent = new Intent(SecondActivity.this, LobbyActivity.class);
        startActivity(intent);
        finish();
    }
}