Feature: to add action in ActionList
@JIRA
Scenario: Add Action in ActionList
   Given i am already on Action Page   
   When i go to add action
   And i fill in the following details:     
      |Title         |Action1     |
      |Description   |Test123     |
      |Assigned To   |Diksha      |
      |Approved By   |Diksha      |
      |Due Date      |xyzbs       |
      |Notes         |hello there |
      |Duration      |05:30       |
      |Work Date     |abcd        |
      |Add Voice Note|abcd        |
      |Add Attachment|            |
      |Subtask Name  | test12345  |

   And i press Save&ExitButton
   Then i should see new added action in ActionList
   
    