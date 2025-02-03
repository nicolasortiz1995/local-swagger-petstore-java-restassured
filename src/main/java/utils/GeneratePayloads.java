package utils;

public class GeneratePayloads {
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

    public static String generatePayloadForUpdatePet(String id, String status) {
        return "{\n" +
                "  \"id\": " + id + ",\n" +
                "  \"status\": \"" + status + "\"\n" +
                "}";
    }

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
