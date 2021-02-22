# wp1-donm2
wp1-donm2 created by GitHub Classroom
Date: 2020-04-26

##Coderdojo site
A site where children can create an account and add activities to their account to show off what they have done in the wonderful world of programming.

##Motivation
Children can create an account and add activities so they can follow up what they have done and learn what they still can do at coderdojo. The site also gives information about some of the activities.

##Code style
This project uses simple html and css files together with the Vue framework and JavaScript modules.

##Features
A user can create an account, login and logout and can use her/his account to add activities to it.
It is also possible to remove or update the account.
Upon login or registration the users id, first name and last name are stored into the browser.

##pages
In the home page the user is asked if he/she is new to the coderdojo site.
Upon selecting yes he/she is directed to the registration page were he/she can create an account by filling in the first name, last name and age. When all fields are filled in correctly the user account is created and the user is automatically logged in and redirected to the home-new-user.html file. Here he/she receives information about the to added activities and the option to do so.
Upon selecting no the user is brought to the login page were he can login with his/her first and last name. If the user account corresponding with the first and last name exists the user is logged in and brought to the page home.html. Here the user can add activities but there is no information about the activities.
In the overview page it is possible to remove or update a user account.

##Launch
bootstrap is required for the markup and some vue and vuex librarys (included the html head tag) are requireded for the filter in activities.html and activities-new-user.html to work.

##Contribute
Jochen Hansoul, Staf Jalon, Marie Philipsen
