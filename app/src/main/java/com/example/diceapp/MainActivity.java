package com.example.diceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.time.Instant;
import java.time.LocalTime;
import java.util.Random;

import javax.xml.datatype.Duration;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button rollBtn = (Button) findViewById(R.id.rollBtn);
        ImageView dice1 = (ImageView) findViewById(R.id.dice1);
        ImageView dice2 = (ImageView) findViewById(R.id.dice2);
        int[] diceArray = {
                R.drawable.d1,
                R.drawable.d2,
                R.drawable.d3,
                R.drawable.d4,
                R.drawable.d5,
                R.drawable.d6,

        };
        MediaPlayer mp = MediaPlayer.create(this, R.raw.dice_shake_sound);


        rollBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int randNum = new Random().nextInt(6);
                dice1.setImageResource(diceArray[randNum]);
                randNum = new Random().nextInt(6);
                dice2.setImageResource(diceArray[randNum]);

                YoYo.with(Techniques.Swing)
                        .duration(700)
                        .repeat(0)
                        .playOn(dice1);
                YoYo.with(Techniques.Swing)
                        .duration(700)
                        .repeat(0)
                        .playOn(dice2);
                mp.start();

            }
        });
    }
}