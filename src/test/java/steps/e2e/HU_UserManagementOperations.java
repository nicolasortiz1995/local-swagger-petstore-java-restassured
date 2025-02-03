package steps.e2e;

import io.restassured.response.Response;
import org.example.pages.MethodsPage;
import utils.DataGenerator;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import utils.GeneratePayloads;

/**
 * Cucumber step definitions for user management operations.
 * This class contains the steps to create, retrieve, login, and logout users.
 */
public class HU_UserManagementOperations {
    private final MethodsPage methodsPage = new MethodsPage();

    private Response response;
    private int statusCode;
    private final int fakeId = DataGenerator.generateRandomID();
    private final String fakeUsername = DataGenerator.generateRandomUsername();
    private final String fakeFirstName = DataGenerator.generateRandomFirstName();
    private final String fakeLastName = DataGenerator.generateRandomLastName();
    private final String fakeEmail = DataGenerator.generateRandomEmail();
    private final String fakePassword = DataGenerator.generateRandomPassword();
    private final String fakePhoneNumber = DataGenerator.generateRandomPhoneNumber();
    private String payload;

    /**
     * Step definition for the Given clause: "I have the API endpoint to create a new user".
     */
    @Given("I have the API endpoint to create a new user")
    public void iHaveTheAPIEndpointToCreateANewUser(){
        System.out.println("Test Started");
    }

    /**
     * Step definition for the Then clause: "I provide a valid JSON payload with user details".
     * Generates a payload using `GeneratePayloads` class.
     */
    @Then("I provide a valid JSON payload with user details")
    public void iProvideAValidJSONPayloadWithUserDetails(){
        payload = GeneratePayloads.generatePayloadForCreateUser(fakeId, fakeUsername, fakeFirstName, fakeLastName, fakeEmail, fakePassword, fakePhoneNumber);
    }

    /**
     * Step definition for the When clause: "I send a POST request to create the user {string}".
     * Sends a POST request to the specified endpoint with the generated payload.
     *
     * @param endpoint The endpoint to send the POST request to.
     */
    @When("I send a POST request to create the user {string}")
    public void iSendAPOSTRequestToCreateTheUserUser(String endpoint){
        response = methodsPage.makeRequestPost(endpoint, payload);
        statusCode = response.getStatusCode();
    }

    /**
     * Step definition for the Then clause: "I should get a {int} status code".
     * Asserts that the response status code matches the expected status code.
     *
     * @param status_code_bdd The expected status code from the scenario.
     */
    @Then("I should get a {int} status code")
    public void iShouldGetA200StatusCode(int status_code_bdd){
        Assert.assertEquals(status_code_bdd, statusCode, "The status code should be 200 or 201");
    }

    /**
     * Step definition for the Then clause: "the response should confirm the user was created successfully".
     * Asserts that the response body contains the generated username.
     */
    @Then("the response should confirm the user was created successfully")
    public void theResponseShouldConfirmTheUserWasCreatedSuccessfully(){
        Assert.assertTrue(response.asString().contains(fakeUsername), "The response should contain: " + fakeUsername);
    }

    /**
     * Step definition for the Given clause: "I have the API endpoint to get user details by username".
     */
    @Given("I have the API endpoint to get user details by username")
    public void iHaveTheAPIEndpointToGetUserdetailsByUsername(){
        System.out.println("Test Started");
    }

    /**
     * Step definition for the When clause: "I send a GET request to retrieve the user {string}".
     * Sends a GET request to retrieve user details.
     *
     * @param endpoint_bdd The endpoint to send the GET request to, including a placeholder for the username.
     */
    @When("I send a GET request to retrieve the user {string}")
    public void iSendAGETRequestToRetrieveTheUserUser(String endpoint_bdd){
        response = methodsPage.makeRequestGet(endpoint_bdd+fakeUsername);
        statusCode = response.getStatusCode();
    }

    /**
     * Step definition for the Then clause: "the response should contain the details of the specified user".
     * Asserts that the response contains the generated username.
     */
    @Then("the response should contain the details of the specified user")
    public void theResponseShouldContainTheDetailsOfTheSpecifiedUser(){
        Assert.assertTrue(response.asString().contains(fakeUsername), "The response should contain the message: " + fakeUsername);
    }

    /**
     * Step definition for the Given clause: "I have the API endpoint to log in a user".
     */
    @Given("I have the API endpoint to log in a user")
    public void iHaveTheAPIEndpointToLogInAUser(){
        System.out.println("Test Started");
    }

    /**
     * Step definition for the When clause: "I send a GET request to log in the user with the valid username and password".
     * Sends a GET request to the user login endpoint with valid username and password.
     */
    @When("I send a GET request to log in the user with the valid username and password")
    public void iSendAGETRequestToLogInTheUserWithTheValidUsernameAndPassword(){
        response = methodsPage.makeRequestGet("user/login?username="+fakeUsername+"&password="+fakePassword);
        statusCode = response.getStatusCode();
    }

    /**
     * Step definition for the Then clause: "the response should confirm the {string}".
     * Asserts that the response contains the expected message.
     *
     * @param message_bdd The expected message to find in the response.
     */
    @Then("the response should confirm the {string}")
    public void theResponseShouldConfirmTheLoggedInUserSession(String message_bdd){
        Assert.assertTrue(response.asString().contains(message_bdd), "The response should contain the message: " + message_bdd);
    }

    /**
     * Step definition for the Given clause: "I have the API endpoint to log out the current logged in user".
     */
    @Given("I have the API endpoint to log out the current logged in user")
    public void iHaveTheAPIEndpointToLogOutTheCurrentLoggedInUser(){
        System.out.println("Test Started");
    }

    /**
     * Step definition for the When clause: "I send a GET request to log out the user {string}".
     * Sends a GET request to the logout endpoint.
     *
     * @param endpoint_bdd The logout endpoint.
     */
    @When("I send a GET request to log out the user {string}")
    public void iSendAGETRequestToLogOutTheUserUserLogout(String endpoint_bdd){
        response = methodsPage.makeRequestGet(endpoint_bdd);
        statusCode = response.getStatusCode();
    }
}