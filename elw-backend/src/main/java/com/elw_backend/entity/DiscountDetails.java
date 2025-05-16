package com.elw_backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "discount_details")
public class DiscountDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "discount_id", nullable = false)
    private int discountId;

    @Column(name = "categories_id")
    private Integer categoriesId;

    @Column(name = "course_id")
    private Integer courseId;

    @Column(name = "status")
    private boolean status = true;

    // Getters, setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getDiscountId() { return discountId; }
    public void setDiscountId(int discountId) { this.discountId = discountId; }
    public Integer getCategoriesId() { return categoriesId; }
    public void setCategoriesId(Integer categoriesId) { this.categoriesId = categoriesId; }
    public Integer getCourseId() { return courseId; }
    public void setCourseId(Integer courseId) { this.courseId = courseId; }
    public boolean isStatus() { return status; }
    public void setStatus(boolean status) { this.status = status; }
}