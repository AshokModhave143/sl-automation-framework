Feature: Approval Module
@JIRA
Scenario: Login with staff account

Given i go to StrategyX Login page
When i fill in username with "teststaff@strategyexe.com" 
And  i fill in password with "csnZqNCT" 
And i press login button	


Scenario: add action with staff and sent for approval to manager

Given i am already on Action Page   
   When i go to add action button
   And i enter title for add action as "TODAY"
   And i fill in the following:     
      |Description| Test123    |
      |Assigned To|Test Staff  |
      |Approved By|Test Manager|
      |Due Date   |xyzbs       |
      |Notes      | hello there|
   And i press Save&Exit
   Then i should see added action in ActionList
   
Given  i am already on Action Page
  And i click on percentage complete
 And i click on 100 percent to complete in this task
 And i click on save button
  And Logout from application
  
  
 
 Scenario: Login with manager account and approve request

Given i go to StrategyX Login page
When i fill in username with "testmanager@strategyexe.com" 
And  i fill in password with "UYLYt!h6@4bZm" 
And i press login button
And i go to approvals module
And i click on for your approval button
And i click on approve button under action for selected task
Then verify the results present on for your approval page

  
 