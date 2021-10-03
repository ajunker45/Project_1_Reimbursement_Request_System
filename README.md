# Project_1_Reimbursement_Request_System

## Project Description

The purpose of this project is for employees and managers to be able to log in. Once logged in, an employee can make a request to be reimbursed for a certain amount of money. A manager meanwhile can make either approve or deny requests that are submitted by any user, as well as see statistics about all the requests.


## Technologies Used

* JavaScript
* HTML 5 
* CSS, SQL 
* Postman 
* AWS RDS 
* Java 8 
* Javalin 
* Hibernate
* MariaDB
* DBeaver
* Maven
* Spring Tools Suite 4

## Features

* Creates a database system that keeps track of requests, as well as a list of users of who can log in.
* Allows the employee to create an request.
* Allows managers to approve and deny requests.
* Allows managers to see statistics about the requests.

To-Do List:
* Clean up the front end to make it much more user friendly.
* Add more statistical Data to the statistics view on manager. 

## Getting Started

First you should begin by cloning this repository. The image below shows the command you should be using in GIT.

![](./Images/Cloning-the-repo.PNG)

Next Make sure you have the latest version of DBeaver, Spring Tools Suite, Postman, and have a fresh, empty database hosted on AWS or your prefered web service database.

Next go to Spring Tools Suite 4 and open the IDE. From there you will begin to import the folder as a maven project shown below. 

![](./Images/Importing-The-Project.PNG)

Then select the type of project you wish to import. In this case, its an existing maven project

![](./Images/Choosing-The-Type.PNG)

Now select The project1 folder that you have pulled from this repo. Note, I already have this in my IDE so it says it already exists, but it shouldn't exist for you. You have done it correctly when you see the pom.xml listed in the box and it is checkmarked.

![](./Images/Select-The-Folder.PNG)

Now that we have our folder ready to go, we now need to create the database with DBeaver. 


First, open Dbeaver, and you will notice the button below in the top left hand corner, you want to click to so that you can add a server.
![](./Images/Connect-Button.PNG)

Now enter the appropriate Information based on what is correct for your database server. Make sure its the right endpoint, username, password, and port number. 

![](./Images/Connect-to-database.PNG)

Now right click databases, and click on "Create New DataBase" as shown below, after that you will get a popup to name the database. You will want to remember that for later.

![](./Images/Create-Database.PNG)

Now back to Spring Tools Suite 4, open the connection.properties File that is in the project. It should be located under src/main/resource

You will want to put in the correct credentals to your database and its related endpoints. For security reasons, I have left out the credentials of my database i used in this project, since it can lead to other people hacking the database. 

![](./Images/Connection-properties.PNG)

Next go over to your package structure and open the driver file that is locoated and highlighted below.

![](./Images/Packages-one.PNG)

Then click the green arrow on the upper left circled in the below image. If asked where you want to run it, run it as a java console application.

![](./Images/Run-The-Program.PNG)

Next go to postman, and run the shown get request. From here it should create the datbase structure inside the database you specified inside of your connection.properties file. The request should return an empty set. 

![](./Images/Postman.PNG)

Now go ahead and head back to Spring Tools and stop the program for the time being. You can stopo it by clicking on the big red pause button shown below.

![](./Images/Stop-Program.PNG)

Next, head back to DBeaver, and go ahead and create a script for our brand new database shown below

![](./Images/Create-Script.PNG)

Now in order to use the program to its fullest extent, we need to manually add in some users that can sign into the program. By writing the below lines of code inside the script, and then highlighting one line at a time,  we can add these two users into our database. You are free to change the usernames, and passwords of these users as you see fit. The last TRUE or FALSE field, decides if they are a manager, or not. Managers have different roles compared to normal users.

![](./Images/Add-Users.PNG)

And to run a line of script, you highlight the line you want to run, and press the button below on the side of the script. 

![](./Images/Run-The-Insert.PNG)

Now the program should be ready for use!

## Usage

