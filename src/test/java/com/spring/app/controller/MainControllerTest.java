package com.spring.app.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.app.model.Grade;
import com.spring.app.repository.GradeRepository;
import com.spring.app.service.GradeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc(addFilters = false)
class MainControllerTest {
    @Autowired
    ObjectMapper objectMapper;
    @Mock
    GradeRepository gradeRepository;
    @Mock
    GradeService gradeService;

//    @Test
//    public void testAddingCar() throws Exception {
//        gradeService = new GradeService(gradeRepository);
//        Grade expectedGrade = new Grade(1L, "Skoda", "Octavia");
//        Mockito.when(gradeService.getCarById(1L)).thenReturn(Optional.of(expectedGrade));
//        Assertions.assertNotNull(gradeService.getCarById(1L).get());
//        Assertions.assertEquals(expectedGrade.getBrand(), gradeService.getCarById(1L).get().getBrand());
//        Assertions.assertEquals(expectedGrade.getModel(), gradeService.getCarById(1L).get().getModel());
//    }
//
//    @Test
//    public void testRemovingCar() throws Exception
//    {
//        Long car_id = 1L;
//        Grade gradeToAdd = new Grade(car_id, "Skoda", "Octavia");
//        Mockito.when(gradeService.getCarById(car_id)).thenReturn(Optional.of(gradeToAdd));
//        Assertions.assertEquals(Optional.of(gradeToAdd), gradeService.getCarById(car_id));
//        Mockito.when(gradeService.getCarById(car_id)).thenReturn(Optional.empty());
//        Assertions.assertEquals(Optional.empty(), gradeService.getCarById(car_id));
//    }
//
//    @Test
//    public void testUpdatingCar() throws Exception
//    {
//        Long car_id = 1L;
//        Grade gradeToAdd = new Grade(car_id, "Skoda", "Octavia");
//        Grade gradeToUpdate = new Grade(car_id, "Lada", "Sidan");
//        Mockito.when(gradeService.getCarById(car_id)).thenReturn(Optional.of(gradeToAdd));
//        Assertions.assertEquals(Optional.of(gradeToAdd), gradeService.getCarById(car_id));
//        Mockito.when(gradeService.getCarById(car_id)).thenReturn(Optional.of(gradeToUpdate));
//        Assertions.assertEquals(gradeToUpdate, gradeService.getCarById(car_id).get());
//    }
}