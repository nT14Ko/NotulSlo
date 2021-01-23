package com.dasikerol.notul;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.dasikerol.notul.ImageViewScrolling.IEventEnd;
import com.dasikerol.notul.ImageViewScrolling.ImageViewScrolling;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements IEventEnd {

    ImageViewScrolling image1,image2,image3,image4,image5,image6,image7,image8,image9,image10,image11,image12,image13,image14,image15;
    Button buttonSpin;
    Button buttonAutoSpin;
    TextView txt_score, txt_bet;
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

    int count_done=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonSpin = findViewById(R.id.buttonSpin);
        buttonAutoSpin = findViewById(R.id.buttonAutoSpin);
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
        image1 = findViewById(R.id.image1);
        image2 = findViewById(R.id.image2);
        image3 = findViewById(R.id.image3);
        image4 = findViewById(R.id.image4);
        image5 = findViewById(R.id.image5);
        image6 = findViewById(R.id.image6);
        image7 = findViewById(R.id.image7);
        image8 = findViewById(R.id.image8);
        image9 = findViewById(R.id.image9);
        image10 = findViewById(R.id.image10);
        image11 = findViewById(R.id.image11);
        image12 = findViewById(R.id.image12);
        image13 = findViewById(R.id.image13);
        image14 = findViewById(R.id.image14);
        image15 = findViewById(R.id.image15);
        txt_score = findViewById(R.id.txt_score);
        txt_bet = findViewById(R.id.txt_bet);
        image1.setEventEnd(MainActivity.this);
        image2.setEventEnd(MainActivity.this);
        image3.setEventEnd(MainActivity.this);
        image4.setEventEnd(MainActivity.this);
        image5.setEventEnd(MainActivity.this);
        image6.setEventEnd(MainActivity.this);
        image7.setEventEnd(MainActivity.this);
        image8.setEventEnd(MainActivity.this);
        image9.setEventEnd(MainActivity.this);
        image10.setEventEnd(MainActivity.this);
        image11.setEventEnd(MainActivity.this);
        image12.setEventEnd(MainActivity.this);
        image13.setEventEnd(MainActivity.this);
        image14.setEventEnd(MainActivity.this);
        image15.setEventEnd(MainActivity.this);

//        buttonSpin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(Common.SCORE >= 50){
//                    image1.setValueRandom(new Random().nextInt(6), one);
//                    image6.setValueRandom(new Random().nextInt(6), one);
//                    image11.setValueRandom(new Random().nextInt(6), one);
//                    image2.setValueRandom(new Random().nextInt(6), two);
//                    image7.setValueRandom(new Random().nextInt(6), two);
//                    image12.setValueRandom(new Random().nextInt(6), two);
//                    image3.setValueRandom(new Random().nextInt(6), three);
//                    image8.setValueRandom(new Random().nextInt(6), three);
//                    image13.setValueRandom(new Random().nextInt(6), three);
//                    image4.setValueRandom(new Random().nextInt(6), one);
//                    image9.setValueRandom(new Random().nextInt(6), one);
//                    image14.setValueRandom(new Random().nextInt(6), one);
//                    image5.setValueRandom(new Random().nextInt(6), one);
//                    image10.setValueRandom(new Random().nextInt(6), one);
//                    image15.setValueRandom(new Random().nextInt(6), one);
//                    Common.SCORE -= 50;
//                    txt_score.setText(String.valueOf(Common.SCORE));
//                } else {
//                    Toast.makeText(MainActivity.this, "You have not enough money", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
    }


    @Override
    public void eventEnd(int result, int count) {
        if(count_done<14){
            count_done++;
        } else {
            count_done = 0;
            if (image1.getValue() == image2.getValue() && image2.getValue() == image3.getValue() && image3.getValue() == image4.getValue() && image4.getValue() == image5.getValue()){
                Toast.makeText(this, "You win SUPER BIG prise", Toast.LENGTH_SHORT).show();
                Common.SCORE += bet * 20;
                txt_score.setText(String.valueOf(Common.SCORE));
            } else if (image1.getValue() == image2.getValue() && image2.getValue() == image3.getValue() && image3.getValue() == image4.getValue() && image4.getValue() != image5.getValue()){
                Toast.makeText(this, "You win prise", Toast.LENGTH_SHORT).show();
                Common.SCORE += bet *10;
                txt_score.setText(String.valueOf(Common.SCORE));
            } else if (image1.getValue() == image2.getValue() && image2.getValue() == image3.getValue() && image3.getValue() != image4.getValue()) {
                Toast.makeText(this, "You win big prise", Toast.LENGTH_SHORT).show();
                Common.SCORE += bet *2;
                txt_score.setText(String.valueOf(Common.SCORE));
            }else if (image1.getValue() == image2.getValue() && image2.getValue() != image3.getValue() ) {
                Toast.makeText(this, "You win small prise", Toast.LENGTH_SHORT).show();
                Common.SCORE += bet;
                txt_score.setText(String.valueOf(Common.SCORE));
            }


            if (image6.getValue() == image7.getValue() && image7.getValue() == image8.getValue() && image8.getValue() == image9.getValue() && image9.getValue() == image10.getValue()){
                Toast.makeText(this, "You win SUPER BIG prise", Toast.LENGTH_SHORT).show();
                Common.SCORE += bet * 20;
                txt_score.setText(String.valueOf(Common.SCORE));
            } else if (image6.getValue() == image7.getValue() && image7.getValue() == image8.getValue() && image8.getValue() == image9.getValue() && image9.getValue() != image10.getValue()){
                Toast.makeText(this, "You win BIG prise", Toast.LENGTH_SHORT).show();
                Common.SCORE += bet * 10;
                txt_score.setText(String.valueOf(Common.SCORE));
            } else if (image6.getValue() == image7.getValue() && image7.getValue() == image8.getValue() && image8.getValue() != image9.getValue()) {
                Toast.makeText(this, "You win big prise", Toast.LENGTH_SHORT).show();
                Common.SCORE += bet * 2;
                txt_score.setText(String.valueOf(Common.SCORE));
            }else if (image6.getValue() == image7.getValue() && image7.getValue() != image8.getValue() ) {
                Toast.makeText(this, "You win small prise", Toast.LENGTH_SHORT).show();
                Common.SCORE += bet;
                txt_score.setText(String.valueOf(Common.SCORE));
            }


            if (image11.getValue() == image12.getValue() && image12.getValue() == image13.getValue() && image3.getValue() == image14.getValue() && image14.getValue() == image15.getValue()){
                Toast.makeText(this, "You win SUPER BIG prise", Toast.LENGTH_SHORT).show();
                Common.SCORE += bet * 20;
                txt_score.setText(String.valueOf(Common.SCORE));
            } else if (image11.getValue() == image12.getValue() && image12.getValue() == image13.getValue() && image13.getValue() == image14.getValue() && image14.getValue() != image15.getValue()){
                Toast.makeText(this, "You win BIG prise", Toast.LENGTH_SHORT).show();
                Common.SCORE += bet * 20/2;
                txt_score.setText(String.valueOf(Common.SCORE));
            } else if (image11.getValue() == image12.getValue() && image12.getValue() == image13.getValue() && image13.getValue() != image14.getValue()) {
                Toast.makeText(this, "You win big prise", Toast.LENGTH_SHORT).show();
                Common.SCORE += bet * 20/10;
                txt_score.setText(String.valueOf(Common.SCORE));
            }else if (image11.getValue() == image12.getValue() && image12.getValue() != image13.getValue() ) {
                Toast.makeText(this, "You win small prise", Toast.LENGTH_SHORT).show();
                Common.SCORE += bet * 20/20;
                txt_score.setText(String.valueOf(Common.SCORE));
            }
            canChange = true;
            Common.SCORE -= bet;
            txt_score.setText(String.valueOf(Common.SCORE));
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
        if(Common.SCORE >= 50){
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
            Toast.makeText(MainActivity.this, "You have not enough money", Toast.LENGTH_SHORT).show();
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
}