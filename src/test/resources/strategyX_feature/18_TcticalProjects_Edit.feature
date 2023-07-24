Feature: Tactical Project
@JIRA
Scenario: Update tactical Project

Given i go to tactical Projects module
When i click on tactical Project name
And i enter description to update tactical Project as "updated description"
And click on saveAndExit to update tactical Project
And click on "Yes" for Will you meet this deadline? under tactical Project
Then tactical Project description should be "updated description"