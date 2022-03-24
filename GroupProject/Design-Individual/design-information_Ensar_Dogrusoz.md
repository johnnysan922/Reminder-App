# Design Information

1. A list consisting of reminders the users want to be aware of. The application must allow users to add reminders to a list, delete reminders from a list, and edit the reminders in the list. 

-achieved by creating a list of Reminders, where Reminders is an entity in itself. ListReminders has methods to add, delete and edit reminders. 

2. The application must contain a databse (DB) of reminders and corresponding data. 

-in the UML diagram its labeled as database of reminders, it stores the reminders and corresponding data from other tables. 

3. Users must be able to add reminder to a list by picking them from a hierachical list, where the first level is the reminder type(e.g. Appointment), and the second level is the name of the actual reminder (e.g., Dentist Appointment).

-In ListReminders, one of the Attributes of the list is the ReminderListType where we can specify the trpe of reminder. the reminder class also has a Type and Name attribute.

4. Users must also be able to specify a reminder by typing it's name. In this case, the application must look in its DB for reminders with similar names and ask the user whether that is the item they intended to add. If a match (or nearby match) cannot be found, the application must ask the user to select a reminder type for the reminder or add a new one, and then save the new reminder, together with its type in the DB.

-When the user starts typing the application can search the database if reminders already exist, if so then it can suggest the reminders and save it thereafter. 

5. The reminders must be saved automatically and immediately after they are modified.

-ListReminders has a method saveReminderList which saves the list automatically as it is called after every method. 

6. Users must be able to check off reminders in the list (without deleting them).

-I added a method called checkOffReminders, which would represent the user checking off the reminder to show that the reminder has been completed. This does not delete the reminder. 

7. Users must also be able to clear all the check-off marks in the reminder list at once. 

- The method clearCheckOff in the ListReminders allows the user to uncheck all the reminders in the lists. 

8. Check-off marks for the reminder list are persistent and must also be saved immediately. 

-SaveReminderList gets called after the use of each method in the ListReminders. so the status gets saved everytime 

9. The application must present the reminders grouped by type. 

-I added ReminderListType as an attribute to ListReminders. so its possible to sort the list using the ReminderListType. 

10. The application must support multiple reminder lists at a time (e.g., “Weekly”, “Monthly”, “Kid’s Reminders”). Therefore, the application must provide the users with the ability to
create, (re)name, select, and delete reminder lists.

-This is done by creating a new class called ListView, which manages the ListReminders. It has methods to create lists, rename lists, select lists, and delete lists. 

11. The application should have the option to set up reminder with day and time alert. If this option is slected allow option to repeat the behavior. 

-I made a Alerts class for this. Each reminder has an Alert which has a date and time attribute. It also has a repeatable boolean which sees if the alert is repeated or not. 

12. Extra Credit: Option to set up reminder based on location.

-Not considered

13. The User Interface (UI) must be intuitive and responsive. 

-Not considered because it does not affect the design. 