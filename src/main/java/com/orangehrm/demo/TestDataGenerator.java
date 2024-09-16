package com.orangehrm.demo;

import org.openqa.selenium.WebDriver;

import java.security.SecureRandom;
import java.util.*;

public class TestDataGenerator extends BasePage{

    private static final Random RANDOM = new SecureRandom();

    //admin user data
    private static String newPassword;

    public TestDataGenerator(WebDriver driver) {
        super(driver);
    }

    private static String shuffleString(String string) {
        List<String> letters = Arrays.asList(string.split(""));
        Collections.shuffle(letters);
        return String.join("", letters);
    }

    public static String generateRandomPassword() {
        String numbers = "0123456789";

        // fixed password part
        String stokerPart = "Stoker";

        // random numeric sequence
        StringBuilder numericPart = new StringBuilder();
        numericPart.append(numbers.charAt(RANDOM.nextInt(numbers.length())));
        numericPart.append(numbers.charAt(RANDOM.nextInt(numbers.length())));
        numericPart.append(numbers.charAt(RANDOM.nextInt(numbers.length())));
        numericPart.append('_'); // Static underscore

        // shuffle the numeric part
        String shuffledNumericPart = shuffleString(numericPart.toString());

        //"Stoker" + shuffled numeric part
        StringBuilder password = new StringBuilder();
        password.append(stokerPart);
        password.append(shuffledNumericPart);

        return password.toString();
    }

    //password getter
    public static String getNewPassword() {
        return newPassword;
    }
}
