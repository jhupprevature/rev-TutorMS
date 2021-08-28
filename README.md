# rev-TutorMS
Project 2 for 210607 Reston

## Project Description
The Tutoring Management Applicaiton handles the logging of tutoring sessions at Tutors4U. This includes managment of accounts for tutors, managers, and students. Students can search for tutors and schedule sessions. Tutors and students can log comments for tutoring sessions. Tutors and managers can view their work hours in their profile. Managers can view analytics of the tutoring sessions. A dashboard is present to summarize the user's experience.


## Technologies Used

Development technologies:
* PostgreSQL - version 42.2.20
* Java - version 8
* Spring - version 2.5.3
    - Core
    - Data
    - MVC
    - Test
* Angular 4

Testing technologies:
* SLF4J - version 1.7.30
* Log4J -  version 1.2.17
* JUnit - version 5
* Postman
* Selenium 
* Cucumber - version 6.10.2


## Features

List of features ready
* Login and registration functionality
* Users can view and edit their data
* Students can schedule tutoring sessions
* Tracks student and tutor usage hours
* Tracks frequency of course tutoring
* Tracks session logs for participating users

To-do list:
* Implement editing the session reviews
* Prevent page access when not logged in
* Prevent reset of login on refresh
* Implement manager aproval for tutor registration and schedule changes

## Getting Started
   
> This project was developed in Spring Tool Suite 4 and Visual Studio Code.
> This project was tested with Google Chrome version 92.
> No other environments have been tested or confirmed.

- Clone this repository: `git clone https://github.com/jhupprevature/rev-TutorMS.git`.
- Open the Spring project in your IDE.
- Open the Hibernate configuration located at `rev-TutorMS/tutor_ms_sts/src/main/resources/hibernate.cfg.xml`.
- Edt the Hibernate connection *url*, *username*, and *password* to match the information for your RDS.
- In your database tool, run the `database.sql` file located in `rev-TutorMS/tutor_ms_sts/src/main/resources/`
- Compile and run the project to establish Spring Tomcat server.
- In your CLI, navigate to `rev-TutorMS/TutorMS-NG`.
- Install *node_modules* and run the server with
    * Node is assumed to be on your device.
    * `npm install` 
    * `ng serve`
- Open `localhost:4200` in your browser.


## Usage

To demo this applicaiton, you can use the following login information:
| Role  | Username  | Password  |
| :---   | :---:   | :---:   |
| Student  | tdymick7 | tdymick7 |
| Tutor | amcorkill4 | amcorkill4 |
| Manager | amoorhouse0 | amoorhouse0 |

## Contributors

[Cao Mai](https://github.com/caocmai), [Deyondre Beale](https://github.com/DeyondreBeale), [Jordan Hupp](https://github.com/jhupprevature), [Kevin Leader](https://github.com/kileader), [Samantha Sanchez](https://github.com/ssanchez19)