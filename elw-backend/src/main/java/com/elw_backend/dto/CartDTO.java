package com.elw_backend.dto;

import lombok.Data;

@Data
public class CartDTO {
    private Integer userId;
    private Integer courseId;
    private Float price;
}