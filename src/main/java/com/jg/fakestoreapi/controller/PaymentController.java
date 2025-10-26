
package com.jg.fakestoreapi.controller;

import com.jg.fakestoreapi.entity.OrderEntity;
import com.jg.fakestoreapi.repository.OrderRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final OrderRepository orderRepo;

    public PaymentController(OrderRepository orderRepo) {
        this.orderRepo = orderRepo;
    }

    @PostMapping
    public ResponseEntity<?> pay(@RequestBody Map<String, Object> payload) {
        Number orderIdN = (Number) payload.get("orderId"); if (orderIdN==null) return ResponseEntity.badRequest().body(Map.of("error","orderId required"));
        Long orderId = orderIdN.longValue();
        Optional<OrderEntity> opt = orderRepo.findById(orderId);
        if (opt.isEmpty()) return ResponseEntity.badRequest().body(Map.of("error","order not found"));
        OrderEntity order = opt.get();
        // simulate payment success if amount equals order.total or if amount > 0
        Number amountN = (Number) payload.get("amount"); double amount = amountN!=null?amountN.doubleValue():0.0;
        boolean success = amount >= order.getTotal();
        if (success) {
            order.setStatus("PAID");
            orderRepo.save(order);
            return ResponseEntity.ok(Map.of(
                    "paymentId", UUID.randomUUID().toString(),
                    "status", "SUCCESS",
                    "timestamp", LocalDateTime.now().toString()
            ));
        } else {
            order.setStatus("PAYMENT_FAILED");
            orderRepo.save(order);
            return ResponseEntity.status(402).body(Map.of(
                    "paymentId", UUID.randomUUID().toString(),
                    "status", "FAILED",
                    "timestamp", LocalDateTime.now().toString()
            ));
        }
    }
}
