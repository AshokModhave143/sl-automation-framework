Feature: Edit Action module

@JIRA
Scenario: Edit Due date
	Given I go to action module to edit due date
    When I edit due date of action
	When  I edit priority date of action
	Then Due date should get updated
	And  Priority date should get updated
	