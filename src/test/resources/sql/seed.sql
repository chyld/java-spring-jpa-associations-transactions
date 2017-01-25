use edtst;

set FOREIGN_KEY_CHECKS = 0;
truncate table grades;
truncate table klasses;
truncate table students;
set FOREIGN_KEY_CHECKS = 1;

insert into students (email) values
  ('bob@aol.com'),
  ('sue@aol.com'),
  ('ali@aol.com'),
  ('joe@aol.com');

insert into klasses (credits, department, fee, name, semester) values
  (4, 'SCIENCE', 500.0, 'Physics 101', '2017-01-25 00:00:00'),
  (3, 'ENGINEERING', 550.0, 'Electrical Engineering 101', '2018-01-25 00:00:00'),
  (2, 'SCIENCE', 430.0, 'Calculus 101', '2019-01-25 00:00:00');

insert into grades (student_id, klass_id, is_passing, value) values
  (1, 1, true, 91),
  (2, 1, true, 98),
  (3, 1, false, 45),
  (1, 2, false, 23),
  (2, 2, true, 82),
  (3, 2, false, 63),
  (1, 3, false, 17),
  (2, 3, true, 76),
  (3, 3, true, 89);
