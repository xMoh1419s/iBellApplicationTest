package com.example.ibell;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.FirebaseDatabase;

public class accountinfo extends AppCompatActivity {

    TextView id, name, phone;
    Button btnout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accountinfo);

        BottomNavigationView bottomNavigationView = findViewById(R.id.BottomNavMenu);
        bottomNavigationView.setOnNavigationItemSelectedListener(nav);


        id = findViewById(R.id.idText);
        name = findViewById(R.id.nameText);
        phone = findViewById(R.id.numText);
        btnout = findViewById(R.id.signout);

        id.setText(sign_up.student.getF_ID());
        name.setText(sign_up.student.getF_name() + " " + sign_up.student.getG_name() + " " + sign_up.student.getL_name());
        phone.setText(User.phoneNum());

        btnout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sign_up.student = null;
                sign_up.user = null;
                Intent intent = new Intent(accountinfo.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    BottomNavigationView.OnNavigationItemSelectedListener nav = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.about:

                    Intent intent = new Intent(accountinfo.this, about_us.class);
                    startActivity(intent);
                    break;
                case R.id.home:
                    Intent intent2 = new Intent(accountinfo.this, main_screen.class);
                    startActivity(intent2);

                    break;

                case R.id.account:
                    Intent intent3 = new Intent(accountinfo.this, accountinfo.class);
                    startActivity(intent3);

                    break;
            }
            return true;
        }
    };
}