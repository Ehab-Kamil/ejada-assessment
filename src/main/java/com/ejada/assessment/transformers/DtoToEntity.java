package com.ejada.assessment.transformers;

import com.ejada.assessment.dto.AbstractDTO;
import com.ejada.assessment.model.AbstractEntity;

import java.util.List;

/**
 * <p>
 * Title: DtoToEntity.java
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
public interface DtoToEntity {

    public AbstractEntity fromDTOtoEntity(AbstractDTO dto);

    public List<AbstractEntity> fromDTOtoEntity(List<AbstractDTO> dto);

}
