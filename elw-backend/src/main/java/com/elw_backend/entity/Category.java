package com.elw_backend.entity;

import jakarta.persistence.*;
import lombok.Data;
@Entity
@Table(name = "Category")
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_danh_muc")
    private Integer idDanhMuc;

    @Column(name = "ten_danh_muc", nullable = false)
    private String tenDanhMuc;

    @Column(name = "Description")
    private String description;
}