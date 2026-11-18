/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.telusko.SpringEcom.model.dto;

/**
 *
 * @author yadav
 */
public record OrderItemRequest(
        int productId,
        int quantity
) {}