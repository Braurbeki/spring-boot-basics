package com.spring.app.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.app.interfaces.IService;
import com.spring.app.model.Grade;
import com.spring.app.model.Student;
import com.spring.app.repository.GradeRepository;
import com.spring.app.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GradeService implements IService<Grade> {

    GradeRepository repository;
    StudentRepository studentRepository;
    ObjectMapper mapper;

    @Autowired
    public GradeService(GradeRepository gradeRepository, StudentRepository studentRepository, ObjectMapper mapper) {
        this.repository = gradeRepository;
        this.studentRepository = studentRepository;
        this.mapper = mapper;
    }

    @Override
    public List<Grade> getAll()
    {
        List<Grade> grades = new ArrayList<>();
        repository.findAll().forEach(grades::add);
        return grades;
    }

    @Override
    public Grade get_by_id(long id) {
        return repository.findById(id).get();
    }

    @Override
    public Grade insert(Grade grade) {
        return repository.save(grade);
    }

    @Override
    public void remove(long gradeId) {
        repository.deleteById(gradeId);
    }

    public String getAllStudents(long gradeId) throws JsonProcessingException {
        List<String> students = new ArrayList<>();
        for(Student student : studentRepository.findAll())
        {
            if(student.getGrade_id() == gradeId)
            {
                students.add(student.getName());
            }
        }
        return mapper.writeValueAsString(students);
    }
}
