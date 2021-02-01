package com.example.ibell;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class sign_up extends AppCompatActivity {

    public TextView thereAccount;
    public Button create;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        thereAccount = findViewById(R.id.account);
        create =(Button) findViewById(R.id.signUpBtn);
        thereAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(sign_up.this, MainActivity.class);
                startActivity(intent);

            }
        });

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(sign_up.this, MainActivity.class);
                startActivity(intent);

            }
        });
    }
}