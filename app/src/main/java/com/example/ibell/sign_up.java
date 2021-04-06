package com.example.ibell;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;



public class sign_up extends AppCompatActivity {

    public static Student student;
    public static User user;
    public static String phone;
    TextView thereAccount,txt;
    Button create;
    EditText ID, Fname, Password, RePassword, phoneNumber;
    DatabaseReference reff;
    ProgressBar Rprog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sign_up);
        thereAccount = findViewById(R.id.account);
        txt = findViewById(R.id.ourText);
        create =(Button) findViewById(R.id.signUpBtn);
        ID = findViewById(R.id.IDText);
        Fname = findViewById(R.id.FnameText);
        Password = findViewById(R.id.PasswordText);
        RePassword = findViewById(R.id.RePasswordText);
        phoneNumber = findViewById(R.id.phoneText);
        Rprog = findViewById(R.id.progressBar);
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                create.setVisibility(View.INVISIBLE);
                Rprog.setVisibility(View.VISIBLE);
                String id = ID.getText().toString().trim();
                String fatherName = Fname.getText().toString().trim();
                String password = Password.getText().toString().trim();
                String repassword = RePassword.getText().toString().trim();
                phone = phoneNumber.getText().toString().trim();
                if(!id.matches("(1|2).*") || id.length() != 10){
                    ID.setError("فضلا تأكد من رقم الهوية");
                    Rprog.setVisibility(View.GONE);
                    create.setVisibility(View.VISIBLE);
                    return;
                }
                if(phone.length() != 10 || !phone.startsWith("05")){
                    phoneNumber.setError("فضلا تأكد من رقم الجوال");
                    Rprog.setVisibility(View.GONE);
                    create.setVisibility(View.VISIBLE);
                    return;
                }
                if(id.isEmpty()){
                    ID.setError("لابد من ادخال رقم الهوية");
                    Rprog.setVisibility(View.GONE);
                    create.setVisibility(View.VISIBLE);
                    return;
                }
                if(fatherName.isEmpty()){
                    Fname.setError("لابد من ادخال الاسم");
                    Rprog.setVisibility(View.GONE);
                    create.setVisibility(View.VISIBLE);
                }
                if(phone.isEmpty()){
                    phoneNumber.setError("لابد من ادخال رقم الجوال");
                    Rprog.setVisibility(View.GONE);
                    create.setVisibility(View.VISIBLE);
                }
                if(TextUtils.isEmpty(password)){
                    Password.setError("لابد من ادخال كلمة مرور");
                    Rprog.setVisibility(View.GONE);
                    create.setVisibility(View.VISIBLE);
                    return;
                }
                if(password.length() <= 8) {
                    Password.setError("لابد ان تكون كلمة المرور اكثر من او تساوي 9 خانات");
                    Rprog.setVisibility(View.GONE);
                    create.setVisibility(View.VISIBLE);
                    return;
                }
                if(!repassword.contentEquals(password)){
                    RePassword.setError("لا تتطابق كلمتا المرور اللتان تم إدخالهما, يُرجى إعادة المحاولة");
                    Rprog.setVisibility(View.GONE);
                    create.setVisibility(View.VISIBLE);
                    return;
                }
                if(TextUtils.isEmpty(repassword)){
                    RePassword.setError("لابد من تأكيد كلمة المرور");
                    Rprog.setVisibility(View.GONE);
                    create.setVisibility(View.VISIBLE);
                    return;
                }
                    reff = FirebaseDatabase.getInstance().getReference();
                    reff.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            try {
                                String studentName = snapshot.child("students").child(ID.getText().toString()).child("student_name").getValue().toString();
                                String fatherNamex = snapshot.child("students").child(ID.getText().toString()).child("father_name").getValue().toString();
                                String grandName = snapshot.child("students").child(ID.getText().toString()).child("grandfather_name").getValue().toString();
                                String lastName = snapshot.child("students").child(ID.getText().toString()).child("last_name").getValue().toString();
                                String stdID = snapshot.child("students").child(ID.getText().toString()).child("student_id").getValue().toString();
                                String fatherID = snapshot.child("students").child(ID.getText().toString()).child("father_id").getValue().toString();
                                String grade = snapshot.child("students").child(ID.getText().toString()).child("student_grade").getValue().toString();

                                student = new Student(studentName, fatherNamex, grandName, lastName, stdID, fatherID, grade);
                                user = new User(id, fatherNamex, password, phone);
                                FirebaseDatabase.getInstance().getReference("fatherUser").child(id+password).setValue(user);

                                Intent intent = new Intent(sign_up.this, main_screen.class);
                                startActivity(intent);
                                txt.setText(user.signupSuccess());
                                finish();
                            }catch (NullPointerException e){
                                ID.setError("فضلا تأكد من ان رقم الهوية مسجل لدى المدرسة");
                                Rprog.setVisibility(View.GONE);
                                create.setVisibility(View.VISIBLE);
                            }catch (Exception e){
                                ID.setError("الرجاء المحاولة مرة اخرى");
                                Rprog.setVisibility(View.GONE);
                                create.setVisibility(View.VISIBLE);
                            }
                        }
                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
            }
        });
        thereAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(sign_up.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}