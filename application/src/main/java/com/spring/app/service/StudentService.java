package com.spring.app.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.app.interfaces.IService;
import com.spring.app.model.Dates;
import com.spring.app.model.Lesson;
import com.spring.app.model.Mark;
import com.spring.app.model.Student;
import com.spring.app.repository.DateRepository;
import com.spring.app.repository.LessonRepository;
import com.spring.app.repository.MarkRepository;
import com.spring.app.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentService implements IService<Student> {

    final StudentRepository repository;
    final MarkRepository markRepository;
    final LessonRepository lessonRepository;
    final DateRepository dateRepository;
    final ObjectMapper mapper;

    @Autowired
    public StudentService(StudentRepository studentRepository,
                          ObjectMapper mapper,
                          MarkRepository markRepository,
                          LessonRepository lessonRepository,
                          DateRepository dateRepository) {
        this.repository = studentRepository;
        this.markRepository = markRepository;
        this.lessonRepository = lessonRepository;
        this.dateRepository = dateRepository;
        this.mapper = mapper;
    }

    @Override
    public List<Student> getAll() {
        List<Student> students = new ArrayList<>();
        repository.findAll().forEach(students::add);
        return students;
    }

    @Override
    public Student get_by_id(long id) {
        return repository.findById(id).get();
    }

    @Override
    public void remove(long id) {
        repository.deleteById(id);
    }

    @Override
    public Student insert(Student student) {
        return repository.save(student);
    }

    public String getStudentMarks(long id) throws JsonProcessingException {
        Map<String, Map<String, String>> marks = new HashMap<>();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        dateRepository.findAll().forEach((Dates date) -> {
            marks.put(formatter.format(date.getLesson_date()), new HashMap<>());
        });

        List<Lesson> lessons = new ArrayList<>();
        for(Lesson lesson : lessonRepository.findAll())
        {
            if(lesson.getGrade_id() == get_by_id(id).getGrade_id())
            {
                for(Map<String, String> map : marks.values())
                {
                    map.put(lesson.getName(), "0");
                }
                lessons.add(lesson);
            }
        }

        lessons.forEach((Lesson lesson) -> markRepository.findAll().forEach((Mark m) -> {
            String date = formatter.format(m.getDate());
            if(marks.containsKey(date) && m.getLesson_id() == lesson.getLesson_id() && m.getStudent_id() == id)
            {
                marks.get(date).put(lesson.getName(), m.isAttended() ? String.valueOf(m.getVal()) : "H");
            }
        }));
        return mapper.writeValueAsString(marks);
    }

    public String getSummaryResult(long id) throws JsonProcessingException {
        Map<String, String> result = new HashMap<>();
        double score = 0;
        int counter = 0;
        int absent_counter = 0;
        for(Mark mark : markRepository.findAll() )
        {
            if(mark.getStudent_id() == id) {
                score += mark.getVal();
                counter++;
                if(!mark.isAttended())
                {
                    absent_counter++;
                }
            }
        }
        result.put("Average result", String.valueOf(score/counter));
        result.put("Absent", String.valueOf(absent_counter));
        return mapper.writeValueAsString(result);
    }
}
