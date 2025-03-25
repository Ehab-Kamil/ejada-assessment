package com.ejada.assessment.configuration;

/**
 * <p>
 * Title: ModelMapperConfig.java
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

import com.ejada.assessment.dto.BusinessruleDTO;
import com.ejada.assessment.model.BusinessRule;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.typeMap(BusinessRule.class, BusinessruleDTO.class);

        return modelMapper;
    }
}

