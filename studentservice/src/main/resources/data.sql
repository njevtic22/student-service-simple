-- Passwords are hashed using BCrypt algorithm https://bcrypt-generator.com/
-- Passwords for all users are:
--
-- Script generates database for student-service
-- It generates:
--	- 30 users
--		- 10 admins
--		- 20 referents
--	- 50 students
--
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------- Inserting users --------------------------------------------------------------------------------------------
insert into users (id, name, surname, username, password, role) values (1, 'Rebecca', 'Cremin', 'admin1', '$2a$10$JCYrt8QGHg4suBXWiRgjKu93h5DCq3yFDXMDsTY/Itkgeu3h3pCE6', 'ADMIN');
insert into users (id, name, surname, username, password, role) values (2, 'Gordon', 'Kunze', 'admin2', '$2a$10$JCYrt8QGHg4suBXWiRgjKu93h5DCq3yFDXMDsTY/Itkgeu3h3pCE6', 'ADMIN');
insert into users (id, name, surname, username, password, role) values (3, 'Quinton', 'Kiehn', 'admin3', '$2a$10$JCYrt8QGHg4suBXWiRgjKu93h5DCq3yFDXMDsTY/Itkgeu3h3pCE6', 'ADMIN');
insert into users (id, name, surname, username, password, role) values (4, 'Jerry', 'Langosh', 'admin4', '$2a$10$JCYrt8QGHg4suBXWiRgjKu93h5DCq3yFDXMDsTY/Itkgeu3h3pCE6', 'ADMIN');
insert into users (id, name, surname, username, password, role) values (5, 'Brittney', 'Sanford', 'admin5', '$2a$10$JCYrt8QGHg4suBXWiRgjKu93h5DCq3yFDXMDsTY/Itkgeu3h3pCE6', 'ADMIN');
insert into users (id, name, surname, username, password, role) values (6, 'Hellen', 'Schmeler', 'admin6', '$2a$10$JCYrt8QGHg4suBXWiRgjKu93h5DCq3yFDXMDsTY/Itkgeu3h3pCE6', 'ADMIN');
insert into users (id, name, surname, username, password, role) values (7, 'Rey', 'Marvin', 'admin7', '$2a$10$JCYrt8QGHg4suBXWiRgjKu93h5DCq3yFDXMDsTY/Itkgeu3h3pCE6', 'ADMIN');
insert into users (id, name, surname, username, password, role) values (8, 'Ivan', 'Jenkins', 'admin8', '$2a$10$JCYrt8QGHg4suBXWiRgjKu93h5DCq3yFDXMDsTY/Itkgeu3h3pCE6', 'ADMIN');
insert into users (id, name, surname, username, password, role) values (9, 'Myles', 'Wehner', 'admin9', '$2a$10$JCYrt8QGHg4suBXWiRgjKu93h5DCq3yFDXMDsTY/Itkgeu3h3pCE6', 'ADMIN');
insert into users (id, name, surname, username, password, role) values (10, 'Kathrin', 'Mertz', 'admin10', '$2a$10$JCYrt8QGHg4suBXWiRgjKu93h5DCq3yFDXMDsTY/Itkgeu3h3pCE6', 'ADMIN');
insert into users (id, name, surname, username, password, role) values (11, 'Douglas', 'Koss', 'referent11', '$2a$10$JCYrt8QGHg4suBXWiRgjKu93h5DCq3yFDXMDsTY/Itkgeu3h3pCE6', 'REFERENT');
insert into users (id, name, surname, username, password, role) values (12, 'Roxy', 'McKenzie', 'referent12', '$2a$10$JCYrt8QGHg4suBXWiRgjKu93h5DCq3yFDXMDsTY/Itkgeu3h3pCE6', 'REFERENT');
insert into users (id, name, surname, username, password, role) values (13, 'Harley', 'Lockman', 'referent13', '$2a$10$JCYrt8QGHg4suBXWiRgjKu93h5DCq3yFDXMDsTY/Itkgeu3h3pCE6', 'REFERENT');
insert into users (id, name, surname, username, password, role) values (14, 'Oralee', 'Russel', 'referent14', '$2a$10$JCYrt8QGHg4suBXWiRgjKu93h5DCq3yFDXMDsTY/Itkgeu3h3pCE6', 'REFERENT');
insert into users (id, name, surname, username, password, role) values (15, 'Alex', 'Graham', 'referent15', '$2a$10$JCYrt8QGHg4suBXWiRgjKu93h5DCq3yFDXMDsTY/Itkgeu3h3pCE6', 'REFERENT');
insert into users (id, name, surname, username, password, role) values (16, 'Melany', 'Pfannerstill', 'referent16', '$2a$10$JCYrt8QGHg4suBXWiRgjKu93h5DCq3yFDXMDsTY/Itkgeu3h3pCE6', 'REFERENT');
insert into users (id, name, surname, username, password, role) values (17, 'Jenise', 'Leuschke', 'referent17', '$2a$10$JCYrt8QGHg4suBXWiRgjKu93h5DCq3yFDXMDsTY/Itkgeu3h3pCE6', 'REFERENT');
insert into users (id, name, surname, username, password, role) values (18, 'Patty', 'Upton', 'referent18', '$2a$10$JCYrt8QGHg4suBXWiRgjKu93h5DCq3yFDXMDsTY/Itkgeu3h3pCE6', 'REFERENT');
insert into users (id, name, surname, username, password, role) values (19, 'Danilo', 'Torp', 'referent19', '$2a$10$JCYrt8QGHg4suBXWiRgjKu93h5DCq3yFDXMDsTY/Itkgeu3h3pCE6', 'REFERENT');
insert into users (id, name, surname, username, password, role) values (20, 'Evia', 'Blick', 'referent20', '$2a$10$JCYrt8QGHg4suBXWiRgjKu93h5DCq3yFDXMDsTY/Itkgeu3h3pCE6', 'REFERENT');
insert into users (id, name, surname, username, password, role) values (21, 'Coral', 'Reynolds', 'referent21', '$2a$10$JCYrt8QGHg4suBXWiRgjKu93h5DCq3yFDXMDsTY/Itkgeu3h3pCE6', 'REFERENT');
insert into users (id, name, surname, username, password, role) values (22, 'Rodolfo', 'Bradtke', 'referent22', '$2a$10$JCYrt8QGHg4suBXWiRgjKu93h5DCq3yFDXMDsTY/Itkgeu3h3pCE6', 'REFERENT');
insert into users (id, name, surname, username, password, role) values (23, 'Marcel', 'Strosin', 'referent23', '$2a$10$JCYrt8QGHg4suBXWiRgjKu93h5DCq3yFDXMDsTY/Itkgeu3h3pCE6', 'REFERENT');
insert into users (id, name, surname, username, password, role) values (24, 'Ray', 'Hagenes', 'referent24', '$2a$10$JCYrt8QGHg4suBXWiRgjKu93h5DCq3yFDXMDsTY/Itkgeu3h3pCE6', 'REFERENT');
insert into users (id, name, surname, username, password, role) values (25, 'Kymberly', 'Hilpert', 'referent25', '$2a$10$JCYrt8QGHg4suBXWiRgjKu93h5DCq3yFDXMDsTY/Itkgeu3h3pCE6', 'REFERENT');
insert into users (id, name, surname, username, password, role) values (26, 'David', 'Schroeder', 'referent26', '$2a$10$JCYrt8QGHg4suBXWiRgjKu93h5DCq3yFDXMDsTY/Itkgeu3h3pCE6', 'REFERENT');
insert into users (id, name, surname, username, password, role) values (27, 'Cyril', 'Schumm', 'referent27', '$2a$10$JCYrt8QGHg4suBXWiRgjKu93h5DCq3yFDXMDsTY/Itkgeu3h3pCE6', 'REFERENT');
insert into users (id, name, surname, username, password, role) values (28, 'Delora', 'Jones', 'referent28', '$2a$10$JCYrt8QGHg4suBXWiRgjKu93h5DCq3yFDXMDsTY/Itkgeu3h3pCE6', 'REFERENT');
insert into users (id, name, surname, username, password, role) values (29, 'Sunni', 'Kirlin', 'referent29', '$2a$10$JCYrt8QGHg4suBXWiRgjKu93h5DCq3yFDXMDsTY/Itkgeu3h3pCE6', 'REFERENT');
insert into users (id, name, surname, username, password, role) values (30, 'Cherlyn', 'West', 'referent30', '$2a$10$JCYrt8QGHg4suBXWiRgjKu93h5DCq3yFDXMDsTY/Itkgeu3h3pCE6', 'REFERENT');
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------- Altering user_id_seq -----------------------------------------------------------------------------------------
alter sequence user_id_seq restart with 31;
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------ Inserting students ------------------------------------------------------------------------------------------
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (1, 'Nelson', 'Aufderhar', 'IN 1/2018', '2000-10-26', 'Beograd', 'Bulevar Milutina Milankovića', 23, '0648453440', 'student1@gmail.com', 1);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (2, 'Sharolyn', 'Brown', 'F1 2/2012', '2000-11-18', 'Beograd', 'Cara Dušana', 19, '0644038893', 'student2@gmail.com', 1);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (3, 'Carolyne', 'VonRueden', 'ZZ 3/2019', '2000-03-02', 'Beograd', 'Savska', 13, '0648268231', 'student3@gmail.com', 2);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (4, 'Julian', 'Collins', 'SS 4/2014', '2000-04-23', 'Beograd', 'Nemanjina', 74, '0648105798', 'student4@gmail.com', 3);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (5, 'Joni', 'Weber', 'DC 5/2016', '2000-07-13', 'Beograd', 'Južni bulevar', 21, '0640131039', 'student5@gmail.com', 3);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (6, 'Odell', 'Cassin', 'PR 6/2015', '2000-02-19', 'Beograd', 'Bulevar kneza Aleksandra Karađorđevića', 67, '0646053654', 'student6@gmail.com', 1);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (7, 'Mitchel', 'Barrows', 'PE 7/2012', '2000-02-25', 'Beograd', 'Dr Milutina Ivkovića', 62, '0640828186', 'student7@gmail.com', 2);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (8, 'Jc', 'Brakus', 'DB 8/2018', '2000-09-07', 'Beograd', 'Vojvode Stepe', 86, '0648102200', 'student8@gmail.com', 3);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (9, 'Venice', 'Homenick', 'I9 9/2018', '2000-03-23', 'Beograd', 'Jurija Gagarina', 32, '0647407131', 'student9@gmail.com', 2);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (10, 'Tora', 'Parisian', 'DU 10/2012', '2000-06-27', 'Beograd', 'Gandijeva', 63, '0645534103', 'student10@gmail.com', 1);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (11, 'Abe', 'Breitenberg', 'I8 11/2020', '2000-08-27', 'Beograd', 'Pariske komune', 40, '0641039854', 'student11@gmail.com', 3);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (12, 'Lon', 'Schaefer', 'RA 12/2017', '2000-02-21', 'Beograd', 'Bulevar Nikole Tesle', 82, '0640325844', 'student12@gmail.com', 4);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (13, 'Roselle', 'Hagenes', 'DP 13/2019', '2000-05-04', 'Beograd', 'Bulevar Zorana Đinđića', 74, '0649955593', 'student13@gmail.com', 1);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (14, 'Arthur', 'Corkery', 'DF 14/2015', '2000-02-27', 'Beograd', 'Milentija Popovića', 46, '0644689785', 'student14@gmail.com', 0);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (15, 'Matthew', 'Swaniawski', 'S2 15/2011', '2000-02-25', 'Beograd', 'Bulevar Despota Stefana', 17, '0640038062', 'student15@gmail.com', 3);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (16, 'Kamilah', 'Crist', 'XO 16/2013', '2000-07-19', 'Beograd', 'Dimitrija Tucovića', 3, '0640491472', 'student16@gmail.com', 0);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (17, 'Cordie', 'Kuhlman', 'IN 17/2016', '2000-07-19', 'Beograd', 'Žička', 27, '0643144181', 'student17@gmail.com', 4);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (18, 'Darrin', 'Effertz', 'DZ 18/2012', '2000-02-05', 'Beograd', 'Višnjička', 32, '0641405047', 'student18@gmail.com', 1);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (19, 'Jaime', 'Rath', 'EM 19/2014', '2000-04-19', 'Beograd', 'Jovanke Radaković', 81, '0646137372', 'student19@gmail.com', 1);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (20, 'Silas', 'Dickinson', 'PM 20/2020', '2000-03-20', 'Beograd', 'Vitanovačka', 67, '0645571856', 'student20@gmail.com', 2);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (21, 'Blair', 'Ziemann', 'A5 21/2014', '2000-06-26', 'Beograd', 'Kumodraška', 6, '0648223678', 'student21@gmail.com', 1);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (22, 'Lala', 'Ortiz', 'XG 22/2014', '2000-06-09', 'Beograd', 'Neznanog junaka', 70, '0645776118', 'student22@gmail.com', 0);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (23, 'Clair', 'Trantow', 'E9 23/2012', '2000-06-05', 'Beograd', 'Braće Jerković', 64, '0640418072', 'student23@gmail.com', 3);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (24, 'Mariann', 'DuBuque', 'PI 24/2014', '2000-10-07', 'Beograd', 'Svetozara Radojčića', 69, '0642660767', 'student24@gmail.com', 0);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (25, 'Tyree', 'Fritsch', 'EJ 25/2018', '2000-07-27', 'Beograd', 'Mite Ružića', 85, '0646733275', 'student25@gmail.com', 1);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (26, 'Jessia', 'Johnston', 'A1 26/2014', '2000-04-15', 'Beograd', 'Milana Rakića', 23, '0648689499', 'student26@gmail.com', 1);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (27, 'Floria', 'Aufderhar', 'IT 27/2016', '2000-04-26', 'Beograd', 'Bulevar vojvode Mišića', 6, '0641558106', 'student27@gmail.com', 4);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (28, 'Stuart', 'Spencer', 'SI 28/2010', '2000-08-01', 'Beograd', 'Bulevar Patrijarha Pavla', 61, '0642508293', 'student28@gmail.com', 1);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (29, 'Phil', 'Bernhard', 'M3 29/2021', '2000-06-10', 'Beograd', 'Požeška', 83, '0647672022', 'student29@gmail.com', 4);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (30, 'Bari', 'Stiedemann', 'O2 30/2015', '2000-08-20', 'Beograd', 'Radnička', 68, '0647623452', 'student30@gmail.com', 2);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (31, 'Domenic', 'Greenfelder', 'F1 31/2014', '2000-10-24', 'Beograd', 'Prvomajska', 19, '0645330758', 'student31@gmail.com', 4);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (32, 'Venita', 'Zieme', 'EF 32/2021', '2000-08-12', 'Beograd', 'Tošin bunar', 54, '0645832958', 'student32@gmail.com', 0);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (33, 'Susannah', 'Mayert', 'I2 33/2010', '2000-05-19', 'Beograd', 'Bulevar Mihajla Pupina', 33, '0649172016', 'student33@gmail.com', 4);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (34, 'Elias', 'Reilly', 'M4 34/2020', '2000-01-08', 'Beograd', 'Marka Čelebonovića', 89, '0640225828', 'student34@gmail.com', 1);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (35, 'Stanford', 'Bahringer', 'XS 35/2011', '2000-08-04', 'Beograd', 'Vojvođanska', 49, '0642814236', 'student35@gmail.com', 1);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (36, 'Alfred', 'Hane', 'G1 36/2017', '2000-10-09', 'Beograd', 'Omladinskih brigada', 84, '0648567685', 'student36@gmail.com', 2);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (37, 'Dianna', 'Boyle', 'LO 37/2020', '2000-06-07', 'Beograd', 'Bulevar vojvode Putnika', 11, '0644060383', 'student37@gmail.com', 4);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (38, 'Norman', 'Nader', 'PI 38/2020', '2000-03-06', 'Beograd', 'Teodora Drajzera', 17, '0647794012', 'student38@gmail.com', 4);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (39, 'Susanne', 'Swift', 'DO 39/2012', '2000-06-22', 'Beograd', 'Sinđelićeva', 53, '0640556692', 'student39@gmail.com', 2);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (40, 'Herb', 'Gottlieb', 'DJ 40/2017', '2000-04-02', 'Beograd', 'Ustanička', 44, '0644810334', 'student40@gmail.com', 4);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (41, 'Ada', 'Miller', 'Z2 41/2015', '2000-02-03', 'Novi Sad', 'Bulevar cara Lazara', 72, '0643508746', 'student41@gmail.com', 0);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (42, 'Steve', 'Dietrich', 'ST 42/2020', '2000-04-05', 'Novi Sad', 'Bulevar despota Stefana', 42, '0641099458', 'student42@gmail.com', 2);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (43, 'Armand', 'Keeling', 'DU 43/2014', '2000-03-12', 'Novi Sad', 'Bulevar Evrope', 28, '0642307877', 'student43@gmail.com', 3);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (44, 'Garland', 'Braun', 'Z1 44/2018', '2000-08-08', 'Novi Sad', 'Bulevar Jaše Tomića', 25, '0641780046', 'student44@gmail.com', 2);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (45, 'Brad', 'Ward', 'I1 45/2017', '2000-04-13', 'Novi Sad', 'Bulevar Jovana Dučića', 76, '0644658957', 'student45@gmail.com', 1);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (46, 'Emory', 'Schulist', 'ZU 46/2018', '2000-10-08', 'Novi Sad', 'Bulevar kneza Miloša', 41, '0645891571', 'student46@gmail.com', 1);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (47, 'Judy', 'Larkin', 'BI 47/2013', '2000-05-06', 'Novi Sad', 'Bulevar kralja Petra I', 82, '0647585796', 'student47@gmail.com', 2);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (48, 'Simon', 'Kovacek', 'ET 48/2018', '2000-05-12', 'Novi Sad', 'Bulevar Mihajla Pupina', 55, '0643873658', 'student48@gmail.com', 2);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (49, 'Janyce', 'Buckridge', 'PR 49/2021', '2000-05-07', 'Novi Sad', 'Bulevar oslobođenja', 54, '0645181205', 'student49@gmail.com', 1);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (50, 'Eliseo', 'Howe', 'MT 50/2015', '2000-04-04', 'Novi Sad', 'Bulevar Patrijarha Pavla', 42, '0641821440', 'student50@gmail.com', 4);
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------- Altering student_id_seq ----------------------------------------------------------------------------------------
alter sequence student_id_seq restart with 51;
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

