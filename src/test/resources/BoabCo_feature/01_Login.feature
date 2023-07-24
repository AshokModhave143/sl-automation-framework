Feature: to verify BoabCo login is working 

Scenario: Login BoabCo website	
	Given i go to BoabCo Login page 
	When i fill in username of BoabCo with "diksha@stream-line.com.au" 
	And  i fill in password of BoabCo with "Stage4321!" 
	And i press login button of BoabCo	
	Then i should see profile name of BoabCo as " "