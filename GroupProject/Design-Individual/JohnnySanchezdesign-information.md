1. A list consisting of reminders the users want to be aware of. The application must allow users to add reminders to a list, delete reminders from a list, and edit the reminders in the list.

    I created a class called listReminders which has addReminders, deleteReminder, editReminder functions to fulfill the tasks above.

2. The application must contain a database (DB) of reminders and corresponding data.

    A model depicting the database has been implemented in the design.

3. Users must be able to add reminders to a list by picking them from a hierarchical list, where the first level is the reminder type (e.g., Appointment), and the second level is the name of the actual reminder (e.g., Dentist Appointment).

    When the user invokes the addReminders method there is a class called reminderType that has a list of predetermined reminderType's in which users can choose from, there's another class called Reminders that handles the creation of reminders as objects.

4. Users must also be able to specify a reminder by typing its name. In this case, the application must look in its DB for reminders with similar names and ask the user whether that is the item they intended to add. If a match (or nearby match) cannot be found, the application must ask the user to select a reminder type for the reminder, or add a new one, and then save the new reminder, together with its type, in the DB.

    Not fully displayed as it's a UI feature more than a UML. In the listView class there is a method called SearchReminders in which users can search for a reminder by directly querying the database across multiple lists which is handled by the searchReminders method. The addReminderType method also lets users add reminder types to be used when creating new reminders in the ReminderTypeSet class

5. The reminders must be saved automatically and immediately after they are modified.

    Reminders are updated by the listReminders class to the database as depicted by the arrow in the design.

6.  Users must be able to check off reminders in the list (without deleting them).

    Reminder objects have a boolean attribute to identify if it is 'checked off' or not.

7. Users must also be able to clear all the check-off marks in the reminder list at once.

    In the listReminders class there is a clearCheckOffs function that sets all boolean attributes of the 'isCheckedOff' attribute to false. 

8. Check-off marks for the reminder list are persistent and must also be saved immediately.

    The 'isCheckedOff' attribute is saved and sent to the database after the object is modified by the user. 

9. The application must present the reminders grouped by type.

    Each Reminder object has a reminderType attribute that is saved with the reminder.

10. The application must support multiple reminder lists at a time (e.g., “Weekly”, “Monthly”, “Kid’s Reminders”). Therefore, the application must provide the users with the ability to create, (re)name, select, and delete reminder lists

    The listView class is a collection of objects of type listReminders which lets the users have access to the following methods to create, rename, select and delete reminder lists.

11. The application should have the option to set up reminders with day and time alert. If this option is selected allow option to repeat the behavior.

    The isAllDay boolean attribute determines whether the reminder will just be an all day instance and will set the dateTime attribute to null; if isAllDay is set to false it will ask for a dateTime to be entered and the repeatsReminder attribute executes the RepeatsReminder class in which users can set an endingDate for the series as well as how this reminder repeats

12. Extra Credit: Option to set up reminder based on location.

    Location attribute in the Reminders class calls setLocation() method where it invokes the google maps API class

13. The User Interface (UI) must be intuitive and responsive.
    
    Not considered because it does not affect the design directly.