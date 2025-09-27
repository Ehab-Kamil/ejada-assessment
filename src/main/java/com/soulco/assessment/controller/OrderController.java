package com.soulco.assessment.controller;

import com.soulco.assessment.dto.OrderDTO;
import com.soulco.assessment.manager.OrderManager;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * Title: OrderController.java
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright(c) Ehab Kamil, 2025
 * </p>
 *
 * @author <a href="mailto:ehabkamil2@gmail.com">Ehab Attia</a>
 * @version 1.0
 * @date 24/09/2025
 */
@RestController
@RequestMapping("/api/products")
public class OrderController implements AbstractController<OrderDTO> {

    @Autowired
    private OrderManager orderManager;

    @PostMapping
    public void create(@Valid @RequestBody OrderDTO dto) {
        this.orderManager.create(dto);
    }

    @Override
    public void update(OrderDTO dto) {
        this.orderManager.update(dto);
    }

    @Override
    public void delete(OrderDTO dto) {

    }

    @Override
    public OrderDTO read() {
        return null;
    }
}
