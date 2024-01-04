Feature: Add User
Scenario: Creating the multiple user 

Given user launch browser
    When user opens Url "https://opensource-demo.orangehrmlive.com"
    #When user enters username as "Admin" and password as "admin123"
    When user enters credentials
      | Admin | admin123 |
    When click on login button
    Then dashboard should be displayed
    When user clicks on Admin section and Add button
    When user enters all user details
      | Username | Password   | ConfirmPassword | EmployeeName |
      | Kamal    | Kam@123456 | Kam@123456      | ac           |
      | Pavadi   | Pav@123456 | Pav@123456      |ad            |
    When user clicks save button
