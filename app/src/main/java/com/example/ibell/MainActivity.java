package com.example.ibell;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

     Button login;
     TextView noAccount;
    EditText ID, password;

    DatabaseReference reff;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = (Button) findViewById(R.id.signin);
        noAccount = findViewById(R.id.noAccount);

        ID = findViewById(R.id.IDfeild);
        password = findViewById(R.id.passwordFiled);

        login.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View v) {

                String id = ID.getText().toString().trim();

                String logpassword = password.getText().toString().trim();

                if(!id.matches("(1|2).*") || id.length() != 10){
                    ID.setError("فضلا تأكد من رقم الهوية");
                    return;
                }
                if(id.isEmpty()){
                    ID.setError("لابد من ادخال رقم الهوية");
                    return;
                }
                if(TextUtils.isEmpty(logpassword)){
                    password.setError("لابد من ادخال كلمة مرور");
                    return;
                }
                if(logpassword.length() <= 8) {
                    password.setError("لابد ان تكون كلمة المرور اكثر من او تساوي 8 خانات");
                    return;
                }

                reff = FirebaseDatabase.getInstance().getReference();//.child("students").child(ID.getText().toString().trim());

                reff.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {


                        try {

                            String studentName = snapshot.child("students").child(ID.getText().toString()).child("student_name").getValue().toString();
                            String fatherName = snapshot.child("students").child(ID.getText().toString()).child("father_name").getValue().toString();
                            String grandName = snapshot.child("students").child(ID.getText().toString()).child("grandfather_name").getValue().toString();
                            String lastName = snapshot.child("students").child(ID.getText().toString()).child("last_name").getValue().toString();
                            String stdID = snapshot.child("students").child(ID.getText().toString()).child("student_id").getValue().toString();
                            String fatherID = snapshot.child("students").child(ID.getText().toString()).child("father_id").getValue().toString();

                            sign_up.student = new Student(studentName, fatherName, grandName, lastName, stdID, fatherID, "الابتدائية الاولى");
                            //txt.setText(student.getFullName());
                            Intent intent = new Intent(MainActivity.this, main_screen.class);
                            startActivity(intent);
                        }catch (NullPointerException e){
                            ID.setError("فضلا تأكد من ان رقم الهوية مسجل لدى المدرسة");
                        }catch (Exception e){
                            ID.setError("غلط");
                        }

                    }


                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

            }
        });





        /* login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this,main_screen.class);
                startActivity(intent);

            }
        }); */

        noAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this,sign_up.class);
                startActivity(intent);

            }
        });
    }
}