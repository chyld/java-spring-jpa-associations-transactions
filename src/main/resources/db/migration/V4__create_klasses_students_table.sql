CREATE TABLE `klasses_students` (
  `student_id` INT NOT NULL,
  `klass_id`   INT NOT NULL,

  CONSTRAINT `fk_student_id1`
  FOREIGN KEY (`student_id`)
  REFERENCES `students` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,

  CONSTRAINT `fk_klass_id1`
  FOREIGN KEY (`klass_id`)
  REFERENCES `klasses` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
