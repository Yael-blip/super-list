package com.example.superlist;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class security_settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_security_settings);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button change_pwd = findViewById(R.id.Change_password);
        change_pwd.setOnClickListener(v -> {
            LayoutInflater inflater = getLayoutInflater();
            View recoverView = inflater.inflate(R.layout.activity_change_password, null);

            final EditText pwdEditText = recoverView.findViewById(R.id.change_password);

            new AlertDialog.Builder(this)
                    .setTitle("Change password")
                    .setView(recoverView)
                    .setPositiveButton("Save", (dialog, which) -> {
                        String new_pwd = pwdEditText.getText().toString().trim();
                    })
                    .setNegativeButton("Cancel", null)
                    .show();
        });



    }
}