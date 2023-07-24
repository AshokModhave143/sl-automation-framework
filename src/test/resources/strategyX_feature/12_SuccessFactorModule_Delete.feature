Feature: Success Factor

Scenario: delete added success factor
	Given i go to Success Factor Module
	When click on three datatable dots
	And click on delete button
	And click on yes button
	Then success factor should get deleted