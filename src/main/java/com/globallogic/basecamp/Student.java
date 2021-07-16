package com.globallogic.basecamp;

import java.util.Objects;

/*
 * Student.java
 *
 *  Created for: GlobalLogic
 *       Author: anna.alieksieienko
 *
 * Representation of the student that attends the training.
 *
 * The provided unit tests will help you to understand the necessary changes in this class
 *
 */
public class Student {

    public Student() {
    }

    public Student(String firstName, String lastName) {

    }

    String firstName;

    String lastName;

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Student)) {
            return false;
        }
        final var student = (Student) o;
        return firstName.equals(student.firstName) && lastName.equals(student.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

}