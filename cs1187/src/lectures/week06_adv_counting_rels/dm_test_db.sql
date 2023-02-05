drop schema dm_test;

create schema dm_test;

use dm_test;

-- Creates structure of Table 8
CREATE TABLE Flights (
  Airline       VARCHAR(30) NOT NULL,
  Flight_number INTEGER NOT NULL,
  Gate          INTEGER NOT NULL,
  Destination   VARCHAR(30) NOT NULL,
  Departure_time VARCHAR(30),
  PRIMARY KEY (Airline, Flight_number)
);

-- Creates structure of Table 1
CREATE TABLE Students (
  Student_name VARCHAR(30) NOT NULL,
  ID_number    INTEGER NOT NULL PRIMARY KEY,
  Major        VARCHAR(30) NOT NULL,
  GPA          DOUBLE(3,2) NOT NULL
);

-- Creates structure of Table 5
CREATE TABLE Teaching_assignments (
  Professor VARCHAR(30) NOT NULL,
  Department VARCHAR(30) NOT NULL,
  Course_number INTEGER NOT NULL,
  PRIMARY KEY (Department, Course_number)
);

-- Creates structure of Table 6
CREATE TABLE Class_schedule (
  Department VARCHAR(30) NOT NULL,
  Course_number INTEGER NOT NULL,
  Room VARCHAR(30) NOT NULL,
  Time VARCHAR(30) NOT NULL,
  PRIMARY KEY (Department, Course_number, Room)
);

-- Create structure of Table 3
CREATE TABLE Enrollments (
  Student VARCHAR(30) NOT NULL,
  Major VARCHAR(30) NOT NULL,
  Course VARCHAR(30) NOT NULL,
  PRIMARY KEY (Student, Major, Course)
);

-- Populates Table 8
INSERT INTO Flights VALUES("Nadir", 122, 34, "Detroit", "08:10");
INSERT INTO Flights VALUES("Acme", 221, 22, "Denver", "08:17");
INSERT INTO Flights VALUES("Acme", 122, 33, "Anchorage", "08:22");
INSERT INTO Flights VALUES("Acme", 323, 34, "Honolulu", "08:30");
INSERT INTO Flights VALUES("Nadir", 199, 13, "Detroit", "08:47");
INSERT INTO Flights VALUES("Acme", 222, 22, "Denver", "09:10");
INSERT INTO Flights VALUES("Nadir", 322, 34, "Detroit", "09:44");

-- Populates Table 1
INSERT INTO Students VALUES("Ackermann", 231455, "Computer Science", 3.88);
INSERT INTO Students VALUES("Adams", 888323, "Physics", 3.45);
INSERT INTO Students VALUES("Chou", 102147, "Computer Science", 3.49);
INSERT INTO Students VALUES("Goodfriend", 453876, "Mathematics", 3.45);
INSERT INTO Students VALUES("Rao", 678543, "Mathematics", 3.90);
INSERT INTO Students VALUES("Stevens", 786576, "Psychology", 2.99);

-- Populates Table 5
INSERT INTO Teaching_assignments VALUES("Cruz", "Zoology", 335);
INSERT INTO Teaching_assignments VALUES("Cruz", "Zoology", 412);
INSERT INTO Teaching_assignments VALUES("Farber", "Psychology", 501);
INSERT INTO Teaching_assignments VALUES("Farber", "Psychology", 617);
INSERT INTO Teaching_assignments VALUES("Grammer", "Physics", 544);
INSERT INTO Teaching_assignments VALUES("Grammer", "Physics", 551);
INSERT INTO Teaching_assignments VALUES("Rosen", "Computer Science", 518);
INSERT INTO Teaching_assignments VALUES("Rosen", "Mathematics", 575);

-- Populates Table 6
INSERT INTO Class_schedule VALUES("Computer Science", 518, "N521", "2:00 PM");
INSERT INTO Class_schedule VALUES("Mathematics", 575, "N502", "3:00 PM");
INSERT INTO Class_schedule VALUES("Mathematics", 611, "N521", "4:00 PM");
INSERT INTO Class_schedule VALUES("Physics", 544, "B505", "4:00 PM");
INSERT INTO Class_schedule VALUES("Psychology", 501, "A100", "3:00 PM");
INSERT INTO Class_schedule VALUES("Psychology", 617, "A110", "11:00 AM");
INSERT INTO Class_schedule VALUES("Zoology", 335, "A100", "9:00 AM");
INSERT INTO Class_schedule VALUES("Zoology", 412, "A100", "8:00 AM");

-- Populates Table 3
INSERT INTO Enrollments VALUES("Glauser", "Biology", "BI 290");
INSERT INTO Enrollments VALUES("Glauser", "Biology", "MS 475");
INSERT INTO Enrollments VALUES("Glauser", "Biology", "PY 410");
INSERT INTO Enrollments VALUES("Marcus", "Mathematics", "MS 511");
INSERT INTO Enrollments VALUES("Marcus", "Mathematics", "MS 603");
INSERT INTO Enrollments VALUES("Marcus", "Mathematics", "CS 322");
INSERT INTO Enrollments VALUES("Miller", "Computer Science", "MS 575");
INSERT INTO Enrollments VALUES("Miller", "Computer Science", "CS 455");

-- Creates Table 7
-- SELECT *
-- FROM Teaching_assignments as ta,
--      Class_schedule as cs
-- WHERE ta.Department = cs.Department AND
--       ta.Course_number = cs.Course_number;

-- SELECT Professor, Time
-- FROM Teaching_assignments as ta,
--      Class_schedule as cs
-- WHERE ta.Department='Mathematics' AND
--       cs.Department='Mathematics' AND
--       ta.Course_number = cs.Course_number;

-- Creates Table from Example 12
-- SELECT Departure_time
-- FROM Flights
-- WHERE Destination="Detroit";

-- Creates Table from Example 13
-- SELECT *
-- FROM Teaching_assignments as ta,
--      Class_schedule as cs
-- WHERE ta.Department = cs.Department AND
--       ta.Course_number = cs.Course_number;

-- Creates Table 2
-- SELECT Student_name, GPA
-- FROM Students;

-- Creates Table 4
-- SELECT Student, Major
-- From Enrollments;
