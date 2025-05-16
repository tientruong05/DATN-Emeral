package com.elw_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.elw_backend.entity.DiscountDetails;

import java.util.Optional;

public interface DiscountDetailsRepository extends JpaRepository<DiscountDetails, Integer> {
    @Query("SELECT dd FROM DiscountDetails dd WHERE dd.course.idKhoaHoc = :courseId AND dd.status = true")
    Optional<DiscountDetails> findByCourseIdKhoaHoc(Integer courseId);
}