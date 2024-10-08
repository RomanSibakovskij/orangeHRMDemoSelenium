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
    //employee ID data
    private static int employeeID;
    //employee ID randomizer range variables
    private static int minID = 100;
    private static int maxID = 9999;
    private static final Random randomEmployeeID = new SecureRandom();

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
    //first names
    private static final String[] FIRST_NAMES = {
            "John", "Jane", "Michael", "Sarah", "David", "Emma", "Robert", "Lisa", "Christopher", "Mary",
            "William", "Olivia", "James", "Sophia", "Benjamin", "Isabella", "Alexander", "Mia", "Henry", "Amelia",
            "Daniel", "Evelyn", "Matthew", "Abigail", "Joseph", "Emily", "Samuel", "Avery", "Jackson", "Ella",
            "Lucas", "Scarlett", "Mason", "Grace", "Ethan", "Chloe", "Logan", "Sofia", "Owen", "Aubrey",
            "Elijah", "Zoey", "Oliver", "Hannah", "Isaac", "Victoria", "Nathan", "Lily", "Sebastian", "Zoe",
            "Caleb", "Aria", "Aiden", "Lucy", "Wyatt", "Savannah"
    };

    //last names
    private static final String[] LAST_NAMES = {
            "Smith", "Johnson", "Williams", "Brown", "Jones", "Miller", "Davis", "Wilson", "Moore", "Taylor",
            "Anderson", "Thomas", "Jackson", "White", "Harris", "Martin", "Thompson", "Garcia", "Martinez", "Robinson",
            "Clark", "Rodriguez", "Lewis", "Lee", "Walker", "Hall", "Allen", "Young", "King", "Wright",
            "Scott", "Green", "Baker", "Adams", "Nelson", "Carter", "Mitchell", "Perez", "Roberts", "Turner",
            "Phillips", "Campbell", "Parker", "Evans", "Edwards", "Collins", "Stewart", "Sanchez", "Morris", "Rogers"
    };


    // Randomizer method to generate full employee name
    public static String getRandomEmployeeName() {
        Random random = new Random();
        String firstName = FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];
        String lastName = LAST_NAMES[random.nextInt(LAST_NAMES.length)];
        return firstName + " " + lastName;
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
    //employee ID random generator
    public static int getRandomID() {
        employeeID = randomEmployeeID.nextInt((maxID - minID) + 1) + minID;
        return employeeID;
    }

    //password getter
    public static String getNewPassword() {
        return newPassword;
    }
    //employee ID getter
    public static int getEmployeeID(){
        return employeeID;
    }
}
