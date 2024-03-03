package com.example.gauess;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class feedback extends AppCompatActivity {
    EditText editText;
    Button wp, email;
    TextView move;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        editText = findViewById(R.id.feedtext);
        wp = findViewById(R.id.whtasapp);
        email = findViewById(R.id.email);
        move = findViewById(R.id.move);
                moving();

        wp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String feedback = editText.getText().toString();
                sendWhatsAppFeedback(feedback);
            }
        });
        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String feedback = editText.getText().toString();
                sendEmailFeedback(feedback);
            }
        });
    }

    private void sendEmailFeedback(String feedback) {
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setType("message/rfc822");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] { "rajsinghrajput7002@gmail.com" });
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Feedback from App");
        emailIntent.putExtra(Intent.EXTRA_TEXT, feedback);
        if (emailIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(Intent.createChooser(emailIntent, "Send Email"));
        }

    }
//        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
//        emailIntent.setData(Uri.parse("rajsinghrajput7002@gmail.com"));
//        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Feedback from App");
//        emailIntent.putExtra(Intent.EXTRA_TEXT, feedback);
//        if (emailIntent.resolveActivity(getPackageManager()) != null) {
//            startActivity(emailIntent);
//        }
//    }
    private void sendWhatsAppFeedback(String feedback) {
        String phoneNumber = "+916204630259"; // Replace with the desired phone number
        String url = "https://api.whatsapp.com/send?phone=" + phoneNumber + "&text=" + Uri.encode(feedback);
        Intent whatsappIntent = new Intent(Intent.ACTION_VIEW);
        whatsappIntent.setData(Uri.parse(url));
        if (whatsappIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(whatsappIntent);
        }
    }

//    private void sendWhatsAppFeedback(String feedback) {
//        Intent whatsappIntent = new Intent(Intent.ACTION_SEND);
//        whatsappIntent.setType("text/plain");
//        whatsappIntent.setPackage("com.whatsapp");
//        whatsappIntent.putExtra(Intent.EXTRA_TEXT, feedback);
//        if (whatsappIntent.resolveActivity(getPackageManager()) != null) {
//            startActivity(whatsappIntent);
//        }
//    }
    public void moving() {
        int screen = getResources().getDisplayMetrics().widthPixels;
        Animation animation = new TranslateAnimation(-screen, screen, 0, 0);
        animation.setDuration(5000);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                moving();

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        move.startAnimation(animation);
    }
}
