package com.example.ibell;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class test2 extends AppCompatActivity {

    Button btn;
    FirebaseDatabase reff;
    DatabaseReference dreff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2);
        btn = findViewById(R.id.buttonTestingFunction);
        reff = FirebaseDatabase.getInstance();
        dreff = reff.getReference("Leaving_student");
        //FirebaseDatabase.getInstance().getReference("Leaving_student").child(sign_up.student.getS_ID()).setValue(sign_up.student);
        dreff.child(sign_up.student.getS_ID()).setValue(sign_up.student);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase.getInstance().getReference("Leaving_student").child("1010101010").removeValue();
                Intent intent = new Intent(test2.this, sign_up.class);
                startActivity(intent);
            }
        });
    }
}