README
======

This program performs checks a user's password against an encrypted password in the database.

To Run the Program

1. Run the MySQL DB script: sql/table-setup.sql
   - This script will create all required tables
   - It will also create 5 users accounts.
   - The password for each account is: java
     - The password is case-sensitive
   
2. Open the Project in Eclipse
   - Run the main program: EmployeeSearchApp.java

3. Login to the application 
   a. At the login screen, select any employee from the drop-down list
   b. The password for each account is: java
     - The password is case-sensitive
   c. Press OK to login

4. Click the User's tab

   There are two types of accounts: admins and non-admins
   
   If you are an admin, you can perform all user functions.
   - Add user
   - Update all users in the app
   - Change password for all users in the app
  
   If you are not admin, you can only update your account
   - Update currently logged in user only
   - Change password for currently logged in user only
     
          
Initial Account Data
=====================
   
   User Name			|  Admin
   ----------------------------------------
   Joe Alpha			|  No                  
   Jane Beta			|  No
   Becky Zeta		|  No
   Admin Charlie		|  Yes
   Percy Miracles	|  Yes

   All passwords:  java         (all lower-case)
   
   