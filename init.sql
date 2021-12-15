DROP DATABASE IF EXISTS manufacture;
CREATE DATABASE manufacture;

\c manufacture;


CREATE TABLE Grade (
    grade_id SERIAL PRIMARY KEY,
    grade_name VARCHAR(100),
    UNIQUE (grade_name)
);

INSERT INTO Grade (grade_name) VALUES ('1-A');
INSERT INTO Grade (grade_name) VALUES ('1-B');

CREATE TABLE Student (
    student_id SERIAL PRIMARY KEY,
    name VARCHAR(100),
    age INT,
    grade_id INT,
    CONSTRAINT fk_grade_id FOREIGN KEY(grade_id) REFERENCES Grade(grade_id)
);

CREATE TABLE Lesson (
    lesson_id SERIAL PRIMARY KEY,
    name VARCHAR(100),
    grade_id INT,
    CONSTRAINT fk_grade_id FOREIGN KEY(grade_id) REFERENCES Grade(grade_id)
);

CREATE TABLE Mark (
    mark_id SERIAL PRIMARY KEY,
    val INT,
    attended BOOLEAN,
    student_id INT,
    lesson_id INT,
    CONSTRAINT fk_student_id FOREIGN KEY(student_id) REFERENCES Student(student_id),
    CONSTRAINT fk_lesson_id FOREIGN KEY(lesson_id) REFERENCES Lesson(lesson_id)
);

CREATE TABLE RESULT(
    result_id SERIAL PRIMARY KEY,
    skipped_lessons INT,
    average_mark INT,
    student_id INT,
    CONSTRAINT fk_student_id FOREIGN KEY(student_id) REFERENCES Student(student_id)
);

INSERT INTO Student (name, age, grade_id) VALUES ('Peter Parker', 11, 1);
INSERT INTO Student (name, age, grade_id) VALUES ('Ilon Mask', 12, 2);
INSERT INTO Student (name, age, grade_id) VALUES ('Robert De Niro', 10, 1);

INSERT INTO Lesson (name, grade_id) VALUES ('Math', 1);
INSERT INTO Lesson (name, grade_id) VALUES ('Russian', 1);
INSERT INTO Lesson (name, grade_id) VALUES ('Ukrainian', 2);

INSERT INTO Mark(val, attended, student_id, lesson_id) VALUES (3, true, 1, 1);