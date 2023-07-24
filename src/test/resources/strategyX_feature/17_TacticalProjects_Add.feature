Feature: Tactical Projects
@JIRA
Scenario: add tactical Projects

Given i go to tactical Projects module   
   When i go to add tactical Projects
   And i fill in the following details under tactical Projects module:     
      |Project Name|Today         |
      |Category    |Cost Reduction|
      |Assigned To |Diksha        |
      |Approved By |Diksha        |
      |Due Date    |              |
      |Department  |              |
             
   And i click on saveandExit button under tactical Projects
   And click on No button for adding first action while adding tactical Project
   Then verify if tactical Project is added as "todays date"
