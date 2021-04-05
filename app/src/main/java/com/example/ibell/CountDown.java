package com.example.ibell;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Locale;

public class CountDown extends AppCompatActivity {

    static final long INITIAL_TIME = 600000;
    long millis = INITIAL_TIME;
    Button timer, picked;
    CountDownTimer countdown;
    boolean stillTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_countdown);
        Toast.makeText(CountDown.this, "اسم ابنك ظاهر على الشاشة, تقدر تروح تاخذه." , Toast.LENGTH_SHORT).show();
        timer = findViewById(R.id.btnn);
        picked = findViewById(R.id.take);
        User.wsaltButton();
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
        AlertDialog.Builder moreTime = new AlertDialog.Builder(CountDown.this);
        moreTime.setTitle("أنتهى الوقت!");
        moreTime.setMessage("تحتاج وقت زيادة؟");
        moreTime.setPositiveButton("ايه, باقي ما اخذت ابني.", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                millis = INITIAL_TIME;
                updateCountDownText();
                startTimer();
                Toast.makeText(CountDown.this, "تم تمديد الوقت, اسم ابنك لايزال على الشاشة." , Toast.LENGTH_SHORT).show();
            }
        });
        moreTime.setNegativeButton("لا, خلاص اخذته.", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                childPickedUp();
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
        DatabaseReference reff = FirebaseDatabase.getInstance().getReference("Leaving_student").child(sign_up.student.getS_ID());
        reff.removeValue();
        Intent intent = new Intent(CountDown.this, main_screen.class);
        startActivity(intent);
        Toast.makeText(CountDown.this, "شكرا لك على استخدام تطبيقنا, تم ازالة اسم ابنك من الشاشة." , Toast.LENGTH_LONG).show();
    }
}

