package com.elw_backend.repository;


import com.elw_backend.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Integer> {
    List<Cart> findByUserIdNguoiDung(Integer userId);

    boolean existsByUserIdNguoiDungAndCourseIdKhoaHoc(Integer userId, Integer courseId);

    void deleteByUserIdNguoiDung(Integer userId);
}
