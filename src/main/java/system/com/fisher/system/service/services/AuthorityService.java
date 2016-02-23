package com.fisher.system.service.services;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.fisher.base.service.services.ChainEntityService;
import com.fisher.common.exception.EntityOperateException;
import com.fisher.common.exception.ValidatException;
import com.fisher.common.utilities.PageList;
import com.fisher.common.utilities.PageListUtil;
import com.fisher.system.dao.interfaces.IAuthorityDao;
import com.fisher.system.model.models.Authority;
import com.fisher.system.service.interfaces.IAuthorityService;
import com.fisher.system.service.models.AuthoritySearch;

@Service("AuthorityService")
public class AuthorityService extends ChainEntityService<Integer, Authority, IAuthorityDao> implements IAuthorityService {
	
	@Autowired
	public AuthorityService(@Qualifier("AuthorityDao")IAuthorityDao authorityDao){
		super(authorityDao);
	}
	
	@Override
	public void update(Authority model) throws ValidatException, EntityOperateException{
		Authority dbModel=super.get(model.getId());
		dbModel.setName(model.getName());
		dbModel.setPosition(model.getPosition());
		dbModel.setTheValue(model.getTheValue());
		dbModel.setUrl(model.getUrl());
		dbModel.setMatchUrl(model.getMatchUrl());
		dbModel.setItemIcon(model.getItemIcon());
		dbModel.setParent(model.getParent());
		super.update(dbModel);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public PageList<Authority> listPage(AuthoritySearch search, int pageNo, int pageSize) {		
		Criteria countCriteria = entityDao.getCriteria();
		Criteria listCriteria = entityDao.getCriteria();
		
        if(search!=null){
        	if(search.getName()!=null && !search.getName().isEmpty()){
        		countCriteria.add(Restrictions.eq("name", search.getName())); 
        		listCriteria.add(Restrictions.eq("name", search.getName())); 
        	}
        }
          	
        listCriteria.setFirstResult((pageNo-1)*pageSize);  
        listCriteria.setMaxResults(pageSize);
        List<Authority> items = listCriteria.list();
        countCriteria.setProjection(Projections.rowCount());
        Integer count=Integer.parseInt(countCriteria.uniqueResult().toString());
        return PageListUtil.getPageList(count, pageNo, items, pageSize);
    }

}
