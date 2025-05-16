package com.elw_backend.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "Enrollments")
@Data
public class Enrollments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    @Column(name = "enrollment_date", nullable = false)
    private Date enrollmentDate = new Date();

    @Column(name = "finish_date")
    private Date finishDate;

    @Column(name = "diem")
    private Float diem;

    @Column(name = "user_id", insertable = false, updatable = false)
    private Integer userId;

    @Column(name = "course_id", insertable = false, updatable = false)
    private Integer courseId;
}