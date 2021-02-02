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
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class sign_up extends AppCompatActivity {

    public TextView thereAccount;
    public Button create;

    EditText ID, Fname, Password, RePassword;
    FirebaseAuth fAuth;
    ProgressBar Rprog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        thereAccount = findViewById(R.id.account);
        create =(Button) findViewById(R.id.signUpBtn);

        ID = findViewById(R.id.IDnumber);
        Fname = findViewById(R.id.Fname);
        Password = findViewById(R.id.Password);
        RePassword = findViewById(R.id.RePassword);
        Rprog = findViewById(R.id.progressBar);

        fAuth = FirebaseAuth.getInstance();

        if(fAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(), main_screen.class));
            finish();
        }

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = ID.getText().toString().trim();
                String  password = Password.getText().toString().trim();

                if(TextUtils.isEmpty(id)){
                    ID.setError("لابد من ادخال رقم الهوية");
                    return;
                }

                if(TextUtils.isEmpty(password)){
                    Password.setError("لابد من ادخال كلمة مرور");
                    return;
                }

                if(password.length() < 8) {
                    Password.setError("لابد ان تكون كلمة المرور اكثر من او تساوي 8 خانات");
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
                            Toast.makeText(sign_up.this, "Error" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            Rprog.setVisibility(View.GONE);
                        }
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

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(sign_up.this, MainActivity.class);
                startActivity(intent);

            }
        });
    }
}