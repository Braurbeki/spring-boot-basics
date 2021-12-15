package com.spring.app.controller;

import com.spring.app.interfaces.ILogger;
import com.spring.app.model.Grade;
import com.spring.app.service.GradeService;
import com.spring.app.service.ProxyLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;

@RestController
public final class MainController {

    final GradeService gradeService;

    final ILogger logger;

    @Autowired
    public MainController(GradeService gradeService)
    {
        this.gradeService = gradeService;
        logger = new ProxyLogger();
        logger.log(Level.INFO, "Successfully initialized Spring application", this.getClass().getName());
    }

    @GetMapping("/grades")
    public ResponseEntity<List<Grade>> getAllGrades() {
        logger.log(Level.INFO, "Received GET request for list of cars", this.getClass().getName());
        return new ResponseEntity<>(gradeService.getAllGrades(), HttpStatus.OK);
    }

    @GetMapping("/grades/{grade_id}")
    public ResponseEntity<Grade> getGradeById(@PathVariable Long grade_id)
    {
        return new ResponseEntity<>(gradeService.getCarById(grade_id).get(), HttpStatus.OK);
    }

    @PostMapping("/grades")
    public Long saveGrade(@RequestBody Grade grade)
    {
        gradeService.insert(grade);
        return grade.getGrade_id();
    }
    @DeleteMapping("/grades/{grade_id}")
    public void removeGrade(@RequestBody Long id)
    {
        gradeService.deleteGrade(id);
    }



}