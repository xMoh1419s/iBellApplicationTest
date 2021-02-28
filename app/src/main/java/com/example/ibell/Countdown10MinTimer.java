package com.example.ibell;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Locale;

public class Countdown10MinTimer extends AppCompatActivity {

    /*Button timer, picked;
    CountDownTimer countdown;
    long milli = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countdown10_min_timer);

        timer = findViewById(R.id.timer);
        picked = findViewById(R.id.pickedUp);
        startTimer();
    }

    public void startTimerx(){
        countdown = new CountDownTimer(milli, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
               milli = millisUntilFinished;
               updateTimer();
               int min = (int) milli / 60000;
               int sec = (int) milli % 60000 / 1000;
               String timeLeft;
               timeLeft = min +":";
               if(sec < 10)
                   timeLeft += "0";
               timeLeft += sec;
               timer.setText(timeLeft);
            }

            @Override
            public void onFinish() {
                AlertDialog.Builder moreTime = new AlertDialog.Builder(Countdown10MinTimer.this);
                moreTime.setTitle("أنتهى الوقت!");
                moreTime.setMessage("تحتاج وقت زيادة؟");
                moreTime.setPositiveButton("ايه", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        moreTimeFun();
                    }
                });
                moreTime.create().show();
            }
        }.start();
    }

    public void moreTimeFun(){
        milli = 5000;
        updateTimer();
    }

    public void updateTimer(){
        int min = (int) (milli / 1000) / 60;
        int sec = (int) (milli / 1000) % 60;
        String timeLeft = String.format(Locale.getDefault(), "%02d:%02d", min, sec);
        timer.setText(timeLeft);
    }
}
    static final long INITIAL_TIME = 10000;
    long millis = INITIAL_TIME;
    Button timer, picked;
    CountDownTimer countdown;
    boolean stillTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countdown10_min_timer);
        Toast.makeText(Countdown10MinTimer.this, "اسم ابنك ظاهر على الشاشة, تقدر تروح تاخذه." , Toast.LENGTH_SHORT).show();
        timer = findViewById(R.id.button_start_pause);
        picked = findViewById(R.id.pickedUp);
        startTimer();
        updateCountDownText();

        picked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                childPickedUp();
            }
        });
    }
    private void startTimer() {
        countdown = new CountDownTimer(millis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                millis = millisUntilFinished;
                updateCountDownText();
            }
            @Override
            public void onFinish() {
                stillTime = false;
                resetTimer();
            }
        }.start();
        stillTime = true;
    }
    private void resetTimer() {
        AlertDialog.Builder moreTime = new AlertDialog.Builder(Countdown10MinTimer.this);
        moreTime.setTitle("أنتهى الوقت!");
        moreTime.setMessage("تحتاج وقت زيادة؟");
        moreTime.setPositiveButton("ايه, باقي ما اخذت ابني.", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                millis = INITIAL_TIME;
                updateCountDownText();
                startTimer();
                Toast.makeText(Countdown10MinTimer.this, "تم تمديد الوقت, اسم ابنك لايزال على الشاشة." , Toast.LENGTH_SHORT).show();
            }
        });
        moreTime.setNegativeButton("لا, خلاص اخذته.", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                childPickedUp();
                Toast.makeText(Countdown10MinTimer.this, "شكرا لك على استخدام تطبيقنا, تم ازالة اسم ابنك من الشاشة." , Toast.LENGTH_LONG).show();
            }
        });
        moreTime.create().show();
    }
    private void updateCountDownText() {
        int minutes = (int) (millis / 1000) / 60;
        int seconds = (int) (millis / 1000) % 60;
        String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
        timer.setText(timeLeftFormatted);
    }
    public void childPickedUp(){
        DatabaseReference reff = FirebaseDatabase.getInstance().getReference("Leaving_student").child("1010101010");
        reff.removeValue();
    }*/
}