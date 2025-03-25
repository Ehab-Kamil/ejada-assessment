package com.ejada.assessment.service.impl;

import com.ejada.assessment.dao.BusinessRuleRepository;
import com.ejada.assessment.dto.BusinessruleDTO;
import com.ejada.assessment.model.BusinessRuleType;
import com.ejada.assessment.service.BusinessRuleService;
import com.ejada.assessment.transformer.BusinessRuleTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 * Title: TaskServiceImpl.java
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
@Service
public class BusinessRuleServiceImpl implements BusinessRuleService {

    @Autowired
    private BusinessRuleRepository businessRuleRepository;

    @Autowired
    private BusinessRuleTransformer businessRuleTransformer;

    @Override
    public List<BusinessruleDTO> getAll() {
        return businessRuleTransformer.fromEntityToDTO(businessRuleRepository.findAll());
    }

    @Override
    public List<BusinessruleDTO> getEnrichmentRulesOrderByPriority() {
        return businessRuleTransformer.fromEntityToDTO(businessRuleRepository.findAllByRuleTypeOrderByPriorityAsc(BusinessRuleType.ENRICHMENT));
    }

    @Override
    public List<BusinessruleDTO> getRoutingRulesOrderByPriority() {
        return businessRuleTransformer.fromEntityToDTO(businessRuleRepository.findAllByRuleTypeOrderByPriorityAsc(BusinessRuleType.ROUTING));
    }

    public BusinessruleDTO save(BusinessruleDTO businessruleDTO) {
        return businessRuleTransformer.fromEntityToDTO(businessRuleRepository.save(businessRuleTransformer.fromDtoToEntity(businessruleDTO)));
    }

    @Override
    public BusinessruleDTO update(Long id, BusinessruleDTO businessruleDTO) {
        if (businessRuleRepository.existsById(id)) {
            businessruleDTO.setId(id);
            return businessRuleTransformer.fromEntityToDTO(businessRuleRepository.save(businessRuleTransformer.fromDtoToEntity(businessruleDTO)));
        }
        return null;
    }

    public boolean delete(Long taskId) {
        if (businessRuleRepository.existsById(taskId)) {
            businessRuleRepository.deleteById(taskId);
            return true;
        }
        return false;

    }
}
