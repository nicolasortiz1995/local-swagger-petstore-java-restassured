package utils;

import io.github.cdimascio.dotenv.Dotenv;

/**
 * Utility class for loading and accessing environment variables using the dotenv library.
 * This class provides a method to retrieve environment variables by key.
 */
public class EnvironmentConfiguration {

    /**
     *  Loads environment variables from a .env file using the Dotenv library.
     */
    private static final Dotenv dotenv = Dotenv.load();

    /**
     * Retrieves an environment variable by its key.
     *
     * @param key The name of the environment variable to retrieve.
     * @return The value of the environment variable as a String, or null if the variable is not found.
     */
    public static String getEnvironmentVariable(String key) {
        return dotenv.get(key);
    }
}