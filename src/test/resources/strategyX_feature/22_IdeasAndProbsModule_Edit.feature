Feature: IdeasAndProbs
@JIRA
Scenario: Update IdeasAndProbs

Given i go to idea and probs module
When i click on IdeasAndProbs name
And i enter description to update IdeasAndProbs as "updated description"
And click on saveAndExit to update IdeasAndProbs
Then IdeasAndProbs description should be "updated description"