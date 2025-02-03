package steps.integration.sprint2;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.example.pages.MethodsPage;
import org.testng.Assert;

/**
 * Cucumber step definitions for searching pets by tags and status.
 * This class contains steps to search pets by tags, status, and ID.
 */
public class HU_SearchPetsByTagsAndStatus {

    private final MethodsPage methodsPage = new MethodsPage();

    private Response response;
    private int statusCode;

    /**
     * Step definition for the Given clause: "I have the API endpoint to search pets by tags".
     */
    @Given("I have the API endpoint to search pets by tags")
    public void iHaveTheAPIEndpointToSearchPetsByTags(){
        System.out.println("Test Started");
    }

    /**
     * Step definition for the When clause: "I send a GET request to {string} with the valid tag {string}".
     * Sends a GET request to search for pets by tag.
     *
     * @param endpoint_bdd The API endpoint to make the GET request to.
     * @param tag_bdd      The tag to search by.
     */
    @When("I send a GET request to {string} with the valid tag {string}")
    public void iSendAGETRequestToPetFindByTagsWithTheValidTagFriendly(String endpoint_bdd, String tag_bdd){
        response = methodsPage.makeRequestGet(endpoint_bdd + tag_bdd);
        statusCode = response.getStatusCode();
    }

    /**
     * Step definition for the When clause: "I send a GET request to {string} with the invalid tag {string}".
     * Sends a GET request to search for pets by tag.
     *
     * @param endpoint_bdd The API endpoint to make the GET request to.
     * @param tag_bdd      The tag to search by.
     */
    @When("I send a GET request to {string} with the invalid tag {string}")
    public void iSendAGETRequestToPetFindByTagsWithTheInvalidTagFriendly(String endpoint_bdd, String tag_bdd){
        response = methodsPage.makeRequestGet(endpoint_bdd + tag_bdd);
        statusCode = response.getStatusCode();
    }

    /**
     * Step definition for the Then clause: "the response should contain {string}".
     * Asserts that the response body contains the expected message.
     *
     * @param message_bdd The message to find in the response.
     */
    @Then("the response should contain {string}")
    public void theResponseShouldContainArrayList(String message_bdd){
        Assert.assertTrue(response.asString().contains(message_bdd), "The response should contain the message 'ArrayList'");
    }

    /**
     * Step definition for the Then clause: "I should receive a {int} status code".
     * Asserts that the response status code matches the expected status code.
     *
     * @param status_code_bdd The expected status code from the scenario.
     */
    @Then("I should receive a {int} status code")
    public void iShouldReceiveA200StatusCode(int status_code_bdd){
        Assert.assertEquals(status_code_bdd, statusCode, "The status code should be 200 or 201");
    }

    /**
     * Step definition for the Given clause: "I have the API endpoint to search for pets by status".
     */
    @Given("I have the API endpoint to search for pets by status")
    public void iHaveTheAPIEndpointToSearchForPetsByStatus(){
        System.out.println("Test Started");
    }

    /**
     * Step definition for the When clause: "I send a GET request to {string} with the valid status {string}".
     * Sends a GET request to search for pets by status.
     *
     * @param endpoint_bdd The API endpoint to make the GET request to.
     * @param tag_bdd      The status to search by.
     */
    @When("I send a GET request to {string} with the valid status {string}")
    public void iSendAGETRequestToPetFindByStatusWithTheValidStatusAvailable(String endpoint_bdd, String tag_bdd){
        response = methodsPage.makeRequestGet(endpoint_bdd + tag_bdd);
        statusCode = response.getStatusCode();
    }

    /**
     * Step definition for the When clause: "I send a GET request to {string} with the invalid status {string}".
     * Sends a GET request to search for pets by status.
     *
     * @param endpoint_bdd The API endpoint to make the GET request to.
     * @param tag_bdd      The status to search by.
     */
    @When("I send a GET request to {string} with the invalid status {string}")
    public void iSendAGETRequestToPetFindByStatusWithTheInvalidStatusAvailable(String endpoint_bdd, String tag_bdd){
        response = methodsPage.makeRequestGet(endpoint_bdd + tag_bdd);
        statusCode = response.getStatusCode();
    }

    /**
     * Step definition for the Given clause: "I have the API endpoint to find a pet by ID".
     */
    @Given("I have the API endpoint to find a pet by ID")
    public void iHaveTheAPIEndpointToFindAPetByID(){
        System.out.println("Test Started");
    }

    /**
     * Step definition for the When clause: "I send a GET request to {string} with the pet ID {string}".
     * Sends a GET request to search for a pet by ID.
     *
     * @param endpoint_bdd The API endpoint to make the GET request to.
     * @param tag_bdd      The ID of the pet.
     */
    @When("I send a GET request to {string} with the pet ID {string}")
    public void iSendAGETRequestToPetWithThePetID99999(String endpoint_bdd, String tag_bdd){
        response = methodsPage.makeRequestGet(endpoint_bdd + tag_bdd);
        statusCode = response.getStatusCode();
    }
}