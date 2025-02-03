Feature: Manage pets in the Swagger Petstore API
  As a user of the Swagger Petstore API
  I want to manage pets in the store
  So that I can perform CRUD operations (Create, Read, Update, Delete) on pets

  Background: The user has access to the Swagger Petstore API
    Given the user has access to the Swagger Petstore API

  @happy-path @integration-test
  Scenario: The user successfully adds a pet with a valid ID 1
    When the user makes a POST request to "pet" with valid pet data, including the name "Lucky", status "placed" and ID "1"
    Then the response should have a status code of 200
    Then the response body should contain the ID of the new pet

  @happy-path @integration-test
  Scenario: The user successfully adds a pet with a valid ID 2
    When the user makes a POST request to "pet" with valid pet data, including the name "Tommy", status "approved" and ID "2"
    Then the response should have a status code of 200
    Then the response body should contain the ID of the new pet

  @alternative-path @integration-test
  Scenario: Update an existing pet
    Given I have the ID "1" of an existing pet to update
    When I send a request to "pet" update the pet status to "pending"
    Then the pet details should be updated successfully

  @happy-path @integration-test
    Scenario: The user successfully deletes a pet with ID 2
        When the user makes a DELETE request to "pet/" with the ID "2"
        Then the response should have a status code of 200
        Then the response body should contain the message "Pet deleted"