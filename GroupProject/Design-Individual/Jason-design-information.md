1. A list consisting of reminders the users want to be aware of. The application must allow
   users to add reminders to a list, delete reminders from a list, and edit the reminders in
   the list.

To realize this requirement I added classes Reminder which allows you to add reminder edit the reminder time.

2. The application must contain a database (DB) of reminders and corresponding data.

To realize this requirement I created three classes ReminderLists, ReminderType, and Reminder. ReminderLists is the overall name of the list which contains all the reminders groups by types and those contain the actual reminder inside

3. Users must be able to add reminders to a list by picking them from a hierarchical list,
   where the first level is the reminder type (e.g., Appointment), and the second level is the
   name of the actual reminder (e.g., Dentist Appointment).

To allow users to add reminders to a list we have the class users which allows users to call the main reminderlists class, remindertypes class, and reminder class

4. Users must also be able to specify a reminder by typing its name. In this case, the
   application must look in its DB for reminders with similar names and ask the user
   whether that is the item they intended to add. If a match (or nearby match) cannot be
   found, the application must ask the user to select a reminder type for the reminder, or
   add a new one, and then save the new reminder, together with its type, in the DB.

To realize this the user can search reminders by their type, list, or actual reminder name. which can then call the methods in each class to add a new reminder

5. The reminders must be saved automatically and immediately after they are modified.

Not considered as it does not affect the design directly

6. Users must be able to check off reminders in the list (without deleting them).

To realize this the Reminder class allows you to check the reminder which means you have checked the reminder off the list

7. Users must also be able to clear all the check-off marks in the reminder list at once.

To realize this the Remindertype class allows the user to clear all checkmarks off that specific list by calling a method

8. Check-off marks for the reminder list are persistent and must also be saved immediately.

Not considered as it does not affect the design directly

9. The application must present the reminders grouped by type.

To realize this there is a ReminderType class which has the attribute remindertype

10. The application must support multiple reminder lists at a time (e.g., “Weekly”, “Monthly”,
    “Kid’s Reminders”). Therefore, the application must provide the users with the ability to
    create, (re)name, select, and delete reminder lists.

To realize this there is a class ReminderList which supports multiple lists at a time and allows the user to rename, delete, select and create reminderslists

11. The application should have the option to set up reminders with day and time alert. If this
    option is selected allow option to repeat the behavior.

To realize this the reminder class has the attributes time, day, and repeat which can be edited and set

12. Extra Credit: Option to set up reminder based on location.

13. The User Interface (UI) must be intuitive and responsive.

Not considered as it does not affect the design directly
