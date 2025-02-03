package steps.integration.sprint2;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.example.pages.MethodsPage;
import org.testng.Assert;

public class HU_SearchPetsByTagsAndStatus {

    private final MethodsPage methodsPage = new MethodsPage();

    private Response response;
    private int statusCode;

    @Given("I have the API endpoint to search pets by tags")
    public void iHaveTheAPIEndpointToSearchPetsByTags(){
        System.out.println("Test Started");
    }

    @When("I send a GET request to {string} with the valid tag {string}")
    public void iSendAGETRequestToPetFindByTagsWithTheValidTagFriendly(String endpoint_bdd, String tag_bdd){
        response = methodsPage.makeRequestGet(endpoint_bdd + tag_bdd);
        statusCode = response.getStatusCode();
    }

    @When("I send a GET request to {string} with the invalid tag {string}")
    public void iSendAGETRequestToPetFindByTagsWithTheInvalidTagFriendly(String endpoint_bdd, String tag_bdd){
        response = methodsPage.makeRequestGet(endpoint_bdd + tag_bdd);
        statusCode = response.getStatusCode();
    }

    @Then("the response should contain {string}")
    public void theResponseShouldContainArrayList(String message_bdd){
        Assert.assertTrue(response.asString().contains(message_bdd), "The response should contain the message 'ArrayList'");
    }

    @Then("I should receive a {int} status code")
    public void iShouldReceiveA200StatusCode(int status_code_bdd){
        Assert.assertEquals(status_code_bdd, statusCode, "The status code should be 200 or 201");
    }

    @Given("I have the API endpoint to search for pets by status")
    public void iHaveTheAPIEndpointToSearchForPetsByStatus(){
        System.out.println("Test Started");
    }

    @When("I send a GET request to {string} with the valid status {string}")
    public void iSendAGETRequestToPetFindByStatusWithTheValidStatusAvailable(String endpoint_bdd, String tag_bdd){
        response = methodsPage.makeRequestGet(endpoint_bdd + tag_bdd);
        statusCode = response.getStatusCode();
    }

    @When("I send a GET request to {string} with the invalid status {string}")
    public void iSendAGETRequestToPetFindByStatusWithTheInvalidStatusAvailable(String endpoint_bdd, String tag_bdd){
        response = methodsPage.makeRequestGet(endpoint_bdd + tag_bdd);
        statusCode = response.getStatusCode();
    }

    @Given("I have the API endpoint to find a pet by ID")
    public void iHaveTheAPIEndpointToFindAPetByID(){
        System.out.println("Test Started");
    }

    @When("I send a GET request to {string} with the pet ID {string}")
    public void iSendAGETRequestToPetWithThePetID99999(String endpoint_bdd, String tag_bdd){
        response = methodsPage.makeRequestGet(endpoint_bdd + tag_bdd);
        statusCode = response.getStatusCode();
    }
}
