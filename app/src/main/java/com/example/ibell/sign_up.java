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

     TextView thereAccount;
     Button create;

    EditText ID, Fname, Password, RePassword;
    FirebaseAuth fAuth;
    ProgressBar Rprog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        thereAccount = findViewById(R.id.account);
        create =(Button) findViewById(R.id.signUpBtn);

        ID = findViewById(R.id.IDText);
        Fname = findViewById(R.id.FnameText);
        Password = findViewById(R.id.PasswordText);
        RePassword = findViewById(R.id.RePasswordText);
        Rprog = findViewById(R.id.progressBar);

        fAuth = FirebaseAuth.getInstance();


        if(fAuth.getCurrentUser() != null){
            fAuth.signOut();
            //startActivity(new Intent(getApplicationContext(), main_screen.class));
            finish();
        }


        create.setOnClickListener(new View.OnClickListener() {
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
        });

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