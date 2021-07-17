package com.globallogic.basecamp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * StudentTest.java
 *
 *  Created for: GlobalLogic
 *       Author: anna.alieksieienko
 *
 * Tests for the Student class. Use it to understand which changes must be
 * made for student representation so that the management system will work correctly
 *
 * You may change this file, but it will be restored on Jenkins CI side
 * before each build.
 *
 * If you are not familiar with JUnit, please, refer to the https://junit.org/junit5/
 *
 */
class StudentTest {

    @Test
    void testInheritance() {
        final var testClass = Student.class;
        Assertions.assertTrue(Modifier.isFinal(testClass.getModifiers()));
    }

    @Test
    void testFields() {
        final var testClass = Student.class;
        final var fields = testClass.getDeclaredFields();
        Stream.of(fields).forEach(entry -> Assertions.assertTrue(
                Modifier.isFinal(entry.getModifiers())
                        && Modifier.isPrivate(entry.getModifiers())
                )
        );
    }

    @Test
    void testMethods() {
        final var testClass = Student.class;
        final var methods = testClass.getDeclaredMethods();
        Assertions.assertEquals(4, methods.length);
        Arrays.stream(methods).map(Method::getName)
                .collect(Collectors.toList())
                .containsAll(Arrays.asList("getFirstName",
                        "getLastName", "equals", "hashCode"));
    }

    @Test
    void testConstructor() {
        final var testClass = Student.class;
        final var constructors = testClass.getDeclaredConstructors();
        Assertions.assertEquals(1, constructors.length);
        final var studentConstructor = constructors[0];
        Assertions.assertEquals(2, studentConstructor.getParameterCount());
        Arrays.stream(studentConstructor.getParameterTypes()).forEach(t -> {
                    Assertions.assertEquals(String.class, t);
                }
        );
    }

    @Test
    void testWrongParameters() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Student("Jerry", null)
        );
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Student(null, null)
        );
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Student("", "Ferdy")
        );
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Student("Jerry", null)
        );
    }

    @Test
    void testInitialization() {
        final String firstName = "Jerry";
        final String lastName = "Ferdy";
        final var student = new Student(firstName, lastName);
        Assertions.assertEquals(firstName, student.getFirstName());
        Assertions.assertEquals(lastName, student.getLastName());
    }

    @Test
    void testEquality() {
        final var firstName = "Jerry";
        final var lastName = "Ferdy";
        final var student1 = new Student(firstName, lastName);
        final var student2 = new Student(firstName, lastName);
        Assertions.assertEquals(student1, student2);
        Assertions.assertEquals(student1.hashCode(), student2.hashCode());
    }

    @Test
    void testInequality() {
        final var firstName = "Jerry";
        final var lastName = "Ferdy";
        final var student1 = new Student(firstName, lastName);
        final var student2 = new Student(firstName, "Perry");
        final var student3 = new Student("Amanda", lastName);
        Assertions.assertNotEquals(student1, student2);
        Assertions.assertNotEquals(student1, student3);
        Assertions.assertNotEquals(student2, student3);
    }

}