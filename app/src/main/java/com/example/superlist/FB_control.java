package com.example.superlist;

import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class FB_control {
    private static FirebaseAuth mAuth;
    public static FirebaseAuth getmAuth(){
        if(mAuth == null){
            mAuth = FirebaseAuth.getInstance();
        }
        return mAuth;
    }

    public void createUser (String email, String pass, Context context){
        getmAuth().createUserWithEmailAndPassword(email, pass)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Intent intent = new Intent(context, home_screen.class);
                            context.startActivity(intent);
                        } else {
                            // If sign in fails, display a message to the user.

                        }
                    }
                });
    }
}
