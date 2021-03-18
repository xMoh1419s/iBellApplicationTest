package com.example.ibell;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {

    private static int WELCOME = 5000;
    Animation icon, text;
    ImageView bell;
    TextView t1, t2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_welcome);
        icon = AnimationUtils.loadAnimation(this, R.anim.icon);
        text = AnimationUtils.loadAnimation(this, R.anim.text);
        bell = findViewById(R.id.imageView7);
        t1 = findViewById(R.id.textView4);
        t2 = findViewById(R.id.textView2);
        bell.setAnimation(icon);
        t1.setAnimation(text);
        t2.setAnimation(text);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, WELCOME);
    }
}