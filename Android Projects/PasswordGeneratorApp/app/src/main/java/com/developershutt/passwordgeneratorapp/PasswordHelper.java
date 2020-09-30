package com.developershutt.passwordgeneratorapp;

import java.security.SecureRandom;
import java.util.Random;

public class PasswordHelper {

    private int length;
    private boolean lower = true, upper = true, number = true, symbol = true;

    public PasswordHelper(int length) {
        this.length = length;
    }

    public void useLowercase(boolean value) {
        this.lower = value;
    }

    public void useUppercase(boolean value) {
        upper = value;
    }

    public void useNumbers(boolean value) {
        number = value;
    }

    public void useSymbols(boolean value) {
        symbol = value;
    }

    public String generatePassword() {

        //minimum length of 6
        if (length < 4) {
            length = 6;
        }

        final char[] lowercase = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        final char[] uppercase = "ABCDEFGJKLMNPRSTUVWXYZ".toCharArray();
        final char[] numbers = "0123456789".toCharArray();
        final char[] symbols = "^$?!@#%&".toCharArray();
        final char[] allAllowed = "abcdefghijklmnopqrstuvwxyzABCDEFGJKLMNPRSTUVWXYZ0123456789^$?!@#%&".toCharArray();

        //Use cryptographically secure random number generator
        Random random = new SecureRandom();

        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length - 4; i++) {
            password.append(allAllowed[random.nextInt(allAllowed.length)]);
        }

        //Ensure password policy is met by inserting required random chars in random positions
        if (lower)
            password.insert(random.nextInt(password.length()), lowercase[random.nextInt(lowercase.length)]);
        if (upper)
            password.insert(random.nextInt(password.length()), uppercase[random.nextInt(uppercase.length)]);
        if (number)
            password.insert(random.nextInt(password.length()), numbers[random.nextInt(numbers.length)]);
        if (symbol)
            password.insert(random.nextInt(password.length()), symbols[random.nextInt(symbols.length)]);

        return password.toString();
    }

}