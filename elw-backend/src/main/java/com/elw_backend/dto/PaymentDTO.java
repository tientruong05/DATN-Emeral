package com.elw_backend.dto;

import lombok.Data;

import java.util.List;

import com.elw_backend.entity.Cart;

@Data
public class PaymentDTO {
    private Integer userId;
    private List<Cart> cartItems;
    private Double totalPrice;
    private PaymentInfo paymentInfo;

    @Data
    public static class PaymentInfo {
        private String fullName;
        private String email;
        private String cardNumber;
    }
}