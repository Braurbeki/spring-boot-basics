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
public class Dates {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long date_id;
    @Column
    private Date lesson_date;
}
