package com.spring.app.service;

import com.spring.app.model.Grade;
import com.spring.app.repository.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GradeService {

    GradeRepository repository;

    @Autowired
    public GradeService(GradeRepository gradeRepository) {
        this.repository = gradeRepository;

    }

    public List<Grade> getAllCars()
    {
        List<Grade> grades = new ArrayList<>();
        repository.findAll().forEach(grades::add);
        return grades;
    }

    public Optional<Grade> getCarById(Long id) {
        return repository.findById(id);
    }


    public Grade insert(Grade grade) {
        return repository.save(grade);
    }

//    public Grade updateCar(Grade grade) {
//        Optional<Grade> carFromDb = repository.findById(grade.getCar_id());
//        if(!carFromDb.isPresent())
//        {
//            repository.save(grade);
//            return grade;
//        }
//        carFromDb.get().setModel(grade.getModel());
//        carFromDb.get().setBrand(grade.getBrand());
//        return carFromDb.get();
//    }
    @Transactional
    public void deleteCar(Long carId) {
        repository.deleteById(carId);
    }
}
