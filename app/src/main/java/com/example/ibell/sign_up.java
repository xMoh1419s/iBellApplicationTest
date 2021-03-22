package com.example.ibell;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class sign_up extends AppCompatActivity {

     TextView thereAccount,txt;
     Button create;

    EditText ID, Fname, Password, RePassword, phoneNumber;
    DatabaseReference reff;
    FirebaseDatabase fire;
    ProgressBar Rprog;

    public static Student student;
    public static User user;
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
                String phone = phoneNumber.getText().toString().trim();
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
                    Password.setError("لابد ان تكون كلمة المرور اكثر من او تساوي 8 خانات");
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
                    reff = FirebaseDatabase.getInstance().getReference();//.child("students").child(ID.getText().toString().trim());
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


                                student = new Student(studentName, fatherNamex, grandName, lastName, stdID, fatherID, "الابتدائية الاولى");
                                user = new User(id, fatherNamex, password, phone);
                                FirebaseDatabase.getInstance().getReference("fatherUser").child(id+password).setValue(user);

                                //txt.setText(student.getFullName());
                                Intent intent = new Intent(sign_up.this, main_screen.class);
                                startActivity(intent);
                                finish();
                            }catch (NullPointerException e){
                                ID.setError("فضلا تأكد من ان رقم الهوية مسجل لدى المدرسة");
                                Rprog.setVisibility(View.GONE);
                                create.setVisibility(View.VISIBLE);
                            }catch (Exception e){
                                ID.setError("غلط");
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




        /*if(fAuth.getCurrentUser() != null){
            fAuth.signOut();
            //startActivity(new Intent(getApplicationContext(), main_screen.class));
            finish();
        }*/


        /*create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = ID.getText().toString().trim() +"@gmail.com";
                String  password = Password.getText().toString().trim();
                String repassword = RePassword.getText().toString().trim();

                if(TextUtils.isEmpty(id)){
                    ID.setError("لابد من ادخال رقم الهوية");
                    return;
                }

                if(TextUtils.isEmpty(password)){
                    Password.setError("لابد من ادخال كلمة مرور");
                    return;
                }

                if(password.length() <= 8) {
                    Password.setError("لابد ان تكون كلمة المرور اكثر من او تساوي 8 خانات");
                    return;

                }

                if(!repassword.contentEquals(password)){
                    RePassword.setError("لا تتطابق كلمتا المرور اللتان تم إدخالهما, يُرجى إعادة المحاولة");
                    return;

                }

                if(TextUtils.isEmpty(repassword)){
                    RePassword.setError("لابد من تأكيد كلمة المرور");
                    return;
                }
                create.setVisibility(View.INVISIBLE);
                Rprog.setVisibility(View.VISIBLE);

                fAuth.createUserWithEmailAndPassword(id,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(sign_up.this, "تم التسجيل بنجاح", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));

                        } else{
                            Toast.makeText(sign_up.this, "Error" + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                            Rprog.setVisibility(View.GONE);
                            create.setVisibility(View.VISIBLE);
                        }
                    }
                });
            }
        });*/
        thereAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(sign_up.this, MainActivity.class);
                startActivity(intent);

            }
        });
        /*create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(sign_up.this, MainActivity.class);
                startActivity(intent);

            }
        });*/
    }
}