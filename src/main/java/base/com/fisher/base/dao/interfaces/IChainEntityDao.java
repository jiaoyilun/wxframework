package com.fisher.base.dao.interfaces;

import com.fisher.base.model.models.ChainEntity;

public interface IChainEntityDao<PKType extends Number, EntityType extends ChainEntity<PKType, EntityType>> extends IEnableEntityDao<PKType, EntityType> {
	
}
