package com.example.gauess;

import androidx.appcompat.app.AppCompatActivity;
import androidx.dynamicanimation.animation.FlingAnimation;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import java.util.Random;

public class headtail extends AppCompatActivity {
    Button button;
    ImageView imageView;
    Random rand;
    int ab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_headtail);
        button = findViewById(R.id.buttone);
        imageView = findViewById(R.id.head);

        rand = new Random(2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ab = rand.nextInt(2);
                if (ab==0){
                    imageView.setImageResource(R.drawable.head);
                    Toast.makeText(headtail.this, "Its's Head..", Toast.LENGTH_SHORT).show();
                }
                else {
                    imageView.setImageResource(R.drawable.tail);
                    Toast.makeText(headtail.this, "It's Tail..", Toast.LENGTH_SHORT).show();
                }
                RotateAnimation rotateAnimation = new RotateAnimation(0,360,RotateAnimation.RELATIVE_TO_SELF,0.5f,
                        RotateAnimation.RELATIVE_TO_SELF,0.5f);
                rotateAnimation.setDuration(1000);
                imageView.startAnimation(rotateAnimation);
            }
        });
    }
}