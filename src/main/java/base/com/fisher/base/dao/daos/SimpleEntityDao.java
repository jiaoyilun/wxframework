package com.fisher.base.dao.daos;

import com.fisher.base.dao.interfaces.ISimpleEntityDao;
import com.fisher.base.model.models.SimpleEntity;

public abstract class SimpleEntityDao<PKType extends Number, EntityType extends SimpleEntity<PKType>> 
	extends EntityDao<PKType, EntityType> implements ISimpleEntityDao<PKType, EntityType> {

}
