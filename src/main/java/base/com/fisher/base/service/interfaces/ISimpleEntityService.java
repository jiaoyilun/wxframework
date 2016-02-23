package com.fisher.base.service.interfaces;

import java.util.Map;

import com.fisher.base.dao.interfaces.ISimpleEntityDao;
import com.fisher.base.model.models.SimpleEntity;

public interface ISimpleEntityService<PKType extends Number, EntityType extends SimpleEntity<PKType>, IDaoType extends ISimpleEntityDao<PKType, EntityType>> extends IEntityService<PKType, EntityType, IDaoType> {
    public Map<PKType, String> getSelectSource();
}
