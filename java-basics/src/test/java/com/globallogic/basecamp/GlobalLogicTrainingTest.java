package com.globallogic.basecamp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Modifier;
import java.util.HashMap;

/*
 * GlobalLogicTrainingTest.java
 *
 *  Created for: GlobalLogic
 *       Author: anna.alieksieienko
 *
 * Tests for the GlobalLogicTraining class. Use it to understand how the main
 * functionality must be implemented
 *
 * You may change this file, but it will be restored on Jenkins CI side
 * before each build.
 *
 * If you are not familiar with JUnit, please, refer to the https://junit.org/junit5/
 *
 */
class GlobalLogicTrainingTest {

    private static final Class<GlobalLogicTraining> TRAINING_CLASS = GlobalLogicTraining.class;
    private static final String NAME_FIELD = "name";
    private static final String GRADES_FIELD = "grades";

    @Test
    void testFields() throws NoSuchFieldException {
        final var name = TRAINING_CLASS.getDeclaredField(NAME_FIELD);
        final var grades = TRAINING_CLASS.getDeclaredField(GRADES_FIELD);
        final var nameModifiers = name.getModifiers();
        final var gradesModifiers = grades.getModifiers();

        Assertions.assertTrue(Modifier.isFinal(nameModifiers));
        Assertions.assertTrue(Modifier.isPrivate(nameModifiers));
        Assertions.assertTrue(Modifier.isFinal(gradesModifiers));
        Assertions.assertTrue(Modifier.isPrivate(gradesModifiers));

        final var nameType = name.getType();
        final var gradesType = grades.getType();

        Assertions.assertTrue(String.class.isAssignableFrom(nameType));
        Assertions.assertTrue(HashMap.class.isAssignableFrom(gradesType));
    }

    @Test
    void testImplementation() {
        final var trainingClass = GlobalLogicTraining.class;
        Assertions.assertTrue(Training.class.isAssignableFrom(trainingClass));
    }

    @Test
    void testConstruct() {
        final var name = "Math";
        final var training = new GlobalLogicTraining(name);
        Assertions.assertEquals(name, training.getName());
    }

    @Test
    void testConstructWithWrongName() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new GlobalLogicTraining(null));
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new GlobalLogicTraining(""));
    }

    @Test
    void testAddStudent() throws ReflectiveOperationException {
        final var training = new GlobalLogicTraining("Math");
        final var student = new Student("Jerry", "Ferdy");
        final var grades = getInternalMap(training);
        Assertions.assertTrue(training.addStudent(student));
        Assertions.assertTrue(grades.containsKey(student));
    }

    @Test
    void testAddIfStudentExists() {
        final var training = new GlobalLogicTraining("Math");
        final var student = new Student("Jerry", "Ferdy");
        Assertions.assertTrue(training.addStudent(student));
        Assertions.assertFalse(training.addStudent(student));
    }

    @Test
    void testRemoveStudent() throws ReflectiveOperationException {
        final var training = new GlobalLogicTraining("Math");
        final var student = new Student("Jerry", "Ferdy");
        final var grades = getInternalMap(training);
        grades.put(student, null);
        Assertions.assertTrue(training.removeStudent(student));
        Assertions.assertFalse(grades.containsKey(student));
    }

    @Test
    void testRemoveIfStudentAbsent() throws ReflectiveOperationException {
        final var training = new GlobalLogicTraining("Math");
        final var student = new Student("Jerry", "Ferdy");
        Assertions.assertFalse(training.removeStudent(student));
        final var grades = getInternalMap(training);
        Assertions.assertFalse(grades.containsKey(student));
    }

    @Test
    void testRateFirstSemester() throws ReflectiveOperationException {
        final var training = new GlobalLogicTraining("Math");
        final var student = new Student("Jerry", "Ferdy");
        final var grades = getInternalMap(training);
        grades.put(student, null);
        Assertions.assertTrue(training.rateFirstSemester(student, 5));
        final var grade = grades.get(student);
        Assertions.assertNotNull(grade);
        Assertions.assertEquals(5, grade.getFirstSemester());
    }

    @Test
    void testRateFirstSemesterIfStudentAbsent() throws ReflectiveOperationException {
        final var training = new GlobalLogicTraining("Math");
        final var student = new Student("Jerry", "Ferdy");
        Assertions.assertFalse(training.rateFirstSemester(student, 5));
        final var grades = getInternalMap(training);
        Assertions.assertFalse(grades.containsKey(student));
    }

    @Test
    void tesRateFirstSemesterWithWrongGrade() throws ReflectiveOperationException {
        final var training = new GlobalLogicTraining("Math");
        final var student1 = new Student("Jerry", "Ferdy");
        final var student2 = new Student("Amanda", "Perry");
        final var grades = getInternalMap(training);
        grades.put(student1, null);
        grades.put(student2, null);

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> training.rateFirstSemester(student1, -1)
        );
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> training.rateFirstSemester(student2, 11)
        );
        Assertions.assertNull(grades.get(student1));
        Assertions.assertNull(grades.get(student2));
    }

    @Test
    void testRateSecondSemester() throws ReflectiveOperationException {
        final var training = new GlobalLogicTraining("Math");
        final var student = new Student("Jerry", "Ferdy");
        final var grades = getInternalMap(training);
        grades.put(student, null);
        Assertions.assertTrue(training.rateSecondSemester(student, 5));
        final var grade = grades.get(student);
        Assertions.assertNotNull(grade);
        Assertions.assertEquals(5, grade.getSecondSemester());
    }

    @Test
    void testRateSecondSemesterIfStudentAbsent() throws ReflectiveOperationException {
        final var training = new GlobalLogicTraining("Math");
        final var student = new Student("Jerry", "Ferdy");
        Assertions.assertFalse(training.rateSecondSemester(student, 5));
        final var grades = getInternalMap(training);
        Assertions.assertFalse(grades.containsKey(student));
    }

    @Test
    void tesRateSecondSemesterWithWrongGrade() throws ReflectiveOperationException {
        final var training = new GlobalLogicTraining("Math");
        final var student1 = new Student("Jerry", "Ferdy");
        final var student2 = new Student("Amanda", "Perry");
        final var grades = getInternalMap(training);
        grades.put(student1, null);
        grades.put(student2, null);
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> training.rateSecondSemester(student1, -1)
        );
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> training.rateSecondSemester(student2, 11)
        );
        Assertions.assertNull(grades.get(student1));
        Assertions.assertNull(grades.get(student2));
    }

    @Test
    void testIsPresentWhenExists() throws ReflectiveOperationException {
        final var training = new GlobalLogicTraining("Math");
        final var student = new Student("Jerry", "Ferdy");
        final var grades = getInternalMap(training);
        grades.put(student, null);
        Assertions.assertTrue(training.isPresent(student));
    }

    @Test
    void testIsPresentWhenAbsent() {
        final var training = new GlobalLogicTraining("Math");
        final var student = new Student("Jerry", "Ferdy");
        Assertions.assertFalse(training.isPresent(student));
    }

    @Test
    void testGetStudentGradeIfExists() throws ReflectiveOperationException {
        final var training = new GlobalLogicTraining("Math");
        final var student = new Student("Jerry", "Ferdy");
        final var grades = getInternalMap(training);
        final var existingGrade = new Grade();
        existingGrade.setFirstSemester(2);
        existingGrade.setSecondSemester(9);
        grades.put(student, existingGrade);

        final var grade = training.getStudentGrade(student);
        Assertions.assertTrue(grade.isPresent());
        Assertions.assertEquals(2, grade.get().getFirstSemester());
        Assertions.assertEquals(9, grade.get().getSecondSemester());
    }

    @Test
    void testGetStudentGradeIfNoGrade() throws ReflectiveOperationException {
        final var training = new GlobalLogicTraining("Math");
        final var student = new Student("Jerry", "Ferdy");
        final var grades = getInternalMap(training);
        grades.put(student, null);
        final var grade = training.getStudentGrade(student);
        Assertions.assertTrue(grade.isEmpty());
    }

    @Test
    void testGetStudentGradeIfZero() {
        final var training = new GlobalLogicTraining("Math");
        final var student = new Student("Jerry", "Ferdy");
        training.addStudent(student);
        training.rateFirstSemester(student, 0);
        training.rateSecondSemester(student, 0);
        final var grade = training.getStudentGrade(student);
        Assertions.assertTrue(grade.isPresent());
        Assertions.assertEquals(0, grade.get().getFirstSemester());
        Assertions.assertEquals(0, grade.get().getSecondSemester());
    }

    @Test
    void testModifyStudentUsingSet() {
        final var training = new GlobalLogicTraining("Math");
        final var student = new Student("Jerry", "Ferdy");
        final var studentClass = Student.class;
        try {
            final var grades = getInternalMap(training);
            final var setFirstName = studentClass.getDeclaredMethod("setFirstName", String.class);
            final var setLastName = studentClass.getDeclaredMethod("setLastName", String.class);
            grades.put(student, null);
            setFirstName.invoke(student, "Amanda");
            Assertions.assertTrue(grades.containsKey(student));
            setLastName.invoke(student, "Perry");
            Assertions.assertTrue(grades.containsKey(student));
        } catch (ReflectiveOperationException e) {
            // NOP
        }
    }

    @Test
    void testModifyStudentUsingField() {
        final var training = new GlobalLogicTraining("Math");
        final var student = new Student("Jerry", "Ferdy");
        final var studentClass = Student.class;
        try {
            final var grades = getInternalMap(training);
            final var firstName = studentClass.getDeclaredField("firstName");
            final var lastName = studentClass.getDeclaredField("lastName");
            grades.put(student, null);
            firstName.set(student, "Amanda");
            Assertions.assertTrue(grades.containsKey(student));
            lastName.set(student, "Perry");
            Assertions.assertTrue(grades.containsKey(student));
        } catch (ReflectiveOperationException e) {
            // NOP
        }
    }

    @SuppressWarnings("unchecked")
    private HashMap<Student, Grade> getInternalMap(GlobalLogicTraining training)
            throws ReflectiveOperationException {
        final var gradesField = TRAINING_CLASS.getDeclaredField(GRADES_FIELD);
        gradesField.setAccessible(true);
        final var gradesMap = gradesField.get(training);
        return (HashMap<Student, Grade>) gradesMap;
    }

}