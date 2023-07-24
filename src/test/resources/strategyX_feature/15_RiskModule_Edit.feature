Feature: Risk
@JIRA
Scenario: Update Risk

Given i go to risk module
When i click on Risk name
And i enter description to update Risk as "updated description"
And click on saveAndExit to update Risk
And click on "Yes" for Will you meet this deadline?
Then Risk description should be "updated description"