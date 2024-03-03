package com.example.gauess;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class sps extends AppCompatActivity {

    Button stone,paper,scissor;
    ImageView img1,img2;
    Random random;
    int rand;
    String c,d;
    String result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sps);

    stone = findViewById(R.id.rock);
    paper = findViewById(R.id.paper);
    scissor = findViewById(R.id.scissor);

    img1 = findViewById(R.id.imageView4);
    img2 = findViewById(R.id.stone);

    random = new Random(3);

    stone.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            c = "stone";
            img1.setImageResource(R.drawable.rock1);
            calculate();
        }
    });
    paper.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            c = "paper";
            img1.setImageResource(R.drawable.paper1);
            calculate();
        }
    });
    scissor.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            c = "scissor";
            img1.setImageResource(R.drawable.scissor1);
            calculate();
        }
    });
    }
    public void  calculate(){
        rand = random.nextInt(3);
        if (rand == 0) {
            d = "stone";
            img2.setImageResource(R.drawable.rock2);
        } else if (rand == 1) {
            d = "paper";
            img2.setImageResource(R.drawable.paper2);
        } else if (rand == 2) {
            d = "scissor";
            img2.setImageResource(R.drawable.scissor2);
        }

        if (c.equals("stone") && d.equals("stone")) {
            result = "Draw";
        } else if (c.equals("paper") && d.equals("paper")) {
            result = "Draw";
        } else if (c.equals("scissor") && d.equals("scissor")) {
            result = "Draw";
        }
        if (c.equals("stone") && d.equals("scissor")) {
            result = "You !WIN!";
        }
        if (c.equals("scissor") && d.equals("stone")) {
            result = "You LOSE";
        }
        if (c.equals("paper") && d.equals("stone")) {
            result = "You !WIN!";
        }
        if (c.equals("stone") && d.equals("paper")) {
            result = "You LOSE";
        }
        if (c.equals("scissor") && d.equals("paper")) {
            result = "You !WIN!";
        }
        if (c.equals("paper") && d.equals("scissor")) {
            result = "You LOSE";
        }
        Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
    }
}