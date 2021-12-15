package com.spring.app.repository;

import com.spring.app.model.Dates;
import org.springframework.data.repository.CrudRepository;

public interface DateRepository extends CrudRepository<Dates, Long> {
}
