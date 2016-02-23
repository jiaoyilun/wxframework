package com.fisher.base.dao.interfaces;

import java.util.List;

import com.fisher.base.model.models.EnableEntity;
import com.fisher.common.exception.EntityOperateException;
import com.fisher.common.exception.ValidatException;

public interface IEnableEntityDao<PKType extends Number, EntityType extends EnableEntity<PKType>> extends ISimpleEntityDao<PKType, EntityType> {
	
	public List<EntityType> listEnable();
	public List<EntityType> listDisable();
	public void enable(EntityType entity) throws EntityOperateException, ValidatException;
	public void disable(EntityType entity) throws EntityOperateException, ValidatException;
	
}
