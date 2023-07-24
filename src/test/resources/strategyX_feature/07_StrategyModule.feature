Feature: Strategy 

Scenario: add Strategy 
	Given i am on strategy page 
	When edit vision
	And edit mission
	And edit values
	And edit culture
	And edit strengths
	And edit weaknesses
	And edit opportunities
	And edit threats
	And edit core competencies
	And edit core business
		
	
	Then strategy is added 
