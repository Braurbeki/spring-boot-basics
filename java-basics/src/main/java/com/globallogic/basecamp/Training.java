package com.globallogic.basecamp;

import java.util.Optional;

/*
 * Training.java
 *
 *  Created for: GlobalLogic
 *       Author: anna.alieksieienko
 *
 * Training interface that declares the main management system functionality
 *
 * You may change this file, but it will be restored on Jenkins CI side
 * before each build.
 *
 */
public interface Training {

    String getName();

    boolean addStudent(Student student);

    boolean removeStudent(Student student);

    boolean rateFirstSemester(Student student, int mark);

    boolean rateSecondSemester(Student student, int mark);

    boolean isPresent(Student student);

    Optional<Grade> getStudentGrade(Student student);

}
