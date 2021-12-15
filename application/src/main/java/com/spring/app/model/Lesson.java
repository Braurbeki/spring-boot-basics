package com.spring.app.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Lesson {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lesson_id;
    @Column
    private String name;
    @Column
    private int grade_id;
}
