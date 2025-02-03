package utils;

import com.github.javafaker.Faker;

import java.util.Random;

/**
 * Utility class for generating various types of random data.
 * Uses the JavaFaker library to create realistic data.
 */
public class DataGenerator {

    /**
     * Faker instance used to generate fake data.
     */
    static Faker faker = new Faker();

    /**
     * Generates a random integer ID between 100000 and 999999 (inclusive).
     *
     * @return A random integer ID.
     */
    public static int generateRandomID() {
        Random random = new Random();
        return 100000 + random.nextInt(900000);
    }

    /**
     * Generates a random username using the Faker library.
     *
     * @return A random username.
     */
    public static String generateRandomUsername() {
        return faker.name().username();
    }

    /**
     * Generates a random first name using the Faker library.
     *
     * @return A random first name.
     */
    public static String generateRandomFirstName() {
        return faker.name().firstName();
    }

    /**
     * Generates a random last name using the Faker library.
     *
     * @return A random last name.
     */
    public static String generateRandomLastName(){
        return faker.name().lastName();
    }

    /**
     * Generates a random email address using the Faker library.
     *
     * @return A random email address.
     */
    public static String generateRandomEmail() {
        return faker.internet().emailAddress();
    }

    /**
     * Generates a random password using the Faker library.
     *
     * @return A random password.
     */
    public static String generateRandomPassword() {
        return faker.internet().password();
    }

    /**
     * Generates a random phone number using the Faker library.
     *
     * @return A random phone number.
     */
    public static String generateRandomPhoneNumber() {
        return faker.phoneNumber().cellPhone();
    }
}