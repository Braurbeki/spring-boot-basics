package com.spring.app.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.spring.app.interfaces.ILogger;
import com.spring.app.model.Grade;
import com.spring.app.model.Lesson;
import com.spring.app.model.Mark;
import com.spring.app.model.Student;
import com.spring.app.service.GradeService;
import com.spring.app.service.LessonService;
import com.spring.app.service.ProxyLogger;
import com.spring.app.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;

@RestController
public final class MainController {

    final GradeService gradeService;
    final StudentService studentService;
    final LessonService lessonService;

    final ILogger logger;

    @Autowired
    public MainController(GradeService gradeService,
                          StudentService studentService,
                          LessonService lessonService) {
        this.gradeService = gradeService;
        this.studentService = studentService;
        this.lessonService = lessonService;
        logger = new ProxyLogger();
        logger.log(Level.INFO, "Successfully initialized Spring application", this.getClass().getName());
    }

    @GetMapping("/grades")
    public ResponseEntity<List<Grade>> getAllGrades() {
        logger.log(Level.INFO, "Received GET request for list of cars", this.getClass().getName());
        return new ResponseEntity<>(gradeService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/grades/{grade_id}")
    public ResponseEntity<Grade> getGradeById(@PathVariable Long grade_id)
    {
        return new ResponseEntity<>(gradeService.get_by_id(grade_id), HttpStatus.OK);
    }

    @PostMapping("/grades")
    public Long saveGrade(@RequestBody Grade grade)
    {
        gradeService.insert(grade);
        return grade.getGrade_id();
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents() {
        logger.log(Level.INFO, "Received GET request for list of students", this.getClass().getName());
        return new ResponseEntity<>(studentService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/students/{student_id}")
    public ResponseEntity<Student> get_by_id(@PathVariable Long student_id) {
        return new ResponseEntity<>(studentService.get_by_id(student_id), HttpStatus.OK);
    }

    @PostMapping("/students")
    public ResponseEntity<Long> saveStudent(@RequestBody Student student) {
        studentService.insert(student);
        return new ResponseEntity<>(student.getStudent_id(), HttpStatus.OK);
    }
    @DeleteMapping("/students/{student_id}")
    public void removeStudent(@PathVariable Long id)
    {
        studentService.remove(id);
    }

    @GetMapping("/marks/{student_id}")
    public ResponseEntity<String> getStudentMarks(@PathVariable Long student_id) throws JsonProcessingException {
        return new ResponseEntity<>(studentService.getStudentMarks(student_id), HttpStatus.OK);
    }

    @GetMapping("/students/grade/{grade_id}")
    public ResponseEntity<String> getGradeStudents(@PathVariable Long grade_id) throws JsonProcessingException {
        return new ResponseEntity<>(gradeService.getAllStudents(grade_id), HttpStatus.OK);
    }

    @GetMapping("/students/result/{student_id}")
    public ResponseEntity<String> getAverageResult(@PathVariable Long student_id) throws JsonProcessingException {
        return new ResponseEntity<>(studentService.getSummaryResult(student_id), HttpStatus.OK);
    }

    @PostMapping("/marks")
    public ResponseEntity<Long> saveMark(@RequestBody Mark mark)
    {
        lessonService.insertMark(mark);
        return new ResponseEntity<>(mark.getMark_id(), HttpStatus.OK);
    }

    @PostMapping("/lessons")
    public ResponseEntity<Long> saveLesson(@RequestBody Lesson lesson)
    {
        lessonService.insert(lesson);
        return new ResponseEntity<>(lesson.getLesson_id(), HttpStatus.OK);
    }

}