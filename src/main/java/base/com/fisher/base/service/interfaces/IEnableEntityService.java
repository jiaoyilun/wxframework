package com.fisher.base.service.interfaces;

import java.util.List;
import java.util.Map;

import com.fisher.base.dao.interfaces.IEnableEntityDao;
import com.fisher.base.model.models.EnableEntity;
import com.fisher.common.exception.EntityOperateException;
import com.fisher.common.exception.ValidatException;

public interface IEnableEntityService<PKType extends Number, EntityType extends EnableEntity<PKType>, IDaoType extends IEnableEntityDao<PKType, EntityType>> extends ISimpleEntityService<PKType, EntityType, IDaoType> {
	
	public List<EntityType> listEnable();
	public List<EntityType> listDisable();
	public void enable(EntityType model) throws EntityOperateException, ValidatException;
	public void disable(EntityType model) throws EntityOperateException, ValidatException;
	public Map<PKType, String> getEnableSelectSource();
	
}
