package edu.hrishi.order.controller;

import edu.hrishi.order.dto.OrderDto;
import edu.hrishi.order.dto.OrderDtoFE;
import edu.hrishi.order.entity.Order;
import edu.hrishi.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
@CrossOrigin
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderDto> save(@RequestBody OrderDtoFE orderDtoFE) {
        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.save(orderDtoFE));
    }

}
