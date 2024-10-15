-- Script generates database for student-service
-- It generates:
--	- 50 students
--
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------ Inserting students ------------------------------------------------------------------------------------------
insert into students (id, name, surname) values (1, 'Tuyet', 'Rath');
insert into students (id, name, surname) values (2, 'Dolly', 'Osinski');
insert into students (id, name, surname) values (3, 'Milly', 'Carroll');
insert into students (id, name, surname) values (4, 'Millard', 'Corkery');
insert into students (id, name, surname) values (5, 'Nita', 'Harris');
insert into students (id, name, surname) values (6, 'Elise', 'Shanahan');
insert into students (id, name, surname) values (7, 'Fransisca', 'Marks');
insert into students (id, name, surname) values (8, 'Belen', 'Block');
insert into students (id, name, surname) values (9, 'Zachary', 'Boehm');
insert into students (id, name, surname) values (10, 'Damaris', 'Koch');
insert into students (id, name, surname) values (11, 'Zona', 'Breitenberg');
insert into students (id, name, surname) values (12, 'Stewart', 'Thiel');
insert into students (id, name, surname) values (13, 'Reinaldo', 'Johnston');
insert into students (id, name, surname) values (14, 'Tyesha', 'Sanford');
insert into students (id, name, surname) values (15, 'Virgil', 'Hane');
insert into students (id, name, surname) values (16, 'Marietta', 'Rempel');
insert into students (id, name, surname) values (17, 'Mitzie', 'Auer');
insert into students (id, name, surname) values (18, 'Corrina', 'Rowe');
insert into students (id, name, surname) values (19, 'Brain', 'Russel');
insert into students (id, name, surname) values (20, 'Verona', 'Tillman');
insert into students (id, name, surname) values (21, 'Diedre', 'Marks');
insert into students (id, name, surname) values (22, 'Forest', 'Koch');
insert into students (id, name, surname) values (23, 'Saul', 'Skiles');
insert into students (id, name, surname) values (24, 'Edie', 'Rohan');
insert into students (id, name, surname) values (25, 'Astrid', 'Ankunding');
insert into students (id, name, surname) values (26, 'Reid', 'Schuppe');
insert into students (id, name, surname) values (27, 'Branden', 'Witting');
insert into students (id, name, surname) values (28, 'Earl', 'King');
insert into students (id, name, surname) values (29, 'Allyson', 'Crona');
insert into students (id, name, surname) values (30, 'Kathyrn', 'Ruecker');
insert into students (id, name, surname) values (31, 'January', 'Wisozk');
insert into students (id, name, surname) values (32, 'Lynsey', 'Goyette');
insert into students (id, name, surname) values (33, 'Lurline', 'Breitenberg');
insert into students (id, name, surname) values (34, 'Carson', 'Graham');
insert into students (id, name, surname) values (35, 'Farrah', 'Luettgen');
insert into students (id, name, surname) values (36, 'Milo', 'Tillman');
insert into students (id, name, surname) values (37, 'Brian', 'Weissnat');
insert into students (id, name, surname) values (38, 'Eugene', 'Upton');
insert into students (id, name, surname) values (39, 'Marcelina', 'Collins');
insert into students (id, name, surname) values (40, 'Solomon', 'Balistreri');
insert into students (id, name, surname) values (41, 'Colin', 'Koss');
insert into students (id, name, surname) values (42, 'Adolph', 'Nitzsche');
insert into students (id, name, surname) values (43, 'Dulcie', 'Greenholt');
insert into students (id, name, surname) values (44, 'In', 'Schmitt');
insert into students (id, name, surname) values (45, 'Wan', 'Effertz');
insert into students (id, name, surname) values (46, 'Aurelio', 'Johnson');
insert into students (id, name, surname) values (47, 'Thad', 'Pacocha');
insert into students (id, name, surname) values (48, 'Rod', 'Bosco');
insert into students (id, name, surname) values (49, 'Shaina', 'Denesik');
insert into students (id, name, surname) values (50, 'Bernarda', 'Rodriguez');
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------- Altering student_id_seq ----------------------------------------------------------------------------------------
alter sequence student_id_seq restart with 51;
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

