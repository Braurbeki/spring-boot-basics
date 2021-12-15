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
public class Grade {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long grade_id;
    @Column
    private String grade_name;
}
