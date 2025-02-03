Feature: End-to-End User Management in the Swagger Petstore API
  As a user of the Swagger Petstore API
  I want to create, retrieve, log in, and log out a user
  So that I can test the entire user management flow from start to finish

  @happy-path @e2e
  Scenario: Create, retrieve, log in, and log out a user in one test
    Given I have the API endpoint to create a new user
    Then I provide a valid JSON payload with user details
    When I send a POST request to create the user "user"
    Then I should get a 200 status code
    Then the response should confirm the user was created successfully

    Given I have the API endpoint to get user details by username
    When I send a GET request to retrieve the user "user/"
    Then I should get a 200 status code
    Then the response should contain the details of the specified user

    Given I have the API endpoint to log in a user
    When I send a GET request to log in the user with the valid username and password
    Then I should get a 200 status code
    Then the response should confirm the "Logged in user session"

    Given I have the API endpoint to log out the current logged in user
    When I send a GET request to log out the user "user/logout"
    Then I should get a 200 status code
    Then the response should confirm the "User logged out"
