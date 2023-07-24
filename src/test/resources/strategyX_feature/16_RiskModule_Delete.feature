Feature: Risk
@JIRA
Scenario: delete added Risk
	Given i go to risk module
	When click on three datatable dots under risk module
	And click on delete button under risk module
	Then added risk should get deleted