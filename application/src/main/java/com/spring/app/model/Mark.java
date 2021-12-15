package com.spring.app.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Mark {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mark_id;
    @Column
    private int val;
    @Column
    private int student_id;
    @Column
    private int lesson_id;
    @Column
    private boolean attended;
    @Column
    private Date date;
}
