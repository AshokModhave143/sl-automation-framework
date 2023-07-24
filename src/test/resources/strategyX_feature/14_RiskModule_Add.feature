Feature: Risk
@JIRA
Scenario: add risk

 Given i go to risk module   
   When i go to add risk
   And i fill in the following details under risk module:     
      |Unwanted Event         |Today                  |
      |Consequence category   |Health                 |
      |Risk Category          |Economic and Financial |
      |Risk Sub Category      |Global Financial Events|
      |Assigned To            |Diksha                 |
      |Approved By            |Diksha                 |
      |Due Date               |                       |
      |Department             | test12345             |
   And i give Inherent Risk rating
   And i give Residual Risk Rating
   And i click on saveandExit button
   And click on No button for adding first action while adding risk
   Then verify if risk is added as "Test Unwanted Even todays date"
