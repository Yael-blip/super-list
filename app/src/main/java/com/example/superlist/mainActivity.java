package com.example.superlist;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.textfield.TextInputEditText;

public class mainActivity extends AppCompatActivity {
    Button login;
    TextInputEditText email;
    EditText password;
    Button forgot_pwd;
    FB_control fbControl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = findViewById(R.id.login);
        fbControl = new FB_control();
        if (fbControl.isLogIn())
            startActivity(new Intent(this, home_screen.class));
        login.setOnClickListener(v-> {
        // @Override
        // public void onClick(View v) {
             email = findViewById(R.id.textInputEditText);
             password = findViewById(R.id.textInputEditText2);
             String password_str = password.getText().toString();
             String email_str = email.getText().toString();

             if (!InputValidator.isEmailValid(email_str)) {
                 email.setError("Invalid email adress");
                 return;
             }
             if (!InputValidator.isPasswordValid(password_str)) {
                 password.setError("Password must be at least 6 keys long");
                 return;
             }

             fbControl.loginUser(email_str, password_str, this);

        });

        Button create_acc = findViewById(R.id.create_account);
        create_acc.setOnClickListener(v -> {
            Intent intent = new Intent(mainActivity.this, SignUpUser.class);
            startActivity(intent);
        });



        forgot_pwd = findViewById(R.id.forgot_password);
        forgot_pwd.setOnClickListener(v -> {
        LayoutInflater inflater = getLayoutInflater();
        View recoverView = inflater.inflate(R.layout.activity_email_recovery, null);
        final EditText emailEditText = recoverView.findViewById(R.id.recovery_email);

        new AlertDialog.Builder(this)
            .setTitle("Send Temporary Password")
            .setView(recoverView)
            .setPositiveButton("Send", (dialog, which) -> {
                String email = emailEditText.getText().toString().trim();
            })
            .setNegativeButton("Cancel", null)
            .show();
        });
    }
}

