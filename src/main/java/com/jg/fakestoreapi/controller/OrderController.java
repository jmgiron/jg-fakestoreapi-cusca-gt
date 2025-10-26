
package com.jg.fakestoreapi.controller;

import com.jg.fakestoreapi.entity.OrderDetail;
import com.jg.fakestoreapi.entity.OrderEntity;
import com.jg.fakestoreapi.repository.ClientRepository;
import com.jg.fakestoreapi.repository.OrderRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderRepository orderRepo;
    private final ClientRepository clientRepo;

    public OrderController(OrderRepository orderRepo, ClientRepository clientRepo) {
        this.orderRepo = orderRepo;
        this.clientRepo = clientRepo;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Map<String, Object> payload) {
        // expected payload: { clientId: number, items: [ { productId, title, unitPrice, quantity } ] }
        Number clientIdN = (Number) payload.get("clientId");
        if (clientIdN == null) return ResponseEntity.badRequest().body(Map.of("error","clientId is required"));
        Long clientId = clientIdN.longValue();
        if (!clientRepo.existsById(clientId)) return ResponseEntity.badRequest().body(Map.of("error","client not found"));

        OrderEntity order = new OrderEntity();
        order.setClientId(clientId);

        List<Map<String, Object>> items = (List<Map<String, Object>>) payload.get("items");
        if (items != null) {
            for (Map<String,Object> it : items) {
                OrderDetail d = new OrderDetail();
                Number pid = (Number) it.get("productId"); if (pid!=null) d.setProductId(pid.longValue());
                d.setTitle((String) it.get("title"));
                Number up = (Number) it.get("unitPrice"); if (up!=null) d.setUnitPrice(up.doubleValue());
                Number q = (Number) it.get("quantity"); if (q!=null) d.setQuantity(q.intValue());
                double subtotal = (d.getUnitPrice()!=null?d.getUnitPrice():0.0) * (d.getQuantity()!=null?d.getQuantity():0);
                d.setSubtotal(subtotal);
                order.addDetail(d);
            }
        }
        order.recalcTotal();
        OrderEntity saved = orderRepo.save(order);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderEntity> get(@PathVariable Long id) {
        return orderRepo.findById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<OrderEntity> list(@RequestParam(required = false) Long clientId) {
        if (clientId != null) return orderRepo.findByClientId(clientId);
        return orderRepo.findAll();
    }
}
