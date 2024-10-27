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
insert into users (id, name, surname, username, password, role) values (1, 'Gilbert', 'Volkman', 'admin1', '$2a$10$JCYrt8QGHg4suBXWiRgjKu93h5DCq3yFDXMDsTY/Itkgeu3h3pCE6', 'ADMIN');
insert into users (id, name, surname, username, password, role) values (2, 'Morton', 'Streich', 'admin2', '$2a$10$JCYrt8QGHg4suBXWiRgjKu93h5DCq3yFDXMDsTY/Itkgeu3h3pCE6', 'ADMIN');
insert into users (id, name, surname, username, password, role) values (3, 'Coleen', 'Pacocha', 'admin3', '$2a$10$JCYrt8QGHg4suBXWiRgjKu93h5DCq3yFDXMDsTY/Itkgeu3h3pCE6', 'ADMIN');
insert into users (id, name, surname, username, password, role) values (4, 'Fred', 'Stracke', 'admin4', '$2a$10$JCYrt8QGHg4suBXWiRgjKu93h5DCq3yFDXMDsTY/Itkgeu3h3pCE6', 'ADMIN');
insert into users (id, name, surname, username, password, role) values (5, 'Evelyn', 'Hartmann', 'admin5', '$2a$10$JCYrt8QGHg4suBXWiRgjKu93h5DCq3yFDXMDsTY/Itkgeu3h3pCE6', 'ADMIN');
insert into users (id, name, surname, username, password, role) values (6, 'Wm', 'Price', 'admin6', '$2a$10$JCYrt8QGHg4suBXWiRgjKu93h5DCq3yFDXMDsTY/Itkgeu3h3pCE6', 'ADMIN');
insert into users (id, name, surname, username, password, role) values (7, 'Ricky', 'O''Reilly', 'admin7', '$2a$10$JCYrt8QGHg4suBXWiRgjKu93h5DCq3yFDXMDsTY/Itkgeu3h3pCE6', 'ADMIN');
insert into users (id, name, surname, username, password, role) values (8, 'Elnora', 'Graham', 'admin8', '$2a$10$JCYrt8QGHg4suBXWiRgjKu93h5DCq3yFDXMDsTY/Itkgeu3h3pCE6', 'ADMIN');
insert into users (id, name, surname, username, password, role) values (9, 'Albert', 'Lind', 'admin9', '$2a$10$JCYrt8QGHg4suBXWiRgjKu93h5DCq3yFDXMDsTY/Itkgeu3h3pCE6', 'ADMIN');
insert into users (id, name, surname, username, password, role) values (10, 'Angel', 'Nader', 'admin10', '$2a$10$JCYrt8QGHg4suBXWiRgjKu93h5DCq3yFDXMDsTY/Itkgeu3h3pCE6', 'ADMIN');
insert into users (id, name, surname, username, password, role) values (11, 'Terrance', 'Wuckert', 'referent11', '$2a$10$JCYrt8QGHg4suBXWiRgjKu93h5DCq3yFDXMDsTY/Itkgeu3h3pCE6', 'REFERENT');
insert into users (id, name, surname, username, password, role) values (12, 'Elsa', 'Mosciski', 'referent12', '$2a$10$JCYrt8QGHg4suBXWiRgjKu93h5DCq3yFDXMDsTY/Itkgeu3h3pCE6', 'REFERENT');
insert into users (id, name, surname, username, password, role) values (13, 'Klara', 'Kozey', 'referent13', '$2a$10$JCYrt8QGHg4suBXWiRgjKu93h5DCq3yFDXMDsTY/Itkgeu3h3pCE6', 'REFERENT');
insert into users (id, name, surname, username, password, role) values (14, 'Anjanette', 'Bergnaum', 'referent14', '$2a$10$JCYrt8QGHg4suBXWiRgjKu93h5DCq3yFDXMDsTY/Itkgeu3h3pCE6', 'REFERENT');
insert into users (id, name, surname, username, password, role) values (15, 'Shayne', 'Zboncak', 'referent15', '$2a$10$JCYrt8QGHg4suBXWiRgjKu93h5DCq3yFDXMDsTY/Itkgeu3h3pCE6', 'REFERENT');
insert into users (id, name, surname, username, password, role) values (16, 'Guy', 'Zboncak', 'referent16', '$2a$10$JCYrt8QGHg4suBXWiRgjKu93h5DCq3yFDXMDsTY/Itkgeu3h3pCE6', 'REFERENT');
insert into users (id, name, surname, username, password, role) values (17, 'German', 'Jerde', 'referent17', '$2a$10$JCYrt8QGHg4suBXWiRgjKu93h5DCq3yFDXMDsTY/Itkgeu3h3pCE6', 'REFERENT');
insert into users (id, name, surname, username, password, role) values (18, 'Jacque', 'Wisoky', 'referent18', '$2a$10$JCYrt8QGHg4suBXWiRgjKu93h5DCq3yFDXMDsTY/Itkgeu3h3pCE6', 'REFERENT');
insert into users (id, name, surname, username, password, role) values (19, 'Randy', 'Gislason', 'referent19', '$2a$10$JCYrt8QGHg4suBXWiRgjKu93h5DCq3yFDXMDsTY/Itkgeu3h3pCE6', 'REFERENT');
insert into users (id, name, surname, username, password, role) values (20, 'Royce', 'Fahey', 'referent20', '$2a$10$JCYrt8QGHg4suBXWiRgjKu93h5DCq3yFDXMDsTY/Itkgeu3h3pCE6', 'REFERENT');
insert into users (id, name, surname, username, password, role) values (21, 'Lucina', 'Wiza', 'referent21', '$2a$10$JCYrt8QGHg4suBXWiRgjKu93h5DCq3yFDXMDsTY/Itkgeu3h3pCE6', 'REFERENT');
insert into users (id, name, surname, username, password, role) values (22, 'Miquel', 'Cormier', 'referent22', '$2a$10$JCYrt8QGHg4suBXWiRgjKu93h5DCq3yFDXMDsTY/Itkgeu3h3pCE6', 'REFERENT');
insert into users (id, name, surname, username, password, role) values (23, 'Maryellen', 'Trantow', 'referent23', '$2a$10$JCYrt8QGHg4suBXWiRgjKu93h5DCq3yFDXMDsTY/Itkgeu3h3pCE6', 'REFERENT');
insert into users (id, name, surname, username, password, role) values (24, 'Cyrus', 'Mertz', 'referent24', '$2a$10$JCYrt8QGHg4suBXWiRgjKu93h5DCq3yFDXMDsTY/Itkgeu3h3pCE6', 'REFERENT');
insert into users (id, name, surname, username, password, role) values (25, 'Cameron', 'Yundt', 'referent25', '$2a$10$JCYrt8QGHg4suBXWiRgjKu93h5DCq3yFDXMDsTY/Itkgeu3h3pCE6', 'REFERENT');
insert into users (id, name, surname, username, password, role) values (26, 'Lelia', 'Mertz', 'referent26', '$2a$10$JCYrt8QGHg4suBXWiRgjKu93h5DCq3yFDXMDsTY/Itkgeu3h3pCE6', 'REFERENT');
insert into users (id, name, surname, username, password, role) values (27, 'Travis', 'Stracke', 'referent27', '$2a$10$JCYrt8QGHg4suBXWiRgjKu93h5DCq3yFDXMDsTY/Itkgeu3h3pCE6', 'REFERENT');
insert into users (id, name, surname, username, password, role) values (28, 'Ola', 'Stokes', 'referent28', '$2a$10$JCYrt8QGHg4suBXWiRgjKu93h5DCq3yFDXMDsTY/Itkgeu3h3pCE6', 'REFERENT');
insert into users (id, name, surname, username, password, role) values (29, 'Brett', 'Senger', 'referent29', '$2a$10$JCYrt8QGHg4suBXWiRgjKu93h5DCq3yFDXMDsTY/Itkgeu3h3pCE6', 'REFERENT');
insert into users (id, name, surname, username, password, role) values (30, 'Lajuana', 'Rutherford', 'referent30', '$2a$10$JCYrt8QGHg4suBXWiRgjKu93h5DCq3yFDXMDsTY/Itkgeu3h3pCE6', 'REFERENT');
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------- Altering user_id_seq -----------------------------------------------------------------------------------------
alter sequence user_id_seq restart with 31;
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------ Inserting students ------------------------------------------------------------------------------------------
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (1, 'Carl', 'Langworth', 'A4 1/2014', '2000-11-18', 'Beograd', 'Bulevar Milutina Milankovića', 23, '0643005718', 'student1@gmail.com', 3);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (2, 'Mora', 'Doyle', 'C1 2/2014', '2000-08-04', 'Beograd', 'Cara Dušana', 19, '0640372461', 'student2@gmail.com', 4);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (3, 'Peter', 'Effertz', 'E7 3/2012', '2000-03-05', 'Beograd', 'Savska', 13, '0644536260', 'student3@gmail.com', 4);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (4, 'Julio', 'Breitenberg', 'EF 4/2017', '2000-05-08', 'Beograd', 'Nemanjina', 74, '0641117446', 'student4@gmail.com', 2);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (5, 'Rolf', 'Von', 'SF 5/2017', '2000-07-20', 'Beograd', 'Južni bulevar', 21, '0641574808', 'student5@gmail.com', 1);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (6, 'Irvin', 'Beer', 'SR 6/2016', '2000-05-07', 'Beograd', 'Bulevar kneza Aleksandra Karađorđevića', 67, '0642646130', 'student6@gmail.com', 2);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (7, 'Stephen', 'Murray', 'I5 7/2016', '2000-10-18', 'Beograd', 'Dr Milutina Ivkovića', 62, '0642526476', 'student7@gmail.com', 0);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (8, 'Blanch', 'Dickinson', 'ZS 8/2010', '2000-09-24', 'Beograd', 'Vojvode Stepe', 86, '0649563357', 'student8@gmail.com', 4);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (9, 'Brandee', 'Thiel', 'ER 9/2020', '2000-08-23', 'Beograd', 'Jurija Gagarina', 32, '0642288739', 'student9@gmail.com', 0);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (10, 'Franklyn', 'Mitchell', 'ZU 10/2013', '2000-07-02', 'Beograd', 'Gandijeva', 63, '0648708904', 'student10@gmail.com', 1);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (11, 'Angelina', 'Cartwright', 'DP 11/2014', '2000-08-23', 'Beograd', 'Pariske komune', 40, '0640063610', 'student11@gmail.com', 0);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (12, 'Jamee', 'Yundt', 'IT 12/2019', '2000-08-17', 'Beograd', 'Bulevar Nikole Tesle', 82, '0647695852', 'student12@gmail.com', 4);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (13, 'Rory', 'Jones', 'MH 13/2018', '2000-10-03', 'Beograd', 'Bulevar Zorana Đinđića', 74, '0645283071', 'student13@gmail.com', 1);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (14, 'Pedro', 'Turner', 'EJ 14/2012', '2000-04-14', 'Beograd', 'Milentija Popovića', 46, '0642582401', 'student14@gmail.com', 0);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (15, 'Sidney', 'Feeney', 'V1 15/2015', '2000-02-22', 'Beograd', 'Bulevar Despota Stefana', 17, '0644492755', 'student15@gmail.com', 1);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (16, 'Miguel', 'Metz', 'Z4 16/2016', '2000-10-24', 'Beograd', 'Dimitrija Tucovića', 3, '0647310574', 'student16@gmail.com', 1);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (17, 'Yuki', 'Parisian', 'A5 17/2018', '2000-04-02', 'Beograd', 'Žička', 27, '0644325472', 'student17@gmail.com', 4);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (18, 'Georgeanna', 'Keebler', 'EF 18/2017', '2000-09-20', 'Beograd', 'Višnjička', 32, '0640078934', 'student18@gmail.com', 4);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (19, 'Roger', 'Wehner', 'E3 19/2012', '2000-07-06', 'Beograd', 'Jovanke Radaković', 81, '0642066303', 'student19@gmail.com', 3);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (20, 'Arleen', 'Prohaska', 'SP 20/2011', '2000-07-18', 'Beograd', 'Vitanovačka', 67, '0646306783', 'student20@gmail.com', 0);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (21, 'Sybil', 'Herman', 'SV 21/2010', '2000-06-04', 'Beograd', 'Kumodraška', 6, '0647555680', 'student21@gmail.com', 2);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (22, 'Russell', 'Runolfsson', 'DV 22/2014', '2000-03-18', 'Beograd', 'Neznanog junaka', 70, '0645601415', 'student22@gmail.com', 0);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (23, 'Leslie', 'Hahn', 'AR 23/2020', '2000-05-12', 'Beograd', 'Braće Jerković', 64, '0647809516', 'student23@gmail.com', 0);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (24, 'Jaquelyn', 'Satterfield', 'XZ 24/2016', '2000-02-16', 'Beograd', 'Svetozara Radojčića', 69, '0649923670', 'student24@gmail.com', 3);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (25, 'Creola', 'Klein', 'XH 25/2014', '2000-07-12', 'Beograd', 'Mite Ružića', 85, '0643389483', 'student25@gmail.com', 3);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (26, 'Tim', 'Wisozk', 'SR 26/2016', '2000-10-18', 'Beograd', 'Milana Rakića', 23, '0648154889', 'student26@gmail.com', 4);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (27, 'Lorette', 'Fritsch', 'XS 27/2020', '2000-01-11', 'Beograd', 'Bulevar vojvode Mišića', 6, '0640513421', 'student27@gmail.com', 2);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (28, 'Nelson', 'Schneider', 'DV 28/2017', '2000-06-15', 'Beograd', 'Bulevar Patrijarha Pavla', 61, '0645947680', 'student28@gmail.com', 4);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (29, 'Lillia', 'Dare', 'SR 29/2011', '2000-10-07', 'Beograd', 'Požeška', 83, '0645715919', 'student29@gmail.com', 1);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (30, 'Dominic', 'Ankunding', 'MH 30/2011', '2000-04-20', 'Beograd', 'Radnička', 68, '0642550483', 'student30@gmail.com', 2);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (31, 'Ileen', 'Towne', 'DH 31/2016', '2000-03-17', 'Beograd', 'Prvomajska', 19, '0643164296', 'student31@gmail.com', 4);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (32, 'Gerry', 'Doyle', 'O1 32/2016', '2000-07-18', 'Beograd', 'Tošin bunar', 54, '0640200046', 'student32@gmail.com', 4);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (33, 'Dominica', 'Wuckert', 'EM 33/2016', '2000-06-11', 'Beograd', 'Bulevar Mihajla Pupina', 33, '0643404474', 'student33@gmail.com', 0);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (34, 'Letty', 'Simonis', 'EE 34/2014', '2000-02-18', 'Beograd', 'Marka Čelebonovića', 89, '0644562157', 'student34@gmail.com', 0);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (35, 'Debra', 'Gusikowski', 'A4 35/2013', '2000-03-07', 'Beograd', 'Vojvođanska', 49, '0647834828', 'student35@gmail.com', 0);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (36, 'Hoyt', 'Kuhlman', 'RA 36/2016', '2000-10-18', 'Beograd', 'Omladinskih brigada', 84, '0646253131', 'student36@gmail.com', 3);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (37, 'Randal', 'Jast', 'F1 37/2011', '2000-08-14', 'Beograd', 'Bulevar vojvode Putnika', 11, '0642327804', 'student37@gmail.com', 3);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (38, 'Caterina', 'Gerlach', 'ER 38/2014', '2000-08-09', 'Beograd', 'Teodora Drajzera', 17, '0649833143', 'student38@gmail.com', 0);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (39, 'Ahmed', 'Greenfelder', 'XF 39/2018', '2000-08-11', 'Beograd', 'Sinđelićeva', 53, '0644106584', 'student39@gmail.com', 0);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (40, 'Sammie', 'Jakubowski', 'M1 40/2020', '2000-04-21', 'Beograd', 'Ustanička', 44, '0644174511', 'student40@gmail.com', 3);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (41, 'Demetrius', 'Jakubowski', 'Z2 41/2016', '2000-09-02', 'Novi Sad', 'Bulevar cara Lazara', 72, '0646095028', 'student41@gmail.com', 1);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (42, 'Shon', 'King', 'A6 42/2012', '2000-02-05', 'Novi Sad', 'Bulevar despota Stefana', 42, '0648351078', 'student42@gmail.com', 1);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (43, 'Addie', 'Mante', 'DE 43/2019', '2000-02-23', 'Novi Sad', 'Bulevar Evrope', 28, '0645467824', 'student43@gmail.com', 0);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (44, 'Corrie', 'Gerlach', 'ER 44/2014', '2000-10-18', 'Novi Sad', 'Bulevar Jaše Tomića', 25, '0645726075', 'student44@gmail.com', 4);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (45, 'Len', 'Bechtelar', 'PE 45/2011', '2000-06-24', 'Novi Sad', 'Bulevar Jovana Dučića', 76, '0649275901', 'student45@gmail.com', 1);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (46, 'Jerrell', 'Smith', 'IJ 46/2016', '2000-07-20', 'Novi Sad', 'Bulevar kneza Miloša', 41, '0641135152', 'student46@gmail.com', 2);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (47, 'Lamar', 'Rath', 'DP 47/2019', '2000-03-24', 'Novi Sad', 'Bulevar kralja Petra I', 82, '0641142041', 'student47@gmail.com', 0);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (48, 'Junior', 'Bogan', 'MR 48/2011', '2000-09-21', 'Novi Sad', 'Bulevar Mihajla Pupina', 55, '0641519683', 'student48@gmail.com', 0);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (49, 'Elliot', 'Schumm', 'DT 49/2011', '2000-08-21', 'Novi Sad', 'Bulevar oslobođenja', 54, '0644803183', 'student49@gmail.com', 3);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (50, 'Diamond', 'Feeney', 'DO 50/2015', '2000-06-20', 'Novi Sad', 'Bulevar Patrijarha Pavla', 42, '0641581009', 'student50@gmail.com', 2);
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------- Altering student_id_seq ----------------------------------------------------------------------------------------
alter sequence student_id_seq restart with 51;
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

