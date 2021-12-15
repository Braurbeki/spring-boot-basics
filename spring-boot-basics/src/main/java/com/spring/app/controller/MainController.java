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

    @GetMapping("/cars")
    public ResponseEntity<List<Grade>> getAllCars() {
        logger.log(Level.INFO, "Received GET request for list of cars", this.getClass().getName());
        return new ResponseEntity<>(gradeService.getAllCars(), HttpStatus.OK);
    }

    @GetMapping("/cars/{car_id}")
    public ResponseEntity<Grade> getCarById(@PathVariable Long car_id)
    {
        return new ResponseEntity<>(gradeService.getCarById(car_id).get(), HttpStatus.OK);
    }

    @PostMapping("/cars")
    public Long saveCar(@RequestBody Grade grade)
    {
        gradeService.insert(grade);
        return grade.getGrade_id();
    }
    @DeleteMapping("/cars/{car_id}")
    public void removeCar(@RequestBody Long id)
    {
        gradeService.deleteCar(id);
    }

//    @PutMapping("/cars")
//    public ResponseEntity<Grade> update(@RequestBody Grade grade)
//    {
//        gradeService.updateCar(grade);
//        return new ResponseEntity<>(grade, HttpStatus.OK);
//    }

}