package com.example.ibell;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class main_screen2 extends AppCompatActivity {

    public Button btn;
    Spinner names;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main_screen2);

        btn = findViewById(R.id.button5);
        names = findViewById(R.id.spinner2);

        List<String> namesList = new ArrayList<>();

            /*namesList.add(sign_up.student.getFullName());
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, namesList);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            names.setAdapter(adapter);
            FirebaseDatabase.getInstance().getReference("Leaving_student").child("1010101010").removeValue();*/
            //User.wsaltButton();

        namesList.add(sign_up.student.getFullName());
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, namesList);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        names.setAdapter(adapter);


            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    //FirebaseDatabase.getInstance().getReference("Leaving_student").child("1010101010").removeValue();
                    Intent intent = new Intent(main_screen2.this, test2.class);
                    startActivity(intent);



                }
            });


    }
}