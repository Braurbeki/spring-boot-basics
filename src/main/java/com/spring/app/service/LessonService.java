package com.spring.app.service;

import com.spring.app.interfaces.IService;
import com.spring.app.model.Dates;
import com.spring.app.model.Lesson;
import com.spring.app.model.Mark;
import com.spring.app.repository.DateRepository;
import com.spring.app.repository.LessonRepository;
import com.spring.app.repository.MarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class LessonService implements IService<Lesson> {

    LessonRepository repository;
    MarkRepository markRepository;
    DateRepository dateRepository;

    @Autowired
    public LessonService(LessonRepository lessonRepository, MarkRepository markRepository, DateRepository dateRepository) {
        this.repository = lessonRepository;
        this.markRepository = markRepository;
        this.dateRepository = dateRepository;
    }
    @Override
    public List<Lesson> getAll() {
        List<Lesson> lessons = new ArrayList<>();
        repository.findAll().forEach(lessons::add);
        return lessons;
    }

    @Override
    public Lesson get_by_id(long id) {
        return repository.findById(id).get();
    }

    @Override
    public void remove(long id) {
        repository.deleteById(id);
    }

    @Override
    public Lesson insert(Lesson lesson) {
        return repository.save(lesson);
    }

    public Mark insertMark(Mark mark)
    {
        final SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Dates date = new Dates();
        date.setLesson_date(mark.getDate());
        return markRepository.save(mark);
    }
}
