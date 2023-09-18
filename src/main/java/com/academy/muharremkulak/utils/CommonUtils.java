package com.academy.muharremkulak.utils;

import java.util.Random;

public class CommonUtils {

    public static String generateRandomEmail() {
        String emailPrefix = String.valueOf(generateRandomNumber());
        String randomNumber = String.valueOf(generateStringForEmail());
        String emailSuffix = "KevinLee" + emailPrefix + "Tech" + randomNumber + "@gmail.com"; //Kevin10LeeTECH@gmail.com (every time number will be change)
        return emailSuffix;
    }

    public static int generateStringForEmail(){
        Random random = new Random();
        int secondNumber = random.nextInt(51) + 10;  // random number between 10 and 90.
        return secondNumber;
    }

    public static int generateRandomNumber() {
        Random random = new Random();
        int number = random.nextInt(91) + 10;  // random number between 10 and 90.
        return number;
    }
}


