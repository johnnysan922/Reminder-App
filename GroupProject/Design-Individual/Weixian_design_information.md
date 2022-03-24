1. A list consisting of reminders the users want to be aware of. The application must allow users to add reminders to a list, delete reminders from a list, and edit the reminders in the list.

- To implement this requirement, I created a class called **reminders** with attibute <u>reminderName</u> and operations <u>addReminder(reminderName)</u>, <u>deleteReminder(reminderName)</u>, <u>editReminder(reminderName)</u> that let user to manipulate the reminders.

  

2. The application must contain a database (DB) of *reminders* and corresponding *data*.

- To realize this requirement, I created a simply model called **Database**. Also, I use dependency relationship between the **reminders** class and **Database** because the former class uses the data from the latter.



3. Users must be able to add reminders to a list by picking them from a hierarchical list, where the first level is the reminder type (e.g., Appointment), and the second level is the name of the actual reminder (e.g., Dentist Appointment).

- I added to the design a class **hierarchicalList** with attributes <u>*reminderType*</u> & <u>*actualReminder*</u>. What's more, the relationship between the **hierarchicalList** and ***reminders*** is composition because ***reminders*** can be consider as a part of **hierarchicalList**.



4. Users must also be able to specify a reminder by typing its name. In this case, the application must look in its DB for reminders with similar names and ask the user whether that is the item they intended to add. If a match (or nearby match) cannot be found, the application must ask the user to select a reminder type for the reminder, or add a new one, and then save the new reminder, together with its type, in the DB.

- To realize this requirement, I added a new operation called <u>*matchReminder(reminderName)*</u> under **reminders** class and this method will search the target in the **Database**. In addition, I also created two new operations called <u>*addFirstLevel(reminderType)*</u> and <u>*addSecondLevel(actualReminder)*</u> in **hierarchicalList** class that allows users to create new reminder type and actual reminder. These two operations can cope with the case of no successful match.



5. The reminders must be saved automatically and immediately after they are modified.

- Not considered because it does not affect the design directly.



6. Users must be able to check off reminders in the list (without deleting them).

- I simply add a new operation named <u>*addCheckOff()*</u> in **checkOff** class that take reminderName as parameter and return a list of boolean values for selected reminders to meet the requirement.



7. Users must also be able to clear all the check-off marks in the reminder list at once.

- I add a new operation named <u>*clearCheckOff()*</u> in **checkOff** class that take the return value of <u>*addCheckOff()*</u> as parameter and modify these boolean value to false so that the user can clear all the check-off marks.



8. Check-off marks for the reminder list are persistent and must also be saved immediately.

- Not considered because it does not affect the design directly.



9. The application must present the reminders grouped by type.

- Not considered because it does not affect the design directly.



10. The application must support multiple reminder lists at a time (e.g., “Weekly”, “Monthly”, “Kid’s Reminders”). Therefore, the application must provide the users with the ability to create, (re)name, select, and delete reminder lists.

- To realize this requirement, I add a new class called **multiList** with attributes <u>*listName*</u>, <u>*newListName*</u> and operations <u>*createList(newListName)*</u>, <u>*nameList(newListName)*</u>, <u>*renameList(listName, newListName)*</u>, <u>*selectList(listName)*</u>, <u>*deleteList(listName)*</u>. 



11. The application should have the option to setup reminders with day and time alert. If this option is selected allow option to repeat the behavior.

- To realize this requirement, I add a new class called **Alert** with attributes <u>*month*</u>, <u>*day*</u>, <u>*time*</u>, <u>*repeat*</u> and one operation <u>*setAlert(month, day, time, repeat)*</u>. If <u>*repeat*</u> (boolean type) is selected, the reminder is allowed to be repeated.  



12. **Extra Credit:** Option to set up reminder based on location. 

- To realize this requirement, I add a new class called **location** with attributes <u>*country*</u>, <u>*state*</u>, <u>*city*</u>, <u>*street*</u> and one operation <u>*Location()*</u> that return the location as a string. Also, I add another operator in **reminder** class called <u>*addReminderByLoc(reminderName, Location())*</u> to allow use set uo a reminder based on location.

  

13. The User Interface (UI) must be intuitive and responsive.

- Not considered because it does not affect the design directly.