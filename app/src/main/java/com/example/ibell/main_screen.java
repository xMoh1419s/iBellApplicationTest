package com.example.ibell;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class main_screen extends AppCompatActivity {

    public Button btn;
    public TextView tst;
    Spinner names;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main_screen);

        BottomNavigationView bottomNavigationView = findViewById(R.id.BottomNavMenu);
        bottomNavigationView.setOnNavigationItemSelectedListener(nav);

        tst = findViewById(R.id.Test);
        btn = findViewById(R.id.wasalt);
        names = findViewById(R.id.spinnerNames);

        List<String> namesList = new ArrayList<>();
        if(sign_up.student.getFullName() == null){

        }else {
            namesList.add(sign_up.student.getFullName());
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, namesList);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            names.setAdapter(adapter);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(main_screen.this, Test.class);
                    startActivity(intent);
                }
            });
        }
    }
    BottomNavigationView.OnNavigationItemSelectedListener nav = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.about:
                    Intent intent = new Intent(main_screen.this,about_us.class);
                    startActivity(intent);
                    break;
                case R.id.home:
                    Intent intent2 = new Intent(main_screen.this, main_screen.class);
                    startActivity(intent2);
                    break;
                case R.id.account:
                    Intent intent3 = new Intent(main_screen.this, accountinfo.class);
                    startActivity(intent3);
                    break;
                case R.id.logout:
                    sign_up.student = null;
                    sign_up.user = null;
                    Intent intent4 = new Intent(main_screen.this, MainActivity.class);
                    startActivity(intent4);
                    finish();
                    break;
            }
            return true;
        }
    };
}