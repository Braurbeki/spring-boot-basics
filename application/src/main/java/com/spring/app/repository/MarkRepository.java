package com.spring.app.repository;

import com.spring.app.model.Mark;
import com.spring.app.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface MarkRepository extends CrudRepository<Mark, Long> {
}
