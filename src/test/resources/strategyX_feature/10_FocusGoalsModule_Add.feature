Feature: Focus Goal

Scenario: Add focus goal

Given i go to focus goal module
When i click on add button under focus goal
And enter focus goal FROM as "TODAY"
And enter focus goal TO as "AFTER_15_DAYS"
And enter assignedTo as "Diksha"
And enter approvedBy as "Diksha"
And enter success factor for focus goal as "test TODAY"
And enter dueDate 
# due date is next week same day 5 p.m

And  click on saveAndExit
And click on No button for adding first action now

Then verify if focus goal is added as "Go from 12-01-2021 to 31-01-2021 test 11-01-2021 By 19-Jan-2021 05:00 PM"
