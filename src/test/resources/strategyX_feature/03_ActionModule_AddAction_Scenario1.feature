Feature: to add action in ActionList

Scenario: Add Action in ActionList

   Given i am already on Action Page   
   When i go to add action button
   And i enter title for add action as "TODAY"
   And i fill in the following:     
      |Description| Test123    |
      |Assigned To|Diksha      |
      |Approved By|Diksha      |
      |Due Date   |xyzbs       |
      |Notes      | hello there|
   And i press Save&Exit
   Then i should see added action in ActionList
   
    