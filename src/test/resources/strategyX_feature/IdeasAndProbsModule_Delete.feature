Feature: Idea
@JIRA
Scenario: to delete added idea

Given i go to idea and probs module
	When click on three datatable dots under idea module
	And click on delete button under idea module
	Then added idea should get deleted