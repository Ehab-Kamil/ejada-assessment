package com.ejada.assessment.service;

import com.ejada.assessment.dto.BusinessruleDTO;

import java.util.List;

/**
 * <p>
 * Title: TaskService.java
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
public interface BusinessRuleService {

    public List<BusinessruleDTO> getAll();

    public List<BusinessruleDTO> getEnrichmentRulesOrderByPriority();

    public List<BusinessruleDTO> getRoutingRulesOrderByPriority();

    public BusinessruleDTO save(BusinessruleDTO businessruleDTO);

    public BusinessruleDTO update(Long id, BusinessruleDTO businessruleDTO);

    public boolean delete(Long taskId);

}
