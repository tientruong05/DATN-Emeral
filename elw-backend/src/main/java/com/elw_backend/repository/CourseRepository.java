package com.elw_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.elw_backend.entity.Course;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Integer> {
    List<Course> findByTenKhoaHocContainingIgnoreCase(String tenKhoaHoc);

    @Query("SELECT c FROM Course c JOIN DiscountDetails dd ON c.idKhoaHoc = dd.course.idKhoaHoc WHERE dd.status = true")
    List<Course> findDiscountedCourses();

    @Query("SELECT c FROM Course c JOIN PaymentHistory ph ON c.idKhoaHoc = ph.course.idKhoaHoc GROUP BY c ORDER BY COUNT(ph) DESC")
    List<Course> findPopularCourses();
}