package com.soulco.assessment.transformers;

import com.soulco.assessment.dto.AbstractDTO;
import com.soulco.assessment.model.AbstractEntity;

import java.util.List;

/**
 * <p>
 * Title: EntityToDTO.java
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
public interface EntityToDTO<E extends AbstractEntity, T extends AbstractDTO> {

    public T fromEntityToDto(E entity);

    public List<T> fromEntityToDto(List<E> entity);

}
