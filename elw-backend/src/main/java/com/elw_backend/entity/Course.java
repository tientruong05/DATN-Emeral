package com.elw_backend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Course")
@Data
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_khoa_hoc")
    private Integer idKhoaHoc;

    @Column(name = "ten_khoa_hoc", nullable = false)
    private String tenKhoaHoc;

    @Column(name = "mo_ta")
    private String moTa;

    @Column(name = "diem_dat", nullable = false)
    private Double diemDat;

    @ManyToOne
    @JoinColumn(name = "danh_muc_ID", nullable = false)
    private Category category;

    @Column(name = "gia_tien", nullable = false)
    private Double giaTien;

    @Column(name = "anh_dai_dien")
    private String anhDaiDien;

    @Column(name = "Status")
    private Integer status = 1;
}