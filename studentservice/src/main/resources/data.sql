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
insert into users (id, name, surname, username, password, role) values (1, 'Blake', 'Heaney', 'admin1', '$2a$10$JCYrt8QGHg4suBXWiRgjKu93h5DCq3yFDXMDsTY/Itkgeu3h3pCE6', 'ADMIN');
insert into users (id, name, surname, username, password, role) values (2, 'Elise', 'Ondricka', 'admin2', '$2a$10$JCYrt8QGHg4suBXWiRgjKu93h5DCq3yFDXMDsTY/Itkgeu3h3pCE6', 'ADMIN');
insert into users (id, name, surname, username, password, role) values (3, 'Erna', 'Paucek', 'admin3', '$2a$10$JCYrt8QGHg4suBXWiRgjKu93h5DCq3yFDXMDsTY/Itkgeu3h3pCE6', 'ADMIN');
insert into users (id, name, surname, username, password, role) values (4, 'Edmund', 'Marquardt', 'admin4', '$2a$10$JCYrt8QGHg4suBXWiRgjKu93h5DCq3yFDXMDsTY/Itkgeu3h3pCE6', 'ADMIN');
insert into users (id, name, surname, username, password, role) values (5, 'Ward', 'Beer', 'admin5', '$2a$10$JCYrt8QGHg4suBXWiRgjKu93h5DCq3yFDXMDsTY/Itkgeu3h3pCE6', 'ADMIN');
insert into users (id, name, surname, username, password, role) values (6, 'Deb', 'Pfannerstill', 'admin6', '$2a$10$JCYrt8QGHg4suBXWiRgjKu93h5DCq3yFDXMDsTY/Itkgeu3h3pCE6', 'ADMIN');
insert into users (id, name, surname, username, password, role) values (7, 'Roberta', 'Stiedemann', 'admin7', '$2a$10$JCYrt8QGHg4suBXWiRgjKu93h5DCq3yFDXMDsTY/Itkgeu3h3pCE6', 'ADMIN');
insert into users (id, name, surname, username, password, role) values (8, 'Jacques', 'Pfannerstill', 'admin8', '$2a$10$JCYrt8QGHg4suBXWiRgjKu93h5DCq3yFDXMDsTY/Itkgeu3h3pCE6', 'ADMIN');
insert into users (id, name, surname, username, password, role) values (9, 'Taylor', 'Terry', 'admin9', '$2a$10$JCYrt8QGHg4suBXWiRgjKu93h5DCq3yFDXMDsTY/Itkgeu3h3pCE6', 'ADMIN');
insert into users (id, name, surname, username, password, role) values (10, 'Elmo', 'Blick', 'admin10', '$2a$10$JCYrt8QGHg4suBXWiRgjKu93h5DCq3yFDXMDsTY/Itkgeu3h3pCE6', 'ADMIN');
insert into users (id, name, surname, username, password, role) values (11, 'Ramiro', 'Ortiz', 'referent1', '$2a$10$JCYrt8QGHg4suBXWiRgjKu93h5DCq3yFDXMDsTY/Itkgeu3h3pCE6', 'REFERENT');
insert into users (id, name, surname, username, password, role) values (12, 'Hue', 'Leffler', 'referent2', '$2a$10$JCYrt8QGHg4suBXWiRgjKu93h5DCq3yFDXMDsTY/Itkgeu3h3pCE6', 'REFERENT');
insert into users (id, name, surname, username, password, role) values (13, 'Cherri', 'Bruen', 'referent3', '$2a$10$JCYrt8QGHg4suBXWiRgjKu93h5DCq3yFDXMDsTY/Itkgeu3h3pCE6', 'REFERENT');
insert into users (id, name, surname, username, password, role) values (14, 'Shawn', 'Kunde', 'referent4', '$2a$10$JCYrt8QGHg4suBXWiRgjKu93h5DCq3yFDXMDsTY/Itkgeu3h3pCE6', 'REFERENT');
insert into users (id, name, surname, username, password, role) values (15, 'Morris', 'Schiller', 'referent5', '$2a$10$JCYrt8QGHg4suBXWiRgjKu93h5DCq3yFDXMDsTY/Itkgeu3h3pCE6', 'REFERENT');
insert into users (id, name, surname, username, password, role) values (16, 'Linn', 'Conroy', 'referent6', '$2a$10$JCYrt8QGHg4suBXWiRgjKu93h5DCq3yFDXMDsTY/Itkgeu3h3pCE6', 'REFERENT');
insert into users (id, name, surname, username, password, role) values (17, 'Rico', 'Kuhlman', 'referent7', '$2a$10$JCYrt8QGHg4suBXWiRgjKu93h5DCq3yFDXMDsTY/Itkgeu3h3pCE6', 'REFERENT');
insert into users (id, name, surname, username, password, role) values (18, 'Robin', 'Durgan', 'referent8', '$2a$10$JCYrt8QGHg4suBXWiRgjKu93h5DCq3yFDXMDsTY/Itkgeu3h3pCE6', 'REFERENT');
insert into users (id, name, surname, username, password, role) values (19, 'Elias', 'Satterfield', 'referent9', '$2a$10$JCYrt8QGHg4suBXWiRgjKu93h5DCq3yFDXMDsTY/Itkgeu3h3pCE6', 'REFERENT');
insert into users (id, name, surname, username, password, role) values (20, 'Johnie', 'Streich', 'referent10', '$2a$10$JCYrt8QGHg4suBXWiRgjKu93h5DCq3yFDXMDsTY/Itkgeu3h3pCE6', 'REFERENT');
insert into users (id, name, surname, username, password, role) values (21, 'Donte', 'Braun', 'referent11', '$2a$10$JCYrt8QGHg4suBXWiRgjKu93h5DCq3yFDXMDsTY/Itkgeu3h3pCE6', 'REFERENT');
insert into users (id, name, surname, username, password, role) values (22, 'Jarod', 'Abshire', 'referent12', '$2a$10$JCYrt8QGHg4suBXWiRgjKu93h5DCq3yFDXMDsTY/Itkgeu3h3pCE6', 'REFERENT');
insert into users (id, name, surname, username, password, role) values (23, 'Minerva', 'Schuppe', 'referent13', '$2a$10$JCYrt8QGHg4suBXWiRgjKu93h5DCq3yFDXMDsTY/Itkgeu3h3pCE6', 'REFERENT');
insert into users (id, name, surname, username, password, role) values (24, 'Oleta', 'Simonis', 'referent14', '$2a$10$JCYrt8QGHg4suBXWiRgjKu93h5DCq3yFDXMDsTY/Itkgeu3h3pCE6', 'REFERENT');
insert into users (id, name, surname, username, password, role) values (25, 'Tommy', 'Gusikowski', 'referent15', '$2a$10$JCYrt8QGHg4suBXWiRgjKu93h5DCq3yFDXMDsTY/Itkgeu3h3pCE6', 'REFERENT');
insert into users (id, name, surname, username, password, role) values (26, 'Kerry', 'Smith', 'referent16', '$2a$10$JCYrt8QGHg4suBXWiRgjKu93h5DCq3yFDXMDsTY/Itkgeu3h3pCE6', 'REFERENT');
insert into users (id, name, surname, username, password, role) values (27, 'Forest', 'Howell', 'referent17', '$2a$10$JCYrt8QGHg4suBXWiRgjKu93h5DCq3yFDXMDsTY/Itkgeu3h3pCE6', 'REFERENT');
insert into users (id, name, surname, username, password, role) values (28, 'Devon', 'Beatty', 'referent18', '$2a$10$JCYrt8QGHg4suBXWiRgjKu93h5DCq3yFDXMDsTY/Itkgeu3h3pCE6', 'REFERENT');
insert into users (id, name, surname, username, password, role) values (29, 'Huey', 'Schmidt', 'referent19', '$2a$10$JCYrt8QGHg4suBXWiRgjKu93h5DCq3yFDXMDsTY/Itkgeu3h3pCE6', 'REFERENT');
insert into users (id, name, surname, username, password, role) values (30, 'Brittaney', 'Hahn', 'referent20', '$2a$10$JCYrt8QGHg4suBXWiRgjKu93h5DCq3yFDXMDsTY/Itkgeu3h3pCE6', 'REFERENT');
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------- Altering user_id_seq -----------------------------------------------------------------------------------------
alter sequence user_id_seq restart with 31;
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------ Inserting students ------------------------------------------------------------------------------------------
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (1, 'Noe', 'Upton', 'IT 1/2014', '2000-03-04', 'Beograd', 'Bulevar Milutina Milankovića', 23, '0642706317', 'student1@gmail.com', 1);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (2, 'Cecile', 'McLaughlin', 'DT 2/2018', '2000-08-16', 'Beograd', 'Cara Dušana', 19, '0642501012', 'student2@gmail.com', 3);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (3, 'Ngan', 'Romaguera', 'MB 3/2012', '2000-05-09', 'Beograd', 'Savska', 13, '0644163251', 'student3@gmail.com', 1);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (4, 'Monty', 'O''Hara', 'EL 4/2018', '2000-09-23', 'Beograd', 'Nemanjina', 74, '0645531797', 'student4@gmail.com', 1);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (5, 'Johnathon', 'Wolf', 'SZ 5/2019', '2000-03-20', 'Beograd', 'Južni bulevar', 21, '0641616004', 'student5@gmail.com', 3);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (6, 'Sherry', 'Mueller', 'GI 6/2015', '2000-05-21', 'Beograd', 'Bulevar kneza Aleksandra Karađorđevića', 67, '0641523175', 'student6@gmail.com', 3);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (7, 'Deloris', 'McKenzie', 'I7 7/2014', '2000-06-08', 'Beograd', 'Dr Milutina Ivkovića', 62, '0647161087', 'student7@gmail.com', 3);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (8, 'Elsy', 'Bailey', 'E3 8/2018', '2000-08-09', 'Beograd', 'Vojvode Stepe', 86, '0644507861', 'student8@gmail.com', 2);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (9, 'Clement', 'Murphy', 'C1 9/2021', '2000-10-13', 'Beograd', 'Jurija Gagarina', 32, '0643413486', 'student9@gmail.com', 2);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (10, 'Gus', 'O''Hara', 'RS 10/2015', '2000-08-17', 'Beograd', 'Gandijeva', 63, '0647211107', 'student10@gmail.com', 4);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (11, 'Jackqueline', 'Skiles', 'A1 11/2010', '2000-04-21', 'Beograd', 'Pariske komune', 40, '0644823436', 'student11@gmail.com', 3);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (12, 'Eddy', 'Wilderman', 'ET 12/2019', '2000-10-23', 'Beograd', 'Bulevar Nikole Tesle', 82, '0647223714', 'student12@gmail.com', 1);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (13, 'Liana', 'Sauer', 'DL 13/2019', '2000-05-09', 'Beograd', 'Bulevar Zorana Đinđića', 74, '0642570720', 'student13@gmail.com', 0);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (14, 'Cecille', 'McGlynn', 'E9 14/2017', '2000-03-23', 'Beograd', 'Milentija Popovića', 46, '0644419887', 'student14@gmail.com', 0);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (15, 'Parker', 'Hayes', 'GE 15/2012', '2000-01-03', 'Beograd', 'Bulevar Despota Stefana', 17, '0647103275', 'student15@gmail.com', 3);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (16, 'Bobby', 'Kessler', 'MT 16/2021', '2000-03-07', 'Beograd', 'Dimitrija Tucovića', 3, '0648572207', 'student16@gmail.com', 3);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (17, 'Reyes', 'Langosh', 'ZS 17/2021', '2000-05-23', 'Beograd', 'Žička', 27, '0646591085', 'student17@gmail.com', 2);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (18, 'Bernardina', 'Nienow', 'GR 18/2019', '2000-09-18', 'Beograd', 'Višnjička', 32, '0647408030', 'student18@gmail.com', 2);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (19, 'Zonia', 'Kuhlman', 'SW 19/2016', '2000-01-27', 'Beograd', 'Jovanke Radaković', 81, '0648624133', 'student19@gmail.com', 2);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (20, 'Felipa', 'Marvin', 'DL 20/2015', '2000-03-13', 'Beograd', 'Vitanovačka', 67, '0648212378', 'student20@gmail.com', 4);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (21, 'Kerry', 'Prohaska', 'MP 21/2010', '2000-02-04', 'Beograd', 'Kumodraška', 6, '0644229321', 'student21@gmail.com', 4);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (22, 'Alexis', 'Swaniawski', 'DN 22/2017', '2000-06-26', 'Beograd', 'Neznanog junaka', 70, '0646015036', 'student22@gmail.com', 1);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (23, 'Julene', 'Langworth', 'E6 23/2013', '2000-03-13', 'Beograd', 'Braće Jerković', 64, '0640117171', 'student23@gmail.com', 2);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (24, 'Scotty', 'Cronin', 'M2 24/2010', '2000-03-06', 'Beograd', 'Svetozara Radojčića', 69, '0640524774', 'student24@gmail.com', 1);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (25, 'Forest', 'Fadel', 'XA 25/2019', '2000-03-01', 'Beograd', 'Mite Ružića', 85, '0645286972', 'student25@gmail.com', 3);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (26, 'Albert', 'Bailey', 'ZR 26/2020', '2000-06-08', 'Beograd', 'Milana Rakića', 23, '0643454607', 'student26@gmail.com', 2);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (27, 'Gil', 'Torphy', 'DE 27/2018', '2000-06-19', 'Beograd', 'Bulevar vojvode Mišića', 6, '0647340783', 'student27@gmail.com', 2);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (28, 'Dewitt', 'Streich', 'F1 28/2011', '2000-02-25', 'Beograd', 'Bulevar Patrijarha Pavla', 61, '0647033398', 'student28@gmail.com', 3);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (29, 'Olin', 'VonRueden', 'MH 29/2011', '2000-02-16', 'Beograd', 'Požeška', 83, '0644242141', 'student29@gmail.com', 2);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (30, 'Jeremy', 'Padberg', 'R2 30/2018', '2000-03-11', 'Beograd', 'Radnička', 68, '0649148806', 'student30@gmail.com', 0);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (31, 'Mazie', 'Parker', 'V2 31/2021', '2000-02-23', 'Beograd', 'Prvomajska', 19, '0641442573', 'student31@gmail.com', 1);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (32, 'Jeanice', 'Swift', 'A2 32/2012', '2000-07-02', 'Beograd', 'Tošin bunar', 54, '0641081326', 'student32@gmail.com', 0);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (33, 'Roscoe', 'Bogan', 'SW 33/2020', '2000-03-05', 'Beograd', 'Bulevar Mihajla Pupina', 33, '0646411421', 'student33@gmail.com', 4);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (34, 'Jayson', 'Terry', 'S1 34/2017', '2000-04-12', 'Beograd', 'Marka Čelebonovića', 89, '0643263062', 'student34@gmail.com', 0);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (35, 'Jeff', 'Jacobs', 'MP 35/2015', '2000-06-23', 'Beograd', 'Vojvođanska', 49, '0641720741', 'student35@gmail.com', 3);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (36, 'Kaley', 'Harris', 'DG 36/2017', '2000-03-12', 'Beograd', 'Omladinskih brigada', 84, '0647854158', 'student36@gmail.com', 0);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (37, 'Marlon', 'Armstrong', 'DM 37/2015', '2000-06-15', 'Beograd', 'Bulevar vojvode Putnika', 11, '0640521224', 'student37@gmail.com', 0);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (38, 'Sang', 'Rempel', 'DZ 38/2016', '2000-10-22', 'Beograd', 'Teodora Drajzera', 17, '0643536303', 'student38@gmail.com', 3);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (39, 'Antony', 'Pfeffer', 'V1 39/2017', '2000-07-04', 'Beograd', 'Sinđelićeva', 53, '0643137144', 'student39@gmail.com', 0);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (40, 'Chris', 'Gleichner', 'IM 40/2018', '2000-10-20', 'Beograd', 'Ustanička', 44, '0640336260', 'student40@gmail.com', 4);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (41, 'Melvin', 'Welch', 'S1 41/2020', '2000-09-12', 'Novi Sad', 'Bulevar cara Lazara', 72, '0648735173', 'student41@gmail.com', 2);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (42, 'Sharlene', 'Kuphal', 'IT 42/2018', '2000-08-10', 'Novi Sad', 'Bulevar despota Stefana', 42, '0648608240', 'student42@gmail.com', 1);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (43, 'Conrad', 'Zemlak', 'E2 43/2020', '2000-06-11', 'Novi Sad', 'Bulevar Evrope', 28, '0646900857', 'student43@gmail.com', 1);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (44, 'Peter', 'Schneider', 'V1 44/2011', '2000-05-25', 'Novi Sad', 'Bulevar Jaše Tomića', 25, '0646541444', 'student44@gmail.com', 2);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (45, 'Lynn', 'Herzog', 'ER 45/2017', '2000-05-15', 'Novi Sad', 'Bulevar Jovana Dučića', 76, '0643725365', 'student45@gmail.com', 1);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (46, 'Stevie', 'Kunde', 'XE 46/2021', '2000-03-14', 'Novi Sad', 'Bulevar kneza Miloša', 41, '0640685209', 'student46@gmail.com', 1);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (47, 'Neal', 'Beier', 'C1 47/2019', '2000-09-02', 'Novi Sad', 'Bulevar kralja Petra I', 82, '0642555212', 'student47@gmail.com', 4);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (48, 'Laurence', 'Huels', 'A6 48/2021', '2000-04-26', 'Novi Sad', 'Bulevar Mihajla Pupina', 55, '0643219580', 'student48@gmail.com', 1);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (49, 'Tomeka', 'Berge', 'ES 49/2018', '2000-09-20', 'Novi Sad', 'Bulevar oslobođenja', 54, '0641381004', 'student49@gmail.com', 2);
insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (50, 'Somer', 'Schinner', 'S2 50/2012', '2000-06-24', 'Novi Sad', 'Bulevar Patrijarha Pavla', 42, '0644541676', 'student50@gmail.com', 0);
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------- Altering student_id_seq ----------------------------------------------------------------------------------------
alter sequence student_id_seq restart with 51;
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

