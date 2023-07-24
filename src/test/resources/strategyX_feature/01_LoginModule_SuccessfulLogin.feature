Feature: to verify StrategyX login is working 

Scenario: Login StrategyX website	
	Given i go to StrategyX Login page 
	When i fill in username with "diksha@stream-line.com.au" 
	And  i fill in password with "Allthebest12@" 
	And i press login button	
	Then i should see profile name as "Stream-Line AU"
