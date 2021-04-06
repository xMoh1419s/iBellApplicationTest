package com.example.ibell;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class about_us extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_about_us);
        BottomNavigationView bottomNavigationView = findViewById(R.id.BottomNavMenu);
        bottomNavigationView.setOnNavigationItemSelectedListener(nav);
    }

    BottomNavigationView.OnNavigationItemSelectedListener nav = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.about:
                    Intent intent = new Intent(about_us.this, about_us.class);
                    startActivity(intent);
                    finish();
                    break;
                case R.id.home:
                    Intent intent2 = new Intent(about_us.this, main_screen.class);
                    startActivity(intent2);
                    finish();
                    break;
                case R.id.account:
                    Intent intent3 = new Intent(about_us.this, accountinfo.class);
                    startActivity(intent3);
                    finish();
                    break;
                case R.id.logout:
                    sign_up.student = null;
                    sign_up.user = null;
                    Intent intent4 = new Intent(about_us.this, MainActivity.class);
                    startActivity(intent4);
                    finish();
                    break;
            }
            return true;
        }
    };
}
