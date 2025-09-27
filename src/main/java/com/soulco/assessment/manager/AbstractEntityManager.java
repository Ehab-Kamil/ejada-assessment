package com.soulco.assessment.manager;

import com.soulco.assessment.dto.AbstractDTO;

/**
 * <p>
 * Title: OrderManager.java
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
 * @date 27/09/2025
 */
public interface AbstractEntityManager<D extends AbstractDTO> {

    public void create(D dto);

    public void update(D dto);
}
