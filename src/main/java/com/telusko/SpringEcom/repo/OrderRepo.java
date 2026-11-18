/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.telusko.SpringEcom.repo;

import com.telusko.SpringEcom.model.Order;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author yadav
 */
@Repository
public interface OrderRepo extends CrudRepository<Order, Long> {
    Optional<Order> findByOrderId(String orderId);
}
