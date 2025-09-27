package com.soulco.assessment.transformers;

import com.soulco.assessment.dto.OrderDTO;
import com.soulco.assessment.model.Order;
import com.ejada.assessment.old.model.BusinessRule;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * <p>
 * Title: OrderTransformer.java
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
public class OrderTransformer implements EntityToDTO<Order, OrderDTO>, DtoToEntity<Order, OrderDTO> {

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public OrderDTO fromEntityToDto(Order entity) {
        return modelMapper.map(entity, OrderDTO.class);
    }

    @Override
    public List<OrderDTO> fromEntityToDto(List<Order> entity) {
        return entity.stream().map(this::fromEntityToDto).toList();
    }

    @Override
    public Order fromDTOtoEntity(OrderDTO dto) {
        return modelMapper.map(dto, Order.class);
    }

    @Override
    public List<Order> fromDTOtoEntity(List<OrderDTO> dto) {
        return dto.stream().map(this::fromDTOtoEntity).toList();
    }
}
