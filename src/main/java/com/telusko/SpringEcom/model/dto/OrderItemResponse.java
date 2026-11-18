/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.telusko.SpringEcom.model.dto;

import java.math.BigDecimal;

/**
 *
 * @author yadav
 */
public record OrderItemResponse(
        String productName,
        int quantity,
        BigDecimal totalPrice
) {}