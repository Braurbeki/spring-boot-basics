package com.globallogic.basecamp;

/*
 * Grade.java
 *
 *  Created for: GlobalLogic
 *       Author: anna.alieksieienko
 *
 * Grade that student received during the training. Consists of the first
 * and second semester marks.
 *
 * You may change this file, but it will be restored on Jenkins CI side
 * before each build.
 *
 */
public class Grade {

    private int firstSemester;

    private int secondSemester;

    public int getSecondSemester() {
        return secondSemester;
    }

    public int getFirstSemester() {
        return firstSemester;
    }

    public void setSecondSemester(int secondSemester) {
        this.secondSemester = secondSemester;
    }

    public void setFirstSemester(int firstSemester) {
        this.firstSemester = firstSemester;
    }

}
