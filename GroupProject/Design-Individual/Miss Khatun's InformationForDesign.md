## Information about Assignment 5 Software Design
### 1. A list consisting of reminders the users want to be aware of. The application must allow users to add reminders to a list, delete reminders from a list, and edit the reminders in the list.
### Response: This class is named as ListReminders which has the method to add a reminder, edit a reminder, delete a reminder and check off a reminder.

### 2. The application must contain a database (DB) of reminders and corresponding data.
### Response: Mentioned but not implemented which is receiving information from the list and ListReminders.

### 3. Users must be able to add reminders to a list by picking them from a hierarchical list, where the first level is the reminder type (e.g., Appointment), and the second level is the name of the actual reminder (e.g., Dentist Appointment).
### Response: This was implemented using addReminders in the class ListReminders and there is a class called ReminderTypes where the user can choose the type of reminders as they set up a new reminder.

### 4. Users must also be able to specify a reminder by typing its name. In this case, the application must look in its DB for reminders with similar names and ask the user whether that is the item they intended to add. If a match (or nearby match) cannot be found, the application must ask the user to select a reminder type for the reminder, or add a new one, and then save the new reminder, together with its type, in the DB.
### Response: Did not implemented this, as mentioned in the assignment paper.

### 5. The reminders must be saved automatically and immediately after they are modified.
### Response: Once a reminder is created, the listReminder class will automatically save the information in the database.

### 6. Users must be able to check off reminders in the list (without deleting them).
### Response: Object has a Reminder class with a type attribute of boolean that is checkedOff which will help the user to be able to check off reminders in the list without deleting them.


### 7. Users must also be able to clear all the check-off marks in the reminder list at once.
### Response: There is a class called ListReminders, which can be used to check off the reminders that the user have completed from the list.

### 8. Check-off marks for the reminder list are persistent and must also be saved immediately.
### Response: The checkOff attribute in the class will immediately save the information into the database.

### 9. The application must present the reminders grouped by type.
### Response: ReminderType attribute that is saved with the reminder will make each reminder to be grouped by their reminder type.

### 10. The application must support multiple reminder lists at a time (e.g., “Weekly”, “Monthly”, “Kid’s Reminders”). Therefore, the application must provide the users with the ability to create, (re)name, select, and delete reminder lists.
### Response: There is a class called Repeat which the Reminder class will use to set their reminder according to their preference.

### 11. The application should have the option to set up reminders with day and time alert. If this option is selected allow option to repeat the behavior.
### Response: The Reminder and Repeat class takes care of this, the reminder class has the attribute allDay, Date and time which will constantly remind them of their reminder.