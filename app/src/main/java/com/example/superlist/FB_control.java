package com.example.superlist;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class FB_control {
    private static FirebaseAuth mAuth;
    private static FirebaseDatabase DATABASE;
    private static DatabaseReference REFERENCE;

    public static FirebaseDatabase getDATABASE(){
        if(DATABASE == null){
            DATABASE = FirebaseDatabase.getInstance();
        }
        return DATABASE;
    }
    public static DatabaseReference getMyRef(String key){
        REFERENCE = getDATABASE().getReference(key);
        return REFERENCE;
    }
    public static FirebaseAuth getmAuth(){
        if(mAuth == null){
            mAuth = FirebaseAuth.getInstance();
        }
        return mAuth;
    }
    public void createUser (String name , String email, String phone, String city, String street, String pass, Context context){
        getmAuth().createUserWithEmailAndPassword(email, pass)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        String uid = task.getResult().getUser().getUid();

                        if (task.isSuccessful()) {
                            Map<String, String> user = new HashMap<>();
                            user.put("email", email);
                            user.put("name", name);
                            user.put("city", city);
                            user.put("phone", phone);
                            user.put("street", street);

                            DatabaseReference user_db = getMyRef("users");
                            user_db.child(uid).setValue(user)
                                    .addOnSuccessListener(v -> {
                                        Toast.makeText(context, "Succesfully created user !", Toast.LENGTH_SHORT).show();
                                    })
                                    .addOnFailureListener(e -> {
                                        Toast.makeText(context, "Failed to create user !", Toast.LENGTH_SHORT).show();
                                    });
                        } else {
                            // If sign in fails, display a message to the user.

                        }
                    }
                });
    }

    public interface UserCallback {
        void onUserLoaded(HashMap<String, Object> userMap);
        void onError(Exception e);
    }
    public void getUser(UserCallback callback) {
        DatabaseReference user_db = getMyRef("users");
        user_db.child(getmAuth().getCurrentUser().getUid()).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (task.isSuccessful()) {
                    DataSnapshot snapshot = task.getResult();
                    HashMap<String, Object> userMap = (HashMap<String, Object>) snapshot.getValue();
                    callback.onUserLoaded(userMap);
                } else {
                    callback.onError(task.getException());
                }
            }
        });
    }

    public void loginUser (String email, String pass, Context context){
    getmAuth().signInWithEmailAndPassword(email, pass)
            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Intent intent = new Intent(context, home_screen.class);
                        context.startActivity(intent);
                    }
                    else
                        Toast.makeText(context, "Failed to login user !", Toast.LENGTH_SHORT).show();
                    }
                });
    }


    public void logOut(Context context){
        getmAuth().signOut();
        Intent intent = new Intent(context, mainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);
        }

    public boolean isLogIn(){
        return FB_control.getmAuth().getCurrentUser() != null;
    }
}
    




