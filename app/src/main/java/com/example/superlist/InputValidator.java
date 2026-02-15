package com.example.superlist;

import android.util.Patterns;

public class InputValidator {
    public static boolean isEmailValid(String email) {
        if (email == null) return false;
        return Patterns.EMAIL_ADDRESS.matcher(email.trim()).matches();
    }

    public static boolean isPasswordValid(String password) {
        if (password == null)
            return false;
        return password.length() >= 6;
    }

    public static boolean isPhoneNumberValid(String phone_number){
        if (phone_number.length() != 10)
            return false;
        return true;
    }
}
