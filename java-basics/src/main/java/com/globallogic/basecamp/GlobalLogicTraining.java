package com.globallogic.basecamp;

import java.util.HashMap;
import java.util.Optional;

/*
 * GlobalLogicTraining.java
 *
 *  Created for: GlobalLogic
 *       Author: anna.alieksieienko
 *
 * Implementation of the Training interface
 *
 * You will need to implement the necessary methods in order to complete the task
 *
 * Try to understand the required behavior from the provided unit tests
 *
 */
public class GlobalLogicTraining implements Training {

    private final String name;

    private final HashMap<Student, Grade> grades = new HashMap<>();

    public GlobalLogicTraining(String name) {
        if(name == null || name.isEmpty())
            throw new IllegalArgumentException();
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean addStudent(Student student)
    {
        if(grades.containsKey(student)) return false;

        grades.put(student, new Grade());
        return true;
    }

    @Override
    public boolean removeStudent(Student student)
    {
        if(!grades.containsKey(student)) return false;
        grades.remove(student);
        return true;
    }

    @Override
    public boolean rateFirstSemester(Student student, int mark) {

        if(!grades.containsKey(student))
        {
            return false;
        }
        else if(mark > 10 || mark < 0)
        {
            throw new IllegalArgumentException();
        }

        Grade studentGrade = grades.get(student);
        if(studentGrade == null) studentGrade = new Grade();
        studentGrade.setFirstSemester(mark);

        grades.replace(student, studentGrade);
        return true;
    }

    @Override
    public boolean rateSecondSemester(Student student, int mark) {
        if(!grades.containsKey(student))
        {
            return false;
        }
        else if(mark > 10 || mark < 0)
        {
            throw new IllegalArgumentException();
        }

        Grade studentGrade = grades.get(student);
        if(studentGrade == null) studentGrade = new Grade();
        studentGrade.setSecondSemester(mark);

        grades.replace(student, studentGrade);
        return true;
    }

    @Override
    public boolean isPresent(Student student) {
        return grades.containsKey(student);
    }

    @Override
    public Optional<Grade> getStudentGrade(Student student) {
        return Optional.ofNullable(grades.get(student));
    }
}
