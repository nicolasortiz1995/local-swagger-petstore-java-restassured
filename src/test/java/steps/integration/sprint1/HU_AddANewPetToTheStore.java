package steps.integration.sprint1;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.example.pages.MethodsPage;
import org.testng.Assert;
import utils.GeneratePayloads;
import utils.GlobalVariables;

/**
 * Cucumber step definitions for pet management operations.
 * This class contains steps to create, update, and delete pets in the pet store.
 */
public class HU_AddANewPetToTheStore {

    private final MethodsPage methodsPage = new MethodsPage();

    private Response response;
    private int statusCode;

    /**
     * Step definition for the Given clause: "the user has access to the Swagger Petstore API".
     */
    @Given("the user has access to the Swagger Petstore API")
    public void theUserHasAccessToTheSwaggerPetstoreAPI(){
        System.out.println("Test Started");
    }

    /**
     * Step definition for the When clause: "the user makes a POST request to {string} with valid pet data, including the name {string}, status {string} and ID {string}".
     * Sends a POST request with generated pet data.
     *
     * @param endpoint      The API endpoint to make the POST request to.
     * @param name_pet_bdd  The name of the pet.
     * @param status_pet_bdd The status of the pet.
     * @param id_pet_bdd    The ID of the pet.
     */
    @When("the user makes a POST request to {string} with valid pet data, including the name {string}, status {string} and ID {string}")
    public void theUserMakesAPOSTRequestToPetsWithValidPetDataIncludingTheNameLuckyAndID1(String endpoint, String name_pet_bdd, String status_pet_bdd, String id_pet_bdd) {
        String payload = GeneratePayloads.generatePayloadForCreatePet(name_pet_bdd, status_pet_bdd, id_pet_bdd);
        response = methodsPage.makeRequestPost(endpoint, payload);
        statusCode = response.getStatusCode();
    }

    /**
     * Step definition for the Then clause: "the response should have a status code of {int}".
     * Asserts that the response status code matches the expected status code.
     *
     * @param status_code_bdd The expected status code from the scenario.
     */
    @Then("the response should have a status code of {int}")
    public void theResponseShouldHaveAStatusCodeOf200(int status_code_bdd){
        Assert.assertEquals(status_code_bdd, statusCode, "The status code should be 200 or 201");
    }

    /**
     * Step definition for the Then clause: "the response body should contain the ID of the new pet".
     * Asserts that the response body contains the ID for category of the new pet
     */
    @Then("the response body should contain the ID of the new pet")
    public void theResponseBodyShouldContainTheIDOfTheNewPet(){
        Assert.assertTrue(response.asString().contains("<category><id>1</id>"), "The XML should contain the ID '1' within the category.");
    }

    /**
     * Step definition for the Given clause: "I have the ID {string} of an existing pet to update".
     * Stores the provided pet ID in a global variable for later use.
     *
     * @param id_pet_bdd The ID of the pet to update.
     */
    @Given("I have the ID {string} of an existing pet to update")
    public void iHaveTheID1OfAnExistingPetToUpdate(String id_pet_bdd){
        GlobalVariables.idPet = id_pet_bdd;
    }

    /**
     * Step definition for the When clause: "I send a request to {string} update the pet status to {string}".
     * Sends a PUT request to update the pet's status.
     *
     * @param endpoint       The endpoint to send the PUT request to.
     * @param status_pet_bdd The new status of the pet.
     */
    @When("I send a request to {string} update the pet status to {string}")
    public void iSendARequestToUpdateThePetStatusToPending(String endpoint, String status_pet_bdd){
        String payload = GeneratePayloads.generatePayloadForUpdatePet(GlobalVariables.idPet, status_pet_bdd);
        response = methodsPage.makeRequestPut(endpoint, payload);
        GlobalVariables.statusPet = status_pet_bdd;
    }

    /**
     * Step definition for the Then clause: "the pet details should be updated successfully".
     * Asserts that the response body contains the updated pet status.
     */
    @Then("the pet details should be updated successfully")
    public void thePetDetailsShouldBeUpdatedSuccessfully(){
        Assert.assertTrue(response.asString().contains(GlobalVariables.statusPet), "The status should be 'pending'");
    }

    /**
     * Step definition for the When clause: "the user makes a DELETE request to {string} with the ID {string}".
     * Sends a DELETE request to remove the pet.
     *
     * @param endpoint_bdd The endpoint to send the DELETE request to.
     * @param id_pet_bdd   The ID of the pet to delete.
     */
    @When("the user makes a DELETE request to {string} with the ID {string}")
    public void theUserMakesADELETERequestToPetWithTheID2(String endpoint_bdd, String id_pet_bdd){
        response = methodsPage.makeRequestDelete(endpoint_bdd + id_pet_bdd);
        statusCode = response.getStatusCode();
        GlobalVariables.idPet = id_pet_bdd;
    }

    /**
     * Step definition for the Then clause: "the response body should contain the message {string}".
     * Asserts that the response body contains a success message.
     *
     * @param message_deleted_bdd The expected message after deletion.
     */
    @Then("the response body should contain the message {string}")
    public void theResponseBodyShouldContainTheMessagePetDeleted(String message_deleted_bdd){
        Assert.assertTrue(response.asString().contains(message_deleted_bdd), "The response should contain the message 'Pet deleted'");

    }
}