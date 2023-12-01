package com.example.b07project.loginandregister;

import java.util.regex.Pattern;

public class PasswordValidator {

    public static boolean isValidPassword(String password) {
        // Define password criteria
        int minLength = 6;
        int maxLength = 16;
        String letters = "(.*[a-zA-Z].*)";
        String numbers = "(.*[0-9].*)";

        if (password.length() <= minLength || password.length() >= maxLength) {
            return false;
        }

        if (!Pattern.compile(letters).matcher(password).matches()) {
            return false;
        }

        return Pattern.compile(numbers).matcher(password).matches();
    }

}
