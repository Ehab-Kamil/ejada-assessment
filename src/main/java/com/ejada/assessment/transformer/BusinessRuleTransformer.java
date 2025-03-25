package com.ejada.assessment.transformer;

import com.ejada.assessment.dto.BusinessruleDTO;
import com.ejada.assessment.model.BusinessRule;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 * Title: TaskTransformer.java
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
 */
@Component
public class BusinessRuleTransformer implements AbstractTransformer<BusinessRule, BusinessruleDTO> {

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public BusinessruleDTO fromEntityToDTO(BusinessRule entity) {
        return modelMapper.map(entity, BusinessruleDTO.class);
    }

    @Override
    public List<BusinessruleDTO> fromEntityToDTO(List<BusinessRule> entities) {
        return entities.stream().map(this::fromEntityToDTO).toList();
    }

    @Override
    public BusinessRule fromDtoToEntity(BusinessruleDTO dto) {
        return modelMapper.map(dto, BusinessRule.class);
    }

    @Override
    public List<BusinessRule> fromDtoToEntity(List<BusinessruleDTO> dtos) {
        return dtos.stream().map(this::fromDtoToEntity).toList();
    }
}
