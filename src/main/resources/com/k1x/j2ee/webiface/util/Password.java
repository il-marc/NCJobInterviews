/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.k1x.j2ee.webiface.util;

/**
 *
 * @author k1x
 */
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
 
/**
 * Password generator created for the members of Java Programming Forums. Feel free
 * to use this in your own applications. Please give credit where credit is due.
 *
 * @author Daniel Johansson
 * @since 9 Jul 2009
 */
public class Password {
 
    private static final String ALPHA_CHARACTERS = "abcdefghijklmnopqrstuvwxyz";
 
    private static final String NUMBERS = "0123456789";
 
    private static final String SYMBOLS = "$%&*@#!_:~";
 
 
    protected Password() {
        throw new UnsupportedOperationException();
    }
 
 
    public static int strength(final String password) {
        int strength = 0;
 
        // Length
        strength += (password.length() * 4);
 
        // Upper case letters
        final int upperCase = matches(password, "[A-Z]");
 
        if (upperCase > 0) {
            strength += ((password.length() - upperCase) * 2);
        }
 
        // Lower case letters
        final int lowerCase = matches(password, "[a-z]");
 
        if (lowerCase > 0) {
            strength += ((password.length() - lowerCase) * 2);
        }
 
        // Numbers
        final int numbers = matches(password, "[0-9]");
 
        if (numbers > 0) {
            strength += (numbers * 4);
        }
 
        if (numbers == password.length()) {
            strength -= numbers;
        }
 
        // Sepcial characters
        final int specialCharacters = matches(password, "[:,!,@,#,$,%,^,&,*,?,_,~]");
 
        if (specialCharacters > 0) {
            strength += (specialCharacters * 6);
        }
 
        // Letters only
        final int letters = matches(password, "[a-z|A-Z]");
 
        if (letters == password.length()) {
            strength -= letters;
        }
 
        // Middle numbers
        int middles = 0;
 
        for (int j = 0; j < NUMBERS.length(); ++j) {
            if ((password.indexOf(NUMBERS.charAt(j)) > 0) && (password.indexOf(NUMBERS.charAt(j)) < password.length() - 1)) {
                ++middles;
            }
        }
 
        // Middle symbols
        for (int j = 0; j < SYMBOLS.length(); ++j) {
            if ((password.indexOf(SYMBOLS.charAt(j)) > 0) && (password.indexOf(SYMBOLS.charAt(j)) < password.length())) {
                ++middles;
            }
        }
 
        strength += (middles * 2);
 
        // Repeat charaters
        final List<Character> done = new ArrayList<Character>();
        for (int i = 0; i < password.length(); ++i) {
            int matches = 0;
 
            for (int j = 0; j < password.length(); ++j) {
                if (password.toLowerCase().charAt(i) == password.toLowerCase().charAt(j) && !done.contains(password.toLowerCase().charAt(i))) {
                    ++matches;
                }
            }
 
            if (matches > 1) {
                strength -= (matches * (matches - 1));
                done.add(password.toLowerCase().charAt(i));
            }
        }
        
         if (password.length() >= 8) {
            if (((double) upperCase / (double) password.length()) >= 0.25) {
            }
 
            if (((double) lowerCase / (double) password.length()) >= 0.25) {
            }
 
            if (((double) numbers / (double) password.length()) >= 0.25) {
            }
            if (((double) specialCharacters / (double) password.length()) >= 0.25) {
            }
        }

        // Consequtive upper case letters
        final int consequtiveUpperCaseLetters = matches(password, "[A-Z]{2}");
        strength -= (consequtiveUpperCaseLetters * 2);
 
        // Consequtive lower case letters
        final int consequtiveLowerCaseLetters = matches(password, "[a-z]{2}");
        strength -= (consequtiveLowerCaseLetters * 2);
 
        // Consequtive numbers
        final int consequtiveNumbers = matches(password, "[0-9]{2}");
        strength -= (consequtiveNumbers * 2);
 
        // Sequential characters
        for (int i = 0; i < password.length(); ++i) {
            final int index = ALPHA_CHARACTERS.indexOf(String.valueOf(password.charAt(i)).toLowerCase());
 
            if (index != -1 && index < ALPHA_CHARACTERS.length() - 3) {
                final String forwardSequence = ALPHA_CHARACTERS.substring(index, index + 3);
                final String reverseSequence = new StringBuffer(forwardSequence).reverse().toString();
 
                if (password.indexOf(forwardSequence) != -1 || password.indexOf(reverseSequence) != -1) {
                    strength -= 3;
                }
            }
        }
 
        // Sequential numbers
        for (int i = 0; i < password.length(); ++i) {
            final int index = NUMBERS.indexOf(String.valueOf(password.charAt(i)).toLowerCase());
 
            if (index != -1 && index < NUMBERS.length() - 3) {
                final String forwardSequence = NUMBERS.substring(index, index + 3);
                final String reverseSequence = new StringBuffer(forwardSequence).reverse().toString();
 
                if (password.indexOf(forwardSequence) != -1 || password.indexOf(reverseSequence) != -1) {
                    strength -= 3;
                }
            }
        }

 
        if (strength < 0) {
            strength = 0;
        } else if (strength > 100) {
            strength = 100;
        }
 
        return strength;
    }
 
    private static int matches(final String string, final String regexPattern) {
        int matches = 0;
        final Pattern pattern = Pattern.compile(regexPattern);
        final Matcher matcher = pattern.matcher(string);
 
        while (matcher.find()) {
            ++matches;
        }
 
        return matches;
    }
 
}