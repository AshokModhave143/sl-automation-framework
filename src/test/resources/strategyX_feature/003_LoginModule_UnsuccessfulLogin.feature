Feature: to verify StrategyX login is working 
@JIRA
Scenario: UnsuccessfulLogin StrategyX website	
	Given i go to StrategyX Login page 
	When i fill in username with "diksha@stream-line.com.au" 
	And  i fill in password with "Allthebest12" 
	And i press login button	
	Then i should get error message as "Invalid username or password, try again"