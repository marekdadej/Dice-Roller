package com.example.diceroller;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView diceImageView;
    private Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        diceImageView = findViewById(R.id.diceImage);
        Button rollButton = findViewById(R.id.rollButton);
        random = new Random();

        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollDice();
            }
        });
    }

    private void rollDice() {
        RotateAnimation rotate = new RotateAnimation(0, 360,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(500);
        rotate.setRepeatCount(1);

        rotate.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {}

            @Override
            public void onAnimationEnd(Animation animation) {
                int diceNumber = random.nextInt(6) + 1;
                switch (diceNumber) {
                    case 1:
                        diceImageView.setImageResource(R.drawable.dice_1);
                        break;
                    case 2:
                        diceImageView.setImageResource(R.drawable.dice_2);
                        break;
                    case 3:
                        diceImageView.setImageResource(R.drawable.dice_3);
                        break;
                    case 4:
                        diceImageView.setImageResource(R.drawable.dice_4);
                        break;
                    case 5:
                        diceImageView.setImageResource(R.drawable.dice_5);
                        break;
                    case 6:
                        diceImageView.setImageResource(R.drawable.dice_6);
                        break;
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {}
        });

        diceImageView.startAnimation(rotate);
    }
}