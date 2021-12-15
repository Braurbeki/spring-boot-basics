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
public class Result {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long result_id;
    @Column
    private int skipped_lessons;
    @Column
    private int student_id;
    @Column
    private int average_mark;
}
