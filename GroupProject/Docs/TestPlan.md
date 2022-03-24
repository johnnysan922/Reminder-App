

**Author**: Minjae Kim

## 1 Testing Strategy

### 1.1 Overall strategy

Unit Testing - Test smallest units from the program and build our way up

1) Check function to add new reminder/type/description

2) Check function to delete existing reminders

3) Check function to edit reminders (everything within it including type and description)

4) Check function to search reminders

5) Check function to check/uncheck existing reminders for multiple selection

Integration Testing - Test units by integrating them and testing them as a whole

The simplicity of this app allows for combined integration testing with unit testing. Checking for integration testing is already embedded within Unit Testing.

System Testing - Testing of the fully integrated application to see if all the requirements and standards are met.

1) Test the application by using different cases and scenarios

2) Look over the requirements for the application and test all the cases that are required of this application


Regression Testing - After chages are made to the code for any deficiency found, rerun the tests that are ran before the tests to ensure everything still functions properly

### 1.2 Test Selection

Both black box and white box testing will occur in order to determine any deficiency in the program that could exist.

Black Box Testing - Functional testing and regression testing will be used to test our application. Since this test is primarily focused on the input and output of the application, that is what we will focus on to test all the functions within Unit Testing.

White Box Testing - Statement coverage and branch coverage will be used to test our application during the Unit Testing phase.

### 1.3 Adequacy Criterion

Unit Testing Phase - Statement Coverage (All statements/commands will be excuted at least once to ensure quality of the program. The notation of the results will be recorded)

System Testing Phase - Path Coverage (All paths are executed at least once and all the numbers of paths from input to output will be recorded)

### 1.4 Bug Tracking

Unit Testing - We are testing the smallest parts of the code one at a time, hence if there is an error we would know exactly where the fix needs to happen.

Integration Testing - If unit testing passes and integration testing fails, we know combining the functions causes it to fail. Therefore, we can examine which connection of functions causes it to fail and fix them.

System Testing - If both unit testing and integration testing fails, application should deploy without much problem. However, if it happens to fail, we know it's with the application deployment because both unit and integration testing passed.

### 1.5 Technology

JUnit will be used to run tests for our application.

## 2 Test Cases


|**Tests**|**Purpose**|**Steps**|**Expected Result**|**Result**|**Pass/Fail**|
| :- | :- | :- | :- | :- | :- |
|Add Reminder|To check if application allows to add a new reminder|<p>1)Click add reminder</p><p>2)Fill out info needed</p><p>3)Click done</p>|New reminder created|||
|Add Type|To check if application allows to add a new type|<p>1)Click add reminder</p><p>2)Fill out info needed</p><p>3)Click done</p>|Type added|||
|Add Description|To check if application allows to add a new description|<p>1)Click add reminder</p><p>2)Fill out info needed</p><p>3)Click done</p>|Description added|||
|Edit Reminder|To check if application allows to edit a reminder|<p>1)Click edit reminder</p><p>2)Change info as needed</p><p>3)Click done</p>|Reminders are edited|||
|Edit Type|To check if application allows to edit a type|<p>1)Click edit reminder</p><p>2)Change info as needed</p><p>3)Click done</p>|Type is edited|||
|Edit Description|To check if application allows to edit a description|<p>1)Click edit reminder</p><p>2)Change info as needed</p><p>3)Click done</p>|Description is edited|||
|Delete Reminder|To check if application allows to delete a reminder|<p>1)Click delete reminder</p><p>2)Click confirm </p><p>3)Check if deleted </p>|Reminder is deleted|||
|Search Reminder|To check if application allows to search a reminder|<p>1)Click search</p><p>2)Search for reminder</p><p>3)Check if searched reminder shows up</p>|Searched reminder shows|||
|Check Reminder|To check if application allows to check a reminder|<p>1)Click the checkbox next to reminder</p><p>2)Check if there’s a check mark next to the reminder</p>|Reminder is check marked|||
|Uncheck Reminder|To check if application allows to uncheck a reminder|<p>1)Click the checkbox with a check</p><p>2)Check if the check mark next to the reminder disappeared</p>|Reminder is uncheck marked|||
|Multiple check a reminder|To check if application allows to check multiple reminders|<p>1)Click multiple checkboxes next to reminder</p><p>2)Check if there are a check marks next to the reminder</p>|Multiple reminders are check marked|||
|Multiple check a reminder|To check if application allows to uncheck multiple reminders|<p>1)Click multiple checkboxes next to reminder that have check marks</p><p>2)Check if there are no check marks next to the reminder</p>|Multiple reminders are uncheck marked|||

