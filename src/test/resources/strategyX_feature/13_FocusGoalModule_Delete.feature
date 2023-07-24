Feature: Focus Goals
@JIRA
Scenario: delete added Focus Goals
	Given i go to focus goal module
	When click on three datatable dots to delete Focus Goals
	And click on delete button to delete Focus Goals
	Then Focus Goals should get deleted