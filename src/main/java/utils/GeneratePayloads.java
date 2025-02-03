package utils;

/**
 * Utility class for generating JSON payloads for different API requests.
 * Provides methods to create specific request bodies for creating and updating pets and users.
 */
public class GeneratePayloads {

    /**
     * Generates a JSON payload for creating a pet with specified details.
     *
     * @param name   The name of the pet.
     * @param status The status of the pet (e.g., "available", "pending", "sold").
     * @param id     The ID of the pet.
     * @return A JSON string representing the payload for creating a pet.
     */
    public static String generatePayloadForCreatePet(String name, String status, String id) {
        return "{\n" +
                "  \"name\": \"" + name + "\",\n" +
                "  \"photoUrls\": [\n" +
                "    \"https://example.com/photos/dog1.jpg\",\n" +
                "    \"https://example.com/photos/dog2.jpg\"\n" +
                "  ],\n" +
                "  \"id\": " + id + ",\n" +
                "  \"category\": {\n" +
                "    \"id\": 1,\n" +
                "    \"name\": \"Dog\"\n" +
                "  },\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": 101,\n" +
                "      \"name\": \"Friendly\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 102,\n" +
                "      \"name\": \"Playful\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"" + status + "\"\n" +
                "}";
    }

    /**
     * Generates a JSON payload for updating the status of a pet.
     *
     * @param id     The ID of the pet to update.
     * @param status The new status of the pet.
     * @return A JSON string representing the payload for updating a pet's status.
     */
    public static String generatePayloadForUpdatePet(String id, String status) {
        return "{\n" +
                "  \"id\": " + id + ",\n" +
                "  \"status\": \"" + status + "\"\n" +
                "}";
    }

    /**
     * Generates a JSON payload for creating a user with specified details.
     *
     * @param id          The ID of the user.
     * @param username    The username of the user.
     * @param firstName   The first name of the user.
     * @param lastName    The last name of the user.
     * @param email       The email of the user.
     * @param password    The password of the user.
     * @param phoneNumber The phone number of the user.
     * @return A JSON string representing the payload for creating a user.
     */
    public static String generatePayloadForCreateUser(int id, String username, String firstName, String lastName, String email, String password, String phoneNumber) {
        return "{\n" +
                "  \"id\":" + id + ",\n" +
                "  \"username\": \"" + username + "\",\n" +
                "  \"firstName\": \"" + firstName + "\",\n" +
                "  \"lastName\": \"" + lastName + "\",\n" +
                "  \"email\": \"" + email + "\",\n" +
                "  \"password\": \"" + password + "\",\n" +
                "  \"phone\": \"" + phoneNumber + "\",\n" +
                "  \"userStatus\": 1\n" +
                "}";
    }
}