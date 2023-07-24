Feature: to verify Flashwork login is working 

Scenario: Login Flashwork website 
	#Given I go to StrategyX Login page 
	#When I enter username and password 
	#And click LoginButton	
	#Then StrategyX login should be successful 
	
	Given i go to Flashwork Login page 
	When i fill in username with "dikshasalwe" 
	And  i fill in password with "Allthebest12@" 
	And i press login button	
	Then i should see "WELCOME TO PLANORATE"

	
	
	
	