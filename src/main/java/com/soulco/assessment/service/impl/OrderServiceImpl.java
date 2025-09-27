package com.soulco.assessment.service.impl;

import com.soulco.assessment.model.Order;
import com.soulco.assessment.dao.OrderRepository;
import com.soulco.assessment.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * Title: OrderServiceImpl.java
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
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void save(Order entity) {
        this.orderRepository.save(entity);
    }

    @Override
    public void update(Order entity) {
        this.orderRepository.save(entity);
    }
}
