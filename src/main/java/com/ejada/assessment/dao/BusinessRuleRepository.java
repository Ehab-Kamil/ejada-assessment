package com.ejada.assessment.dao;

/**
 * <p>
 * Title: TaskRepository.java
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

import com.ejada.assessment.model.BusinessRule;
import com.ejada.assessment.model.BusinessRuleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusinessRuleRepository extends JpaRepository<BusinessRule, Long> {

    public List<BusinessRule> findAllByRuleTypeOrderByPriorityAsc(BusinessRuleType type);

}
