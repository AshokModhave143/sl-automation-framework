Feature: Success factor

Scenario: Update Success factor

Given i go to Success Factor Module
When i click on success factors name
And i enter description to update success factor as "updated description"
And click on saveAndExit to update success factor
Then success factor description should be "updated description"
