Feature: Registration
@JIRA
Scenario: to verify registartion functionality

Given i go to StrategyX registarion page

When i click on create account button
And i enter first name under personal details as "Diksha"
And i enter last name under personal details as "Salwe"
And i enter email address under personal details as "bcd@stream-line.com.au"
And i enter country code under personal details as "+64 ( NZ )"
And i enter mobile number under personal details as "225003417"
And i enter company name as "test company details4"
And i enter time zone under company details as "Mexico - America/Tijuana"

And i click on next button

Then user should be able to navigate to verify mobile page


