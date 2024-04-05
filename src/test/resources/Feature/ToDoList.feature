

Feature: To Do List feature of WebDriversUniversity website

 
  Scenario: Validating the To Do List
    Given The URL of the website
    When Scroll into view, the to do list option is there
    Then Click on To Do List button
    Then Switch to other Tab
    Then Add to new items in the To-do List <"Complete Jira Course">, <"Case Study">
    Then Print all the items of the list
    Then Delete the newly added items of the list
    Then Validate Delete Successfully
    

  
