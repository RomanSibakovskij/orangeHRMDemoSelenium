package com.orangehrm.demo;

import org.openqa.selenium.WebDriver;

import java.security.SecureRandom;
import java.util.*;

public class TestDataGenerator extends BasePage{

    private static final Random RANDOM = new SecureRandom();
    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";

    //admin user data
    private static String newPassword;
    private static String username;
    private static String employeeName;

    public TestDataGenerator(WebDriver driver) {
        super(driver);
    }

    // Generate random string methods (for username, employee name)
    private static String generateRandomString(String characters, int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = RANDOM.nextInt(characters.length());
            sb.append(characters.charAt(index));
        }
        return sb.toString();
    }

    private static String shuffleString(String string) {
        List<String> letters = Arrays.asList(string.split(""));
        Collections.shuffle(letters);
        return String.join("", letters);
    }

    // Randomizer methods (for username, employee name)
    public static String generateRandomUsername(int length) {
        return generateRandomString(UPPER + LOWER, length);
    }
    public static String generateRandomEmployeeName(int length) {
        return generateRandomString(UPPER + LOWER, length);
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
