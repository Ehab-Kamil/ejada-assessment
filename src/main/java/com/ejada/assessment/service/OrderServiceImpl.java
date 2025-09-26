package com.ejada.assessment.service;

import com.ejada.assessment.dto.OrderDTO;
import com.ejada.assessment.model.AbstractEntity;
import com.ejada.assessment.model.Order;
import com.ejada.assessment.repository.OrderRepository;
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
