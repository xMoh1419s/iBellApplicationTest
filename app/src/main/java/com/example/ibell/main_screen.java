package com.example.ibell;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class main_screen extends AppCompatActivity {

    public Button btn;
    public TextView tst;
    Spinner names;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

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
            User.wsaltButton();



            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    tst.setText(sign_up.student.getFullName());

                }
            });

        }

    }
}