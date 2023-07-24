Feature: Success Factor

Scenario: add Success Factor
Given i go to Success Factor Module
When i click on add button
And enter success factor as "Today"
And enter Assigned To 
And enter report title 
And enter graph type
And click on save & exit
Then Success Factor should get added



