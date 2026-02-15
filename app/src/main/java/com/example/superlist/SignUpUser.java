package com.example.superlist;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class SignUpUser extends AppCompatActivity {
    FB_control fbctrl;
    TextInputEditText username, email, phoneNumber, city, street;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_user);

        Button signUp = findViewById(R.id.sign_up_btn);
        signUp.setOnClickListener(v-> {
            // @Override
            // public void onClick(View v) {
            email = findViewById(R.id.signup_email_text);
            password = findViewById(R.id.password_txt);
            username = findViewById(R.id.username_text);
            phoneNumber = findViewById(R.id.phoneNumber_text);
            city = findViewById(R.id.city_loc);
            street = findViewById(R.id.street_loc);

            String password_str = password.getText().toString();
            String email_str = email.getText().toString();
            String phone_str = phoneNumber.getText().toString();

            if (!InputValidator.isEmailValid(email_str)) {
                email.setError("Invalid email address");
                return;
            }

            if (!InputValidator.isPhoneNumberValid(phone_str)) {
                phoneNumber.setError("Phone number invalid");
                return;
            }

            if (!InputValidator.isPasswordValid(password_str)) {
                password.setError("Password must be at least 6 keys long");
                return;
            }

            if (TextUtils.isEmpty(email.getText().toString().trim())) {
                email.setError("Please fill email");
                return;
            }


            if (TextUtils.isEmpty(street.getText().toString().trim())) {
                street.setError("Please fill street");
                return;
            }


            if (TextUtils.isEmpty(city.getText().toString().trim())) {
                city.setError("Please fill city");
                return;
            }


            if (TextUtils.isEmpty(username.getText().toString().trim())) {
                username.setError("Please fill username");
                return;
            }


            if (TextUtils.isEmpty(phoneNumber.getText().toString().trim())) {
                phoneNumber.setError("Please fill username");
                return;
            }



            // create user
            fbctrl = new FB_control();
            fbctrl.createUser(
                    username.getText().toString(),
                    email.getText().toString(),
                    phoneNumber.getText().toString(),
                    city.getText().toString(),
                    street.getText().toString(),
                    password.getText().toString(),
                    SignUpUser.this);
        });
   }
}
