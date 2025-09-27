package com.soulco.assessment.service;

import com.soulco.assessment.model.AbstractEntity;

/**
 * <p>
 * Title: AbstractCrudService.java
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
public interface AbstractCrudService<E extends AbstractEntity> {

    void save(E entity);

    void update(E entity);
}
