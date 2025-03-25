package com.ejada.assessment.transformer;

import com.ejada.assessment.dto.AbstractDTO;
import com.ejada.assessment.model.AbstractEntity;

import java.util.List;

/**
 * <p>
 * Title: AbstractTransformer.java
 * </p>
 *
 * <p>
 * Description:
 * </p>
 *
 * <p>
 * Copyright: Copyright(c) Ehab Kamil, 2025
 * </p>
 *
 * @author <a href="mailto:ehabkamil2@gmail.com">Ehab Attia</a>
 * @version 1.0
 */
public interface AbstractTransformer<E extends AbstractEntity, T extends AbstractDTO> {

	public T fromEntityToDTO(E entity);

	public List<T> fromEntityToDTO(List<E> entity);

	public E fromDtoToEntity(T dto);

	public List<E> fromDtoToEntity(List<T> dto);

}
