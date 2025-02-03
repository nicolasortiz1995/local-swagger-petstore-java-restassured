package steps.integration.sprint1;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.example.pages.MethodsPage;
import org.testng.Assert;
import utils.GeneratePayloads;
import utils.GlobalVariables;

public class HU_AddANewPetToTheStore {

    private final MethodsPage methodsPage = new MethodsPage();

    private Response response;
    private int statusCode;

    @Given("the user has access to the Swagger Petstore API")
    public void theUserHasAccessToTheSwaggerPetstoreAPI(){
        System.out.println("Test Started");
    }

    @When("the user makes a POST request to {string} with valid pet data, including the name {string}, status {string} and ID {string}")
    public void theUserMakesAPOSTRequestToPetsWithValidPetDataIncludingTheNameLuckyAndID1(String endpoint, String name_pet_bdd, String status_pet_bdd, String id_pet_bdd) {
        String payload = GeneratePayloads.generatePayloadForCreatePet(name_pet_bdd, status_pet_bdd, id_pet_bdd);
        response = methodsPage.makeRequestPost(endpoint, payload);
        statusCode = response.getStatusCode();
    }

    @Then("the response should have a status code of {int}")
    public void theResponseShouldHaveAStatusCodeOf200(int status_code_bdd){
        Assert.assertEquals(status_code_bdd, statusCode, "The status code should be 200 or 201");
    }

    @Then("the response body should contain the ID of the new pet")
    public void theResponseBodyShouldContainTheIDOfTheNewPet(){
        Assert.assertTrue(response.asString().contains("<category><id>1</id>"), "The XML should contain the ID '1' within the category.");
    }

    @Given("I have the ID {string} of an existing pet to update")
    public void iHaveTheID1OfAnExistingPetToUpdate(String id_pet_bdd){
        GlobalVariables.idPet = id_pet_bdd;
    }

    @When("I send a request to {string} update the pet status to {string}")
    public void iSendARequestToUpdateThePetStatusToPending(String endpoint, String status_pet_bdd){
        String payload = GeneratePayloads.generatePayloadForUpdatePet(GlobalVariables.idPet, status_pet_bdd);
        response = methodsPage.makeRequestPut(endpoint, payload);
        GlobalVariables.statusPet = status_pet_bdd;
    }

    @Then("the pet details should be updated successfully")
    public void thePetDetailsShouldBeUpdatedSuccessfully(){
        Assert.assertTrue(response.asString().contains(GlobalVariables.statusPet), "The status should be 'pending'");
    }

    @When("the user makes a DELETE request to {string} with the ID {string}")
    public void theUserMakesADELETERequestToPetWithTheID2(String endpoint_bdd, String id_pet_bdd){
        response = methodsPage.makeRequestDelete(endpoint_bdd + id_pet_bdd);
        statusCode = response.getStatusCode();
        GlobalVariables.idPet = id_pet_bdd;
    }

    @Then("the response body should contain the message {string}")
    public void theResponseBodyShouldContainTheMessagePetDeleted(String message_deleted_bdd){
        Assert.assertTrue(response.asString().contains(message_deleted_bdd), "The response should contain the message 'Pet deleted'");

    }
}

