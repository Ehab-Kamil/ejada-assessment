package com.soulco.assessment.manager;

import com.soulco.assessment.dto.OrderDTO;
import com.soulco.assessment.service.OrderService;
import com.soulco.assessment.transformers.OrderTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <p>
 * Title: OrderManager.java
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
 * @date 27/09/2025
 */
@Component
public class OrderManagerImpl implements OrderManager {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderTransformer orderTransformer;

    @Override
    public void create(OrderDTO dto) {
        this.orderService.save(this.orderTransformer.fromDTOtoEntity(dto));
    }

    @Override
    public void update(OrderDTO dto) {
        this.orderService.update(this.orderTransformer.fromDTOtoEntity(dto));
    }
}
