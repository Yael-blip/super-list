package com.example.superlist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class activity_settings extends AppCompatActivity {

    Button infoButton;
    Button securityButton;
    Button locationButton;
    Button logOutButton;
    Button mySuper;
    FB_control fbControl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_settings);

        infoButton = findViewById(R.id.personalInfoButton);
        infoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_settings.this, personal_info_settings.class);
                startActivity(intent);
            }
        });

        securityButton = findViewById(R.id.SecurityButton);
        securityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_settings.this, security_settings.class);
                startActivity(intent);
            }
        });

        logOutButton = findViewById(R.id.logOutButton);
        fbControl = new FB_control();
        logOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fbControl.logOut(activity_settings.this);
            }
        });


        mySuper = findViewById(R.id.mySuper);
        mySuper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_settings.this, setSuper.class);
                startActivity(intent);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

}
}