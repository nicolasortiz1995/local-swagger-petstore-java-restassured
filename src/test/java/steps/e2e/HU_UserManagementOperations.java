package steps.e2e;

import io.restassured.response.Response;
import org.example.pages.MethodsPage;
import utils.DataGenerator;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import utils.GeneratePayloads;

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

    @Given("I have the API endpoint to create a new user")
    public void iHaveTheAPIEndpointToCreateANewUser(){
        System.out.println("Test Started");
    }

    @Then("I provide a valid JSON payload with user details")
    public void iProvideAValidJSONPayloadWithUserDetails(){
        payload = GeneratePayloads.generatePayloadForCreateUser(fakeId, fakeUsername, fakeFirstName, fakeLastName, fakeEmail, fakePassword, fakePhoneNumber);
    }

    @When("I send a POST request to create the user {string}")
    public void iSendAPOSTRequestToCreateTheUserUser(String endpoint){
        response = methodsPage.makeRequestPost(endpoint, payload);
        statusCode = response.getStatusCode();
    }

    @Then("I should get a {int} status code")
    public void iShouldGetA200StatusCode(int status_code_bdd){
        Assert.assertEquals(status_code_bdd, statusCode, "The status code should be 200 or 201");
    }

    @Then("the response should confirm the user was created successfully")
    public void theResponseShouldConfirmTheUserWasCreatedSuccessfully(){
        Assert.assertTrue(response.asString().contains(fakeUsername), "The response should contain: " + fakeUsername);
    }

    @Given("I have the API endpoint to get user details by username")
    public void iHaveTheAPIEndpointToGetUserdetailsByUsername(){
        System.out.println("Test Started");
    }

    @When("I send a GET request to retrieve the user {string}")
    public void iSendAGETRequestToRetrieveTheUserUser(String endpoint_bdd){
        response = methodsPage.makeRequestGet(endpoint_bdd+fakeUsername);
        statusCode = response.getStatusCode();
    }

    @Then("the response should contain the details of the specified user")
    public void theResponseShouldContainTheDetailsOfTheSpecifiedUser(){
        Assert.assertTrue(response.asString().contains(fakeUsername), "The response should contain the message: " + fakeUsername);
    }

    @Given("I have the API endpoint to log in a user")
    public void iHaveTheAPIEndpointToLogInAUser(){
        System.out.println("Test Started");
    }

    @When("I send a GET request to log in the user with the valid username and password")
    public void iSendAGETRequestToLogInTheUserWithTheValidUsernameAndPassword(){
        response = methodsPage.makeRequestGet("user/login?username="+fakeUsername+"&password="+fakePassword);
        statusCode = response.getStatusCode();
    }

    @Then("the response should confirm the {string}")
    public void theResponseShouldConfirmTheLoggedInUserSession(String message_bdd){
        Assert.assertTrue(response.asString().contains(message_bdd), "The response should contain the message: " + message_bdd);
    }

    @Given("I have the API endpoint to log out the current logged in user")
    public void iHaveTheAPIEndpointToLogOutTheCurrentLoggedInUser(){
        System.out.println("Test Started");
    }

    @When("I send a GET request to log out the user {string}")
    public void iSendAGETRequestToLogOutTheUserUserLogout(String endpoint_bdd){
        response = methodsPage.makeRequestGet(endpoint_bdd);
        statusCode = response.getStatusCode();
    }

}
