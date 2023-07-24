Feature: to create user 

Scenario: Create user with personal details
Given i click on people
And i click on create button
And i fill first_name with "Diksha"
And i fill last_name with "salwe"
And i fill gender as "Female"
And i fill DOB with "2021-02-12"
And i fill dawang as "balaburr"
And i fill mothers_name "Lata"
And i fill fathers_name "Santosh"
And i fill community "test"
And i fill street "76 wakefield street"

And click on save button
Then person should get created

