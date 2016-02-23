package com.fisher.system.dao.daos;

import org.springframework.stereotype.Repository;

import com.fisher.base.dao.daos.ChainEntityDao;
import com.fisher.common.exception.EntityOperateException;
import com.fisher.common.exception.ValidatException;
import com.fisher.system.dao.interfaces.IOrganizationDao;
import com.fisher.system.model.models.Organization;

@Repository("OrganizationDao")
public class OrganizationDao extends ChainEntityDao<Integer, Organization> implements IOrganizationDao {

	@Override
	public void delete(Organization organization) throws EntityOperateException, ValidatException{
		super.checkNull(organization);
		super.checkUpdatable(organization);
		if(organization.getChildren()!=null && !organization.getChildren().isEmpty())
    		throw new ValidatException("The entity has children can't be delete!");
    	else
    		super.getSession().delete(organization);
	}

}
