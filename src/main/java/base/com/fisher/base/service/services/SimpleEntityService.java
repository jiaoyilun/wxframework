package com.fisher.base.service.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fisher.base.dao.interfaces.ISimpleEntityDao;
import com.fisher.base.model.models.SimpleEntity;
import com.fisher.base.service.interfaces.ISimpleEntityService;

public abstract class SimpleEntityService<PKType extends Number, EntityType extends SimpleEntity<PKType>, IDaoType extends ISimpleEntityDao<PKType, EntityType>> 
	extends EntityService<PKType, EntityType, IDaoType> implements ISimpleEntityService<PKType, EntityType, IDaoType> { 
	
	public SimpleEntityService(IDaoType dao){
		super(dao);
	}
	
	@Override
	public Map<PKType, String> getSelectSource(){
		Map<PKType,String> ret=new HashMap<PKType,String>();
		List<EntityType> entities=entityDao.listAll();
		for(EntityType entity : entities){
			ret.put(entity.getId(), entity.getName());
		}
		return ret;
	} 
}
