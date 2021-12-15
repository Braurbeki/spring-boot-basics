package com.spring.app.repository;

import com.spring.app.model.Grade;
import com.spring.app.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {
}
