Feature: Search pets by various criteria
  As a user of the Swagger Petstore API
  I want to search for pets using different criteria
  So that I can find pets based on their tags, status, or ID

  @happy-path @integration-test
  Scenario: Find pets by tags
    Given I have the API endpoint to search pets by tags
    When I send a GET request to "pet/findByTags?tags=" with the valid tag "Friendly"
    Then I should receive a 200 status code
    Then the response should contain "Friendly"

  @error-path @integration-test
  Scenario: Find pets by tags with an invalid tag
    Given I have the API endpoint to search pets by tags
    When I send a GET request to "pet/findByTags?tags=" with the invalid tag ""
    Then I should receive a 400 status code
    Then the response should contain "No tags provided. Try again?"

  @happy-path @integration-test
  Scenario: Find pets by status
    Given I have the API endpoint to search for pets by status
    When I send a GET request to "pet/findByStatus?status=" with the valid status "available"
    Then I should receive a 200 status code
    Then the response should contain "available"

  @error-path @integration-test
  Scenario: Find pets by status with an invalid status
    Given I have the API endpoint to search for pets by status
    When I send a GET request to "pet/findByStatus?status=" with the invalid status "available"
    Then I should receive a 200 status code
    Then the response should contain "available"

  @happy-path @integration-test
  Scenario: Find pet by ID with a valid ID
    Given I have the API endpoint to find a pet by ID
    When I send a GET request to "pet/" with the pet ID "1"
    Then I should receive a 200 status code
    Then the response should contain "Pet"

  @error-path @integration-test
  Scenario: Find pet by ID with an invalid ID
    Given I have the API endpoint to find a pet by ID
    When I send a GET request to "pet/" with the pet ID "99999"
    Then I should receive a 404 status code
    Then the response should contain "Pet not found"
