# iSchedule

A full-stack scheduling management web application built with Java Spring Boot and a static HTML/CSS/JS frontend.
This project gives students an overview over their courses in a timetable.
They can enroll in new courses and see the name of the course and the time in which it will take place in their timetable.
Administrators can add new rooms and both admins and assistants can add new courses and preferences.

## How to run

1. Clone the Repository
2. Set Up the Database
   - Import ISchedule.sql into your MySQL server.
   - Adjust application.properties to use your local DB credentials.
3. Build & Run the Project
   - Unix/MacOS/Linux:
     - ```bash
       ./mvnw spring-boot:run
       ```
   - Windows:
     - ```bash
       mvnw.cmd spring-boot:run
       ```
4. Access the web app
   - Open your browser and go to: http://localhost:8080

## Notes

The preferences feature is not fully implemented yet, you can add preferences to the DB, but they won't be taken into account.

The timetable only shows the current week, so to test it, you have to add new courses in the current week.

This project was part of a university coding course and is intended for academic demonstration purposes only.