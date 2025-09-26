package com.ejada.assessment.controller;

import com.ejada.assessment.dto.OrderDTO;
import jakarta.validation.Valid;
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

    @Override
    @PostMapping
    public void create(@Valid @RequestBody OrderDTO dto) {

    }

    @Override
    public void update(OrderDTO dto) {

    }

    @Override
    public void delete(OrderDTO dto) {

    }

    @Override
    public OrderDTO read() {
        return null;
    }
}
