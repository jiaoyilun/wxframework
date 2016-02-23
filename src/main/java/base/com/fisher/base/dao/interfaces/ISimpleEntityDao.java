package com.fisher.base.dao.interfaces;

import com.fisher.base.model.models.SimpleEntity;

public interface ISimpleEntityDao<PKType extends Number, EntityType extends SimpleEntity<PKType>> extends IEntityDao<PKType, EntityType> {
	
}
