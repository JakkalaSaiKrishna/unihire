Feature: User Login Functionality

  Scenario: Successful login with valid credentials
    Given user is on the login page
    When user enters username as "hiringmanager@webpipl.com"
    And Click on Signin button in enter email page
    And Enter otp as "123456"
    And Click on Sign In button
    Then user should be redirected to the homepage
   
  Scenario: User doenot exist message should display when tries to register with not registed mail
    Given user is on the login page
    When user enters username as "hiringmanager@webpipl.com"
    And Click on Signin button in enter email page
    Then Validation error message should dsipay
    
