package utils;

import com.github.javafaker.Faker;

import java.util.Random;

public class DataGenerator {

    static Faker faker = new Faker();

    public static int generateRandomID() {
        Random random = new Random();
        return 100000 + random.nextInt(990001);
    }
    public static String generateRandomUsername() {
        return faker.name().username();
    }

    public static String generateRandomFirstName() {
        return faker.name().firstName();
    }

    public static String generateRandomLastName(){
        return faker.name().lastName();
    }

    public static String generateRandomEmail() {
        return faker.internet().emailAddress();
    }

    public static String generateRandomPassword() {
        return faker.internet().password();
    }

    public static String generateRandomPhoneNumber() {
        return faker.phoneNumber().cellPhone();
    }
}
