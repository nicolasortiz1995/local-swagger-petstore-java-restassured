package utils;

import io.github.cdimascio.dotenv.Dotenv;

public class EnvironmentConfiguration {
    private static final Dotenv dotenv = Dotenv.load();
    public static String getEnvironmentVariable(String key) {
        return dotenv.get(key);
    }
}
