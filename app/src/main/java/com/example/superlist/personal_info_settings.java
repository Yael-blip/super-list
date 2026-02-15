package com.example.superlist;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.HashMap;

public class personal_info_settings extends AppCompatActivity {
    FB_control fbControl;
    TextView username, email, phoneNumber, location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_info_settings);
        username = findViewById(R.id.username_inp_text);
        email = findViewById(R.id.email_text);
        phoneNumber = findViewById(R.id.phoneNumber_text);
        location = findViewById(R.id.locationText);
        fbControl = new FB_control();
        fbControl.getUser(new FB_control.UserCallback() {
            @Override
            public void onUserLoaded(HashMap<String, Object> userMap) {
                username.setText("Username: " + String.valueOf(userMap.get("name")));
                email.setText("Email: " + String.valueOf(userMap.get("email")));
                phoneNumber.setText("Phone number: " + String.valueOf(userMap.get("phone")));
                String city = userMap.get("city").toString();
                String street = userMap.get("street").toString();
                String location_str = city + ", " + street;
                location.setText("Location: " + location_str);
            }

            @Override
            public void onError(Exception e) {

            }
        });

    }
}