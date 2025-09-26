package com.ejada.assessment.transformers;

import com.ejada.assessment.dto.AbstractDTO;
import com.ejada.assessment.model.AbstractEntity;

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
public class OrderTransformer implements EntityToDTO, DtoToEntity {
    @Override
    public AbstractEntity fromDTOtoEntity(AbstractDTO dto) {
        return null;
    }

    @Override
    public List<AbstractEntity> fromDTOtoEntity(List<AbstractDTO> dto) {
        return List.of();
    }

    @Override
    public AbstractDTO fromEntityToDto(AbstractEntity entity) {
        return null;
    }

    @Override
    public List<AbstractDTO> fromEntityToDto(List<AbstractEntity> entity) {
        return List.of();
    }
}
