Feature: Focus Goal

Scenario: Add Action under Focus Goal

Given i go to focus goal module
When i click on three dots
And click on add action button
And enter title as "add action with todays date"
And enter assignedTo action under Focus Goal as "Diksha"
And enter approvedBy action under Focus Goal as "Diksha"
And enter due Date action under Focus Goal
And click on save button action under Focus Goal

Then action should get added as "add action 08-01-2021"

