Feature: Tactical Projects
@JIRA
Scenario: delete added tactical project
	Given i go to tactical Projects module
	When click on three datatable dots under tactical project module
	And click on delete button under tactical project module
	Then added tactical project should get deleted