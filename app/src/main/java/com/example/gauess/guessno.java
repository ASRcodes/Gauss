package com.example.gauess;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ReceiverCallNotAllowedException;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class guessno extends AppCompatActivity {
    Button button;
    EditText editText;
    String yo;
    int a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guessno);

        editText = findViewById(R.id.edit);
        button = findViewById(R.id.guess);

        Random random = new Random();
        a = random.nextInt(30)+1;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check();
            }
        });
    }
    public void check(){
        String text = editText.getText().toString().trim();

                int userguess = Integer.parseInt(text);

                if (a<userguess){
                    yo = "!!Try Lower!!";
                } else if (a>userguess) {
                    yo = "!!Try Higher!!";
                }
                else {
                    yo = "Congrats! you got it";
                }
        Toast.makeText(this, yo, Toast.LENGTH_SHORT).show();
    }

}