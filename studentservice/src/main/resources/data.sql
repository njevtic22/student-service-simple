insert into students (id, name, surname) values (1, 'Petar', 'Petrovic');
insert into students (id, name, surname) values (2, 'Marko', 'Markovic');
insert into students (id, name, surname) values (3, 'Stefan', 'Stefanovic');
insert into students (id, name, surname) values (4, 'Jovan', 'Jovanovic');
insert into students (id, name, surname) values (5, 'Ivan', 'Ivanovic');

alter sequence student_id_seq restart with 6;
